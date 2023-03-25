package day09_linked_list;

public class MyLinkedList {
    public static void main(String[] args) {
        Node n0 = new Node(0);
//        Node n1 = new Node(1);
//        Node n2 = new Node(2);
//        Node n3 = new Node(3);
//        Node n4 = new Node(4);
//        Node n5 = new Node(5);

//        n0.next = n1;
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;

//        printList(n0);

        // how to find the element with index = 4 -> expect = n4 (val = 4)
//        System.out.println(elementAt(n0, 10));

        // insert
//        insert(n0, 3, 50);

//        printList(insertAtHead(n0, -10));
//        insertAtTail(null, 100);

        printList(remove(n0, 0));

    }

    private static Node remove(Node head, int index) {
        Node current = head;
        int count = 0;
        if (index == 0) {
            return current.next;
        }
        while (current != null) {
            if (count == index - 1) {
                current.next = current.next.next;
            }
            count++;
            current = current.next;
        }
        return head;
    }

    private static Node insertAtTail(Node head, int value) {
        Node newNode = new Node(value);
        Node current = head;
        // check list is empty?
        if (head == null) {
            return newNode;
        }
        while (current != null) {
            if (current.next == null) {
                current.next = newNode;
                break;
            }
            current = current.next;
        }
        return head;
    }

    private static Node insertAtHead(Node head, int value) {
        Node newNode = new Node(value);
        newNode.next = head;
//        head = newNode;
        return newNode;
    }

    private static void insert(Node head, int index, int value) {

        // find the node preveous of index Node
        // link newNode to nextNode of previous node
        // link the previous node to newNode
        Node current = head;
        Node newNode = new Node(value);
        int count = 0;

        while (current != null) {
            if (count == index - 1) {
                newNode.next = current.next;
                current.next = newNode;
                break;
            }
            count++;
            current = current.next;
        }
    }

    private static int elementAt(Node head, int index) {
        Node current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.val;
            }
            current = current.next;
            count++;
        }
        return -1;
    }

    private static void printList(Node head) {
        Node current = head; // current point to the head of List
        while (current != null) {
            // process current node
            System.out.print(current.val + "->");
            // process current node conplete

            // move to next node
            current = current.next;
        }
    }


    static class Node {
        public int val;
        public Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
