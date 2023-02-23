package leetcode;

public class _203_Remove_Linked_List {
    public ListNode removeElements(ListNode head, int val) {

        // Create currentNode to move to last
        ListNode currentNode = head;
        while (currentNode != null) {

            // check the first node equal val or not
            while (currentNode.val == val) { // in case [val,val,val]
                if (currentNode.next == null) { // in case [val]
                    return null;
                }
                currentNode = currentNode.next;
                head = currentNode;
            }

            // when break while -> the first node not equal val
            if (currentNode.next == null) {// in case [a]
                break;
            }
            // check the next node of currentNode
            if (currentNode.next.val == val) {

                // if val of next currentNode equal val -> link currentNode to next of the next currentNode
                currentNode.next = currentNode.next.next;
                continue; // after link to the new node, keep the currentNode to check new node
            }

            // not change any node move to next node
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
