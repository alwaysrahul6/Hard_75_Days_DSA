package HARD_75_DAYS;

import java.util.Arrays;
import java.util.Scanner;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 * Best Time to Buy and Sell Stock III
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *  Find the maximum profit you can achieve. You may complete at most two transactions.
 *  Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *  Example 1:
 *  Input: prices = [3,3,5,0,0,3,1,4]
 *  Output: 6
 *  Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *  Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * */
public class Best_Time_to_Buy_and_Sell_Stock_III {

   // Driver Code
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
    /*  Solutions */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for (int i = 0;i <n; i++){
            for (int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }

        return Stock(0 , 1 ,2, n , prices , dp);
    }
   /*  Memorization */
    private static int Stock(int idx , int buy , int time, int n , int []prices, int[][][] dp){
        if (idx == n || time == 0)return 0;
        if (dp[idx][buy][time] != -1) return dp[idx][buy][time];
        int ans;
        if (buy == 1){
            ans= Math.max(
                    -prices[idx] + Stock(idx + 1 , 0 ,time,n , prices, dp),
                                   Stock(idx + 1 , 1 ,time,n, prices, dp));
        }else ans = Math.max(
                prices[idx] + Stock(idx + 1 , 1 ,time-1,n,prices, dp) ,
                              Stock(idx +1, 0,time, n, prices, dp));
        return dp[idx][buy][time] = ans;
    }

    /* Tabulation */

    private static int tabulation(int []prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 2; k++) {
                dp[i][1][k] = Math.max(
                        -prices[i] + dp[i + 1][0][k],
                        dp[i + 1][1][k]);
                dp[i][0][k] = Math.max(
                        prices[i] + dp[i + 1][1][k - 1],
                        dp[i + 1][0][k]);
            }
        }
        return dp[0][1][2];
    } 
}

