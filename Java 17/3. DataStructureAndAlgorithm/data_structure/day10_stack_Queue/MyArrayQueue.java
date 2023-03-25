package day10_stack_Queue;


public class MyArrayQueue {
    // FIFO: first in first out
    private static final int SIZE = 100;
    static int[] arr;
    static int head, tail;

    public MyArrayQueue() {

    }

    public static int getSize() {
        // return size
        return tail - head;
    }

    public static int getFirst() {
        // return first element
        return arr[head];
    }

    public static int removeFirst() {
        // remove the first element and return

        if (head == tail) {
            return -1;
        }
        int valueRemove = arr[head];
        arr[head] = 0;
        head++;
        return valueRemove;
    }

    public static void push(int val) {
        // add a new element into queue

        arr[tail] = val;
        tail++;

    }

    public static void print() {
        for (int i = head; i < tail; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {
        arr = new int[SIZE];
        push(1);
        push(2);
        push(3);
        push(4);
        print();
        System.out.println();
        removeFirst();
        print();
        System.out.println(getSize());

    }
}
