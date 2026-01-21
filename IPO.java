package HARD_75_DAYS;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/* # IPO
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
 *  You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
 *  Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
 *  Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.
 *  The answer is guaranteed to fit in a 32-bit signed integer.
 *  Example 1:
 *  Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
 *  Output: 4
 *  Explanation: Since your initial capital is 0, you can only start the project indexed 0.
 *  After finishing it you will obtain profit 1 and your capital becomes 1.
 *  With capital 1, you can either start the project indexed 1 or the project indexed 2.
 *  Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
 *  Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
 * */
public class IPO {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Profits");
        String s[] = scanner.nextLine().split(" ");
        int n = s.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Enter Capital :");
        String s2[] = scanner.nextLine().split(" ");
        int m = s2.length;
        int []capitals = new int[m];
        for (int i = 0; i < m; i++){
            capitals[i] = Integer.parseInt(s2[i]);
        }
        System.out.println("Enter w :");
        int w = scanner.nextInt();
        System.out.println("Enter K :");
        int k = scanner.nextInt();
        System.out.println(STR."The Profit is : \{findMaximizedCapital(k, w, arr, capitals)}");
    }

    /*Solutions*/

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        int project[][] =  new int[n][2];
        for (int i = 0; i < n; i++){
            project[i][0] = capital[i];
            project[i][1] = profits[i];
        }

        Arrays.sort(project , (a ,b) ->a[0] - b[0]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;

        for (int steps = 0; steps < k;steps++){
            while (i < n && project[i][0] <= w  ){
                maxHeap.offer(project[i][1]);
                i++;
            }
            if (maxHeap.isEmpty())return -1;
            w += maxHeap.poll();
        }
        return w;
    }
}
