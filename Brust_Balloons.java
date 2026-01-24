package HARD_75_DAYS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 *  Burst Balloons
 *  You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
 *  If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
 *  Return the maximum coins you can collect by bursting the balloons wisely.
 *  Example 1:
 *  Input: nums = [3,1,5,8]
 *  Output: 167
 *  Explanation:
 *  nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 *  coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * */
public class Brust_Balloons {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Element");
        String[]s = scanner.nextLine().split(" ");
        int n = s.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println(maxCoins(arr));

    }

    /*Solutions*/

    public static int maxCoins(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(dp[i], -1);
        }
        ArrayList<Integer> tem = new ArrayList<>();
        for (int num : nums) {
            tem.add(num);
        }
        tem.add(1);
        tem.add(0,1);
        return maxCoins(1 , n, tem , dp);
    }

    private static int maxCoins(int i, int j, ArrayList<Integer> tem, int[][] dp) {
        if (i > j)return 0;
        int max = Integer.MIN_VALUE;
        if (dp[i][j] != -1){
            return dp[i][j];
        }

        for (int idx = i; idx <= j;idx++){
            int cost = tem.get(i - 1) * tem.get(idx) * tem.get(j + 1)
                    + maxCoins(i, idx - 1, tem, dp)
                    + maxCoins(idx + 1, j, tem, dp);
            max = Math.max(cost, max);
        }
        return dp[i][j] = max;
    }
}
