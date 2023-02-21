package leetcode;

public class _203_Remove_Linked_List {
    public ListNode removeElements(ListNode head, int val) {

        ListNode currentNode = head;
        while (currentNode != null) {
            while (currentNode.val == val) {
                if (currentNode.next == null) {
                    return null;
                }
                currentNode = currentNode.next;
                head = currentNode;
            }
            if (currentNode.next == null) {
                break;
            }
            if (currentNode.next.val == val) {
                currentNode.next = currentNode.next.next;
                continue;
            }
            currentNode = currentNode.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
