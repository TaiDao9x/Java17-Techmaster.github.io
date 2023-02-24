import java.util.Scanner;
import java.util.Stack;

public class main {


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());
        if (stack.pop()>0){
            System.out.println("hahaa");
        }
        System.out.println(stack.peek());

    }
}
