package HARD_75_DAYS;
/*
 * Q. Maximal Rectangle
 *  Given a rows x cols binary matrix filled with 0's and 1's,
 *  find the largest rectangle containing only 1's and return its area.
 *  Example 1:
 *  Input: matrix = [["1","0","1","0","0"],
 *                   ["1","0","1","1","1"],
 *                   ["1","1","1","1","1"],
 *                   ["1","0","0","1","0"]]
 *  Output: 6
 *  Explanation: The maximal rectangle is shown in the above picture.
 * */
import java.util.Stack;

public class Maximal_Rectangle {
    /*Driver Code*/

    public static void main(String[] args) {


        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        int result = maximalRectangle(matrix);
        System.out.println("Maximal Rectangle Area: " + result);
    }
    /* Solutions */

    public static int maximalRectangle(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        int arr[] = new int[m];
        for (char []ch : matrix){
            for (int i = 0; i < m; i++){
                int chh = ch[i] - '0';
                if (chh == 0) arr[i] = 0;
                else arr[i]++;
            }
            max = Math.max(max , longestRectangleHistogram(arr));
        }
        return max;

    }

    private static int longestRectangleHistogram(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : arr[i];

            while (!stack.isEmpty() && h < arr[stack.peek()]) {
                int height = arr[stack.pop()];
                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = right - left - 1;
                int area = height * width;
                max = Math.max(max, area);
            }

            stack.push(i);
        }
        return max;
    }
}
