package HARD_75_DAYS;

import java.util.TreeMap;

/*
 * Sliding Window Median
 *  The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle values.
 *  For examples, if arr = [2,3,4], the median is 3.
 *  For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
 *  You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *  Return the median array for each window in the original array. Answers within 10-5 of the actual value will be accepted.
 *  Example 1:
 *  Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 *  Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
 *  Explanation:

   * ---------------                -----
   *  [1  3  -1] -3  5  3  6  7        1
   *  1 [3  -1  -3] 5  3  6  7       -1
   *  1  3 [-1  -3  5] 3  6  7       -1
   *  1  3  -1 [-3  5  3] 6  7        3
   *  1  3  -1  -3 [5  3  6] 7        5
   *  1  3  -1  -3  5 [3  6  7]       6
 * */
public class Sliding_Window_Median {
    public class Main {
        public static void main(String[] args) {

            int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
            int k = 3;

            double[] result = medianSlidingWindow(nums, k);

            for (double d : result) {
                System.out.print(d + " ");
            }
        }
    }


       static TreeMap<Integer, Integer> leftTree = new TreeMap<>();
        static TreeMap<Integer, Integer> rightTree = new TreeMap<>();
        static int rigthCount;
        static int leftCount;

        public static double[] medianSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            double[] ans = new double[n - k + 1];

            for (int i = 0; i < k; i++) {
                add(nums[i]);
            }
            ans[0] = findMedian();

            for (int j = k; j < n; j++) {
                remove(nums[j - k]);
                add(nums[j]);
                ans[j - k + 1] = findMedian();
            }
            return ans;
        }

        private static void add(int num) {
            if (rigthCount == 0 || num >= rightTree.firstKey()) {
                rightTree.put(num, rightTree.getOrDefault(num, 0) + 1);
                rigthCount++;
            } else {
                leftTree.put(num, leftTree.getOrDefault(num, 0) + 1);
                leftCount++;
            }
            rebalance();
        }

        private static void rebalance() {
            if (leftCount > rigthCount) {
                int val = leftTree.lastKey();
                int cnt = leftTree.get(val);
                if (cnt == 1) leftTree.remove(val);
                else leftTree.put(val, cnt - 1);
                leftCount--;

                rightTree.put(val, rightTree.getOrDefault(val, 0) + 1);
                rigthCount++;
            } else if (rigthCount > leftCount + 1) {
                int val = rightTree.firstKey();
                int cnt = rightTree.get(val);
                if (cnt == 1) rightTree.remove(val);
                else rightTree.put(val, cnt - 1);
                rigthCount--;

                leftTree.put(val, leftTree.getOrDefault(val, 0) + 1);
                leftCount++;
            }
        }

        public static void remove(int num) {
            Integer val = leftTree.get(num);
            if (val != null) {
                if (val == 1) leftTree.remove(num);
                else leftTree.put(num, val - 1);
                leftCount--;
            } else {
                val = rightTree.get(num);
                if (val != null) {
                    if (val == 1) rightTree.remove(num);
                    else rightTree.put(num, val - 1);
                    rigthCount--;
                }
            }
            rebalance();
        }

        private static double findMedian() {
            if (leftCount == rigthCount) {
                int l = leftTree.lastKey();
                int r = rightTree.firstKey();
                return l + ((long) r - l) / 2.0;
            } else {
                return rightTree.firstKey();
            }
        }
    }

