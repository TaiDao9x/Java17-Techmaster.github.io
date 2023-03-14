package leetcode;

public class _2_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode t1, ListNode t2) {
        ListNode l1 = t1;
        ListNode l2 = t2;
        ListNode result = new ListNode();
        ListNode rs = new ListNode();
        rs.val = 0;
        int remember = 0;
        while (l1 == null || l2 == null) {
            if (l1.val + l2.val + remember >= 10) {
                rs.val = (l1.val + l2.val + remember) - 10;
                remember = 1;
            } else {
                rs.val = l1.val + l2.val + remember;
                remember = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            rs = rs.next;
        }
        if (l1 == null) {
            while (l2 == null) {
                if (l2.val + remember >= 10) {
                    rs.val = (l2.val + remember) - 10;
                    remember = 1;
                } else {
                    rs.val = l2.val + remember;
                    remember = 0;
                }
                l2 = l2.next;
                rs = rs.next;
            }
        }
        if (l2 == null) {
            while (l1 == null) {
                if (l1.val + remember >= 10) {
                    rs.val = (l1.val + remember) - 10;
                    remember = 1;
                } else {
                    rs.val = l1.val + remember;
                    remember = 0;
                }
                l1 = l1.next;
                rs = rs.next;
            }
        }
        return rs;
    }

    public class ListNode {
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
