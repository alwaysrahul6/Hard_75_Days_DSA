package HARD_75_DAYS;

import java.util.Scanner;
import java.util.Stack;
/*
 *  Given an array arr[] with non-negative integers representing the height of blocks.
 *  If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season.]
 *  Examples:
 *  Input: arr[] = [3, 0, 1, 0, 4, 0 2]
 *  Output: 10
 *  Explanation: Total water trapped = 0 + 3 + 2 + 3 + 0 + 2 + 0 = 10 units.
 * */
public class Trapping_Rain_Water {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Heights");
        String[] s = scanner.nextLine().split(" ");
        int n = s.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println(trapWater(arr));
    }

    public int maxWater(int arr[]) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++){
            int leftMax = maxLeft(arr , i);
            int rigthMax = maxRight(arr, i);
            ans += Math.min(leftMax ,rigthMax) - arr[i];
        }
        return ans;
    }

    private int maxRight(int[] arr, int i) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        while (i <= n-1){
            ans = Math.max(ans , arr[i]);
            i++;
        }
        return ans;
    }

    private int maxLeft(int[] arr, int i) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        while (i <= 0){
            ans = Math.max(ans, arr[i]);
            i--;
        }
        return ans;
    }

    /* Approach 2 Using Stack */
    private static int trap(int arr[]){
        int n = arr.length;
        int leftMax[] = maxLeftStack(arr);
        int rightMax[] = maxRightStack(arr);
        int ans = 0;
        for (int i = 0; i < n; i++){
            int newArea = Math.min(leftMax[i] , rightMax[i]);
            ans+= newArea - arr[i];
        }
        return ans;
    }

    private static int[] maxRightStack(int[] arr) {
      int n = arr.length;
      int left[] = new int[n];
      left[0] = arr[0];
      for (int i = 1; i < n; i++){
          left[i] = Math.max(left[i-1],  arr[i]);
      }
      return left;
    }


    private static int[] maxLeftStack(int[] arr) {
        int n = arr.length;
        int right[] = new int[n];
        right[n-1] = arr[n-1];
        for (int i = n-2; i >=0 ;i--){
            right[i] = Math.max(right[i+1] , arr[i]);
        }
        return right;
    }

    /* Approch 3 Two Pointer */

    public static int trapWater(int heights[]){
        int n = heights.length;
        int leftMax = 0;
        int rightmax = 0;
        int left = 0;
        int right = n-1;
        int water = 0;
        while (left < right){
            if (heights[left] <= heights[right]){
                leftMax = Math.max(leftMax , heights[left]);
                water+= leftMax - heights[left];
                left++;
            }else{
                rightmax = Math.max(rightmax, heights[right]);
                water += rightmax - heights[right];
                right--;
            }
        }
        return water;
    }
}
