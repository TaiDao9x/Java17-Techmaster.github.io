package leetcode;

import java.util.Stack;

public class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int val) {
        if (!minSt.isEmpty()){
            if (minSt.peek() >= val){
                minSt.push(val);
            }
        }
        else minSt.push(val);

        st.push(val);
    }

    public void pop() {
        if (minSt.peek().equals(st.peek())) {
            minSt.pop();
        }
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }



    public static void main(String[] args) {
        MinStack minStack = new MinStack();


        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);


        System.out.println();
    }
}
