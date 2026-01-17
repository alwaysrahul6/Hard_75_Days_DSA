package HARD_75_DAYS;
/*
 * https://leetcode.com/problems/minimum-falling-path-sum-ii/description/
 * Minimum Falling Path Sum II
 *  Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.
 *  A falling path with non-zero shifts is a choice of exactly one element from each row of grid such that no two elements
 *  chosen in adjacent rows are in the same column.
 *  Example 1:
 *  Input: grid = [[1,2,3],
 *                 [4,5,6],
 *                 [7,8,9]]
 *  Output: 13
 *  Explanation:
 *  The possible falling paths are:
 *  [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 *  [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 *  [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 *  The falling path with the smallest sum is [1,5,7], so the answer is 13.
 *  */
import java.util.Arrays;
import java.util.Scanner;

public class Minimum_Falling_PathSum_II {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n :");
        int n = scanner.nextInt();
        int arr[][] = new int[n][n];
        System.out.println("Enter Element :");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        int ans = minFallingPathSum(arr);
        System.out.println(STR."Minimum \{ans}");
    }
 /* Approch 1*/
    public static int minFallingPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int ans = Integer.MAX_VALUE;
        int [][]dp = new int[n][m];

        for (int[] i : dp){
            Arrays.fill(i , Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++){
            int min = solve(i , 0, n, grid, dp);
            ans = Math.min(ans, min);
        }
        return ans;
    }

    private static int solve(int cols , int rows, int n , int[][] grid, int[][] dp){

        if (rows == n-1)return grid[rows][cols];
        if (dp[rows][cols] != Integer.MAX_VALUE ) return dp[rows][cols];

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++){
            if (cols != n ){
                ans = Math.min(ans , solve(i , rows + 1 , n , grid, dp));
            }
        }
        return dp[rows][cols] = ans + grid[rows][cols];
    }

    /* Approach 2  Bootom Up Approach*/

    public static int minfallingSum(int grid[][]){
        int n = grid.length;
        int tabulation[][] = new int[n][n];

        System.arraycopy(grid[n - 1], 0, tabulation[n - 1], 0, n);

        for (int i = n-2; i >= 0; i--){
            for (int j = 0; j < n; j++){
                int max = Integer.MAX_VALUE;

                for (int nexCols = 0; nexCols < n; nexCols++){
                    if (nexCols != j){
                        max = Math.min(max , tabulation[i+1][nexCols]);
                    }
                }
                tabulation[i][j] = max + grid[i][j];
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++){
            result = Math.min(result , tabulation[0][i]);
        }
        return result;
    }
}
