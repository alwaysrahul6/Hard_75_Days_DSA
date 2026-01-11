package HARD_75_DAYS;
/*  https://leetcode.com/problems/longest-valid-parentheses/description/
 *  #. Largest_Valid_Parentheses
 *  Q. Given a string containing just the characters '(' and ')',
 *     return the length of the longest valid (well-formed) parentheses substring.
 *  Example 1:
 *  Input: s = "(()"
 *  Output: 2
Explanation: The longest valid parentheses substring is "()".*/


import java.util.Stack;

public class Largest_Valid_Parentheses {
    /*Driver Code*/

    public static void main(String[] args) {

        String s = "(())()()";
        System.out.println(longestValidParentheses(s));

    }

    /*Solutions*/

    public static int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int count  = 0;
       for (int i = 0; i < n; i++){
           if (s.charAt(i) == '('){
               stack.push(i);
           }else{
               stack.pop();
               if (stack.isEmpty()){
                   stack.push(i);
               }else {
                   count = Math.max(count , i - stack.peek());
               }
           }
       }
        return count;
    }
}
