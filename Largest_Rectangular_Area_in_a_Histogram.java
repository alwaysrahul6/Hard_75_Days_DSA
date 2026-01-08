package HARD_75_DAYS;
/* https://www.geeksforgeeks.org/dsa/largest-rectangular-area-in-a-histogram-using-stack/
 * Largest Rectangular Area in a Histogram
 *
 * Given an array arr[] representing a histogram, where each element denotes the height of a bar and every bar has a uniform width of 1 unit, find the largest rectangular area that can be formed within the histogram. The rectangle must be formed using contiguous bars.
 *  Example:
 *  Input: arr[] = [60, 20, 50, 40, 10, 50, 60]
 *  Output: 100
 *  Explanation: We get the maximum area by picking bars highlighted above in green (50, and 60). The area is computed (smallest height) * (no. of the picked bars) = 50 * 2 = 100.
 * */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Largest_Rectangular_Area_in_a_Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Element :");
        String s[] = scanner.nextLine().split(" ");
        int n = s.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println(largestRectangleArea(arr));

    }

    public static int largestRectangleArea(int[] heights) {

        int n = heights.length-1;
        int ans = 0;
        for (int i = 0; i <= n; i++){
            int widht = 1;
            int left = i - 1;
            while (left >= 0 && heights[left] >= heights[i]){
                widht++;
                left--;
            }

            int rigth = i + 1;
            while (rigth <= n && heights[rigth] >= heights[i]){
                widht++;
                rigth++;
            }
            ans = Math.max(ans , widht * heights[i]);
        }
        return ans;
    }

    /*Second Approach*/

    static int[] nse(int []arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];

        for (int i = 0; i < n; i++){

            while (!stack.isEmpty() && arr[stack.peek()]>= arr[i]){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    static int[] nge(int arr[]){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];
        for (int i = n-1; i >= 0; i--){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? n: stack.peek();
            stack.push(i);
        }
        return ans;
    }

    static int rectangle(int arr[]){
        int n = arr.length;
        int nse[] = nse(arr);
        int pse[] = nge(arr);
        int area = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            int width = nse[i] - pse[i]-1;
            area = Math.max(area , width * arr[i]);
        }
        return area;
    }
}
