package leetcode;

import java.util.Stack;

// Answer 1

// Use 2 Stack: stack and min (save min value)
// If stack is empty -> push val into both stack and min (the first element)
// If not we compare val vs top of min -> if val<=min -> push val into min and stack
// when call method pop(), we compare value need to pop vs value at top of min
// If equal we pop both stack and min
// getMin always is value at top of min

//  stack   min
//  [-3]
//  [0]     [-3]
//  [-2]    [-2]
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min;

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
        if (stack.pop().equals(min.peek())) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}


// Answer 2

// Use a stack(Stack) and a variable min(int)
// if stack empty -> min= val and push val into stack
// in another next push, we compare min vs val. If val<=min (we have new min)
// -> push min into stack first, after that push val
// when use method pop(): compare the value need to pop vs min (do pop() once)
// If pop == min -> assign min == pop() (do pop() tiwce)

//  [-3]    [0]
//  [-2]    [0]
//   [0]    [1]
//  [-2]    [0]
public class MinStack2 {

    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public MinStack() {
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
        } else {
            if (val <= min) {
                stack.push(min);
                min = val;
            }
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.pop() == min) {
            if (!stack.isEmpty()) {
                min = stack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
