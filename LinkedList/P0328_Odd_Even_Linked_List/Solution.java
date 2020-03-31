
class Solution {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        int i = 0;
        ListNode o = odd;
        ListNode e = even;
        ListNode x = head;
        while (x != null) {
            if (i == 0) {
                o.next = x;
                o = o.next;
                x = x.next;
                o.next = null;
            } else {
                e.next = x;
                e = e.next;
                x = x.next;
                e.next = null;
            }
            i = (i + 1) % 2;
        }
        o.next = even.next;
        return odd.next;
    }
}
