package leetcode;

import java.util.Stack;

public class _20_Valid_Parentheses {

    // Use a stack to save parentheses
    // Convert String s to char Array
    // Loop from head to last Array
    // if the first element of Array is ')' || ']' || '}' -> stack is empty -> return false
    // if c == '(' or '[' or '{' -> opposite of c in order is: ')' or ']' or '}'
    // so we push ')' or ']' or '}' into stack to check later
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
