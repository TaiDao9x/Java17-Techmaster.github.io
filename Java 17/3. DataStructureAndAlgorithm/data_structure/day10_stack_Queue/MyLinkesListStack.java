package day10_stack_Queue;

import java.util.Stack;

public class MyLinkesListStack {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

    }

    static Node head;
    static int size;

    public static void push(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public static int pop() {
        if (head == null) {
            return -1;
        }
        int val = head.val;
        head = head.next;
        size--;
        return val;
    }

    public static int peek() {
        if (head == null) {
            return -1;
        }
        return head.val;
    }

    public static boolean isEmpty() {
        return head == null;
    }

    public static void print() {
        Node currntNode = head;
        while (currntNode != null) {
            System.out.print(currntNode.val + ", ");
            currntNode = currntNode.next;
        }
    }

    public static void main(String[] args) {
        push(0);

        push(-2);
        push(0);

        push(-3);
        push(3);
        push(0);

        print();

    }

}
