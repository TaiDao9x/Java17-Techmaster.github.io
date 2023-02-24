package day10_stack_Queue;

public class MyLinkedListQueue {
    static class Node {
        int val;
        Node next;


        public Node(int val) {
            this.val = val;
        }
    }

    static int size;

    static Node head = null, tail = null;

    public static int getSize() {
        // return size
        return size;
    }

    public static int getFirst() {
        // return first element

        if (head == null) {
            return -1;
        }
        return head.val;
    }

    public static int removeFirst() {
        // remove the first element and return
        Node currentNode = head;
        if (head == null) {
            return -1;
        }
        if (head == tail) { // have only one element
            tail = null;
        }
        head = head.next;

        size--;
        return currentNode.val;
    }

    public static void push(int val) {
        // add a new element into queue
        Node newNode = new Node(val);

        if (head == null) {
            tail = newNode;
            head = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    public static boolean isEmpty() {
        return head == null;
    }

    public static void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        print();
        System.out.println();
        removeFirst();
        print();
        System.out.println(isEmpty());

        System.out.println();
        removeFirst();
        print();
        System.out.println(isEmpty());

        System.out.println(removeFirst());
        System.out.println(isEmpty());
    }
}
