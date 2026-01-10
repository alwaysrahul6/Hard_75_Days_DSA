package HARD_75_DAYS;

import java.util.ArrayDeque;
import java.util.Scanner;

/*
 * Sliding Window Maximum
 *
 * Sliding Window MaximumYou are given an array of integers nums,
 *  there is a sliding window of size k which is moving from the very left of the array to the very right.
 *  You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Example 1:
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * */
public class Sliding_Window_Maximum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Element :");
        String s[] = scanner.nextLine().split(" ");
        int n = s.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println("Enter  k");
        int k = scanner.nextInt();
        int [] res = maxSlidingWindow1(arr , k);
        for (int re : res) {
            System.out.println(re);
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int []res = new int[n - k + 1];
         if (n == 0 || k == 0) return new int[0];
        for(int i = 0; i <= n - k; i++){
            int ans = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++){
                ans = Math.max(ans , nums[j]);
            }
            res[i] = ans;
        }
        return res;
    }

    static int[] maxSlidingWindow1(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n - k + 1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) dq.pollLast();
            dq.addLast(i);
        }
        ans[0] = arr[dq.peekFirst()];

        for (int i = k; i < n; i++) {
            if (dq.peekFirst() == i - k) dq.pollFirst();
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) dq.pollLast();
            dq.addLast(i);
            ans[i - k + 1] = arr[dq.peekFirst()];
        }

        return ans;
    }
}
