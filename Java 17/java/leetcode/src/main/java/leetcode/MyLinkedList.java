package leetcode;

public class MyLinkedList {

    int size;
    Node head;

    public MyLinkedList() {

    }

    public int get(int index) {
        Node current = head;
        int count = 0;
        if (index > size) {
            return -1;
        }
        while (current != null) {
            if (count == index) {
                return current.val;
            }
            current = current.next;
            count++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node current = head;
        // check list is empty?
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        while (current != null) {
            if (current.next == null) {
                current.next = newNode;
                break;
            }
            current = current.next;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node current = head;
            Node newNode = new Node(val);
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
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        Node current = head;
        int count = 0;
        if (index == 0) {
            head = current.next;
            size--;
        } else if (index < size) {
            while (current != null) {

                if (count == index - 1) {
                    current.next = current.next.next;
                }
                count++;
                current = current.next;
            }
            size--;
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

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
