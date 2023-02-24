package leetcode;


public class RecentCounter {

    public static class MyLinkesListQueue {
        static class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        public MyLinkesListQueue() {
        }

        int size;
        Node head = null, tail = null;

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void add(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
            size++;
        }

        public int pop() {
            if (head == null) {
                return -1;
            }
            int value = head.val;
            if (head == tail) {
                tail = null;
            }
            head = head.next;
            size--;
            return value;
        }

        public int peek() {
            return head.val;
        }

    }

    MyLinkesListQueue queue = new MyLinkesListQueue();

    public RecentCounter() {
    }

    public int ping(int t) {
        while (!queue.isEmpty() && t - queue.peek() > 3000) {
            queue.pop();
        }
        queue.add(t);
        return queue.size();
    }


}
