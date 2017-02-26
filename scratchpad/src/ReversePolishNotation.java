import java.util.*;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Examples:

["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class ReversePolishNotation {
    public static String calculate(String[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        } if (arr.length == 1) {
            return arr[0];
        }

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            if (!(temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/"))) {
                stack.push(temp);
            } else { // operator
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                if (temp.equals("+")) {
                    stack.push(Integer.toString(a + b));
                } else if (temp.equals("-")) {
                    stack.push(Integer.toString(a - b));
                } else if (temp.equals("*")) {
                    stack.push(Integer.toString(a * b));
                } else if (temp.equals("/")) {
                    stack.push(Integer.toString(a / b));
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] a = { "2", "1", "+", "3", "*" };
        System.out.println(calculate(a)); // 9

        String[] b = { "4", "13", "5", "/", "+" };
        System.out.println(calculate(b)); // 6

        String[] c = { "4", "13", "+" };
        System.out.println(calculate(c)); // 17
    }
}
