package HARD_75_DAYS;

import java.util.HashMap;

/*
 * Minimum Window Substring
 *  Given two strings s and t of lengths m and n respectively,
 *  return the minimum window substring of s such that every character in t
 *  (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *  The testcases will be generated such that the answer is unique.
 *
 *
 * */
public class Minimum_Window_Substring {


    public static void main(String[] args) {


    }

    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n) return "";

        HashMap<Character, Integer> map = new HashMap<>();

        // Build frequency map for t
        for (int k = 0; k < m; k++) {
            char ch = t.charAt(k);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int requiredCount = m;
        int i = 0, j = 0;
        int window = Integer.MAX_VALUE;
        int start = 0;

        while (j < n) {
            char ch = s.charAt(j);

            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    requiredCount--;
                }
                map.put(ch, map.get(ch) - 1);
            }

            // Try to shrink the window
            while (requiredCount == 0) {
                int currLen = j - i + 1;
                if (currLen < window) {
                    window = currLen;
                    start = i;
                }

                char leftChar = s.charAt(i);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        requiredCount++;
                    }
                }
                i++;
            }

            j++;
        }

        return window == Integer.MAX_VALUE ? "" : s.substring(start, start + window);
    }

}
