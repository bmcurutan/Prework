package NotDone;/*
Longest Valid Parentheses
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2. Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

#### Bonus 1 - Can you return the string with the longest valid parentheses?
 */

import java.util.*;

public class LongestValidParentheses {
    public static int longestParens(String s) {
        int max = 0;
        if (s == null || s.length() <= 1) {
            return max;
        }

        int temp = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty()) {
                temp += 2;
                stack.pop();
                if (temp > max) {
                    max = temp;
                }
            } else {
                if (temp > max) {
                    max = temp;
                }
                temp = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestParens("(()")); // 2
        System.out.println(longestParens("(()()(")); // 4
        System.out.println(longestParens("(())")); // 4
        System.out.println(longestParens("(()()(()()()")); // 6
    }
}
