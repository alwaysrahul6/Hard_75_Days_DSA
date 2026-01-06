package HARD_75_DAYS;
/*
 * Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
 *  Return the minimized largest sum of the split.
 *  A subarray is a contiguous part of the array.
 *  Example 1:
 *  Input: nums = [7,2,5,10,8], k = 2
 *  Output: 18
 *  Explanation: There are four ways to split nums into two subarrays.
 *  The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.*/
import java.util.Scanner;
public class Split_ArrayLargestSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Element:");
        String s[] = scanner.nextLine().split(" ");
        int n = s.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println("Enter K:");
        int k = scanner.nextInt();
        System.out.println(splitArray(arr ,k));

    }

    public static int splitArray(int[] nums, int k) {
        int n = nums.length;

        int start = 0;
        int end = 0;
        int ans = -1;
        if (k  > n) return  ans;
        for (int j : nums) {
            start = Math.max(start, j);
            end += j;
        }

        while (start <= end){
            int mid = start + (end - start)/2;
            int count = 0;
            int s = 0;
            for (int num : nums) {
                s += num;
                if (s > mid) {
                    s = num;
                    count++;
                }
            }
            if (count <= k) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }
}
