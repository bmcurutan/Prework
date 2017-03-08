/*
 Write a function called eval, which takes a string and returns a boolean.
 This string is allowed 6 different characters: 0, 1, &, |, (, and ).
 Eval should evaluate the string as a boolean expression, where 0 is false,
 1 is true, & is an and, and | is an or. An example string might look like
 "(0 | (1 | 0)) & (1 & ((1 | 0) & 1))"
 */

import java.util.*;

public class BitEval {
    public static int eval(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ')') {
                if (s.charAt(i) != ' ') {
                    stack.push(s.charAt(i));
                }
            } else {

                String curr = "";
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    } else {
                        curr += stack.pop();
                    }
                }

                int num1 = curr.charAt(0);
                int num2 = curr.charAt(2);
                int res = 0;
                if (curr.charAt(1) == '|') {
                    res = num1 | num2;
                } else if (curr.charAt(1) == '&') {
                    res = num1 & num2;
                }
                stack.push((char)res);
            }
        }

        char c1 = stack.pop();
        int num1 = c1 == '1' ? 1 : 0;
        char c = stack.pop();
        char c2 = stack.pop();
        int num2 = c2 == '1' ? 1 : 0;
        if (c == '|') {
            return num1 | num2;
        } else if (c == '&') {
            return num1 & num2;
        }

        return -1;
    }

    public static void main(String[] args) {
        // (0 | (1 | 0)) & (1 & ((1 | 0) & 1))
        // 1
        System.out.println(eval("(0 | (1 | 0)) & (1 & ((1 | 0) & 1))"));
    }
}
