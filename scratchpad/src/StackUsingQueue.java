/*
Implement the following operations of a stack using queues.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
 */

import java.util.*;

public class StackUsingQueue {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public void pop() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        q1 = q2;
        q2 = new LinkedList<>();
    }

    public int top() {
        if (empty()) {
            return -1;
        }
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int res = q1.poll();
        q1 = q2;
        q2 = new LinkedList<>();
        return res;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        System.out.println(stack.empty()); // true
        System.out.println(stack.top()); // -1
        stack.push(5); // 5
        stack.push(4); // 4 5
        stack.push(3); // 3 4 5
        stack.pop(); // 4 5
        System.out.println(stack.top()); // 4
        System.out.println(stack.empty()); // false
    }
}
