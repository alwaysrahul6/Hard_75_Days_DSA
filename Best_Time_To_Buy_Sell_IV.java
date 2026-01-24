package HARD_75_DAYS;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Q. Best Time to Buy and Sell Stock IV
 *  You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 *  Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
 *  Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *  Example 1:
 *  Input: k = 2, prices = [2,4,1]
 *  Output: 2
 *  Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * */
public class Best_Time_To_Buy_Sell_IV {

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Element :");
            String s[] = scanner.nextLine().split(" ");
            int n = s.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            System.out.println(maxProfit(arr));
    }

    /*Solutions*/
    static int sum = Integer.MIN_VALUE;
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][3];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

         maxSum(0 , 0 ,  3 , n,prices,dp);
        return sum;

    }

    private static int maxSum(int idx, int buy, int k, int n, int[] prices, int[][][] dp) {
        if (idx == n)return 0;
        if (k == 0)return 0;
        if (dp[idx][buy][k] != -1)return dp[idx][buy][k];
        if (buy == 0){
            sum = Math.max(-prices[idx] + maxSum(idx + 1 , 1 , k , n , prices, dp),maxSum(idx + 1 , 0,k ,n,prices, dp) );
        }else {
            sum = Math.max(prices[idx] + maxSum(idx + 1, 0,k-1 ,n,prices, dp) ,maxSum(idx + 1 , 1 , k , n , prices, dp));
        }
        return dp[idx][buy][k]  = sum;
    }

}
