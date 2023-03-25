package leetcode;

public class _21_Merge_Two_Sorted_Lists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Create a new node to link after compare (list1.val vs list2.val)
        ListNode rs = new ListNode();

        // Create currentNode to move from head to last of linkedList rs
        ListNode currentNode = rs;

        while (list1 != null && list2 != null) {

            // Compare two val of list1, list2 -> Find smaller val -> link node
            if (list1.val < list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
            }

            // After link node -> move to next node of rs
            currentNode = currentNode.next;
        }

        // Check list1 or list2 is end
        if (list1 == null) {
            currentNode.next = list2;
        } else currentNode.next = list1;

        return rs.next;
    }

    public static class ListNode {
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
