package leetcode;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack; // Create stack to contain value

    Stack<Integer> min; // Crete min to contain min value


    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min.push(val);
        } else {
            if (val <= min.peek()) {
                min.push(val);
            }
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.peek().equals(min.peek())) {
            min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    //  stack   min
    //  [-3]
    //  [0]     [-3]
    //  [-2]    [-2]
}
