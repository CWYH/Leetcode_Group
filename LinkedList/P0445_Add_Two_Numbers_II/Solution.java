class Solution {
    /**
     * Definition for singly-linked list.
    */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = reverseList(l1);
        ListNode h2 = reverseList(l2);
        ListNode res = new ListNode(-1);
        ListNode x = res;
        int a = 0;
        int b = 0;
        int carry = 0;
        ListNode x1 = h1;
        ListNode x2 = h2;
        while (x1 != null || x2 != null) {
            a = x1 == null ? 0 : x1.val;
            b = x2 == null ? 0 : x2.val;
            if (x1 != null) x1 = x1.next;
            if (x2 != null) x2 = x2.next;
            int r = a + b + carry;
            if (r >= 10) {
                r -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            x.next = new ListNode(r);
            x = x.next;
        }
        if (carry == 1) x.next = new ListNode(1);
        res = reverseList(res.next);
        return res;
    }

    private ListNode reverseList(ListNode l) {
        if (l == null) return null;
        ListNode x = l;
        ListNode y = l.next;
        ListNode c = null;
        while (x != null) {
            x.next = c;
            c = x;
            x = y;
            if (y != null) y = y.next;
        }

        return c;
    }

    public ListNode getList(int[] A) {
        ListNode res = new ListNode(-1);
        ListNode x = res;
        for (int i = 0; i < A.length; i++) {
            x.next = new ListNode(A[i]);
            x = x.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A1 = {7, 2, 4, 3};
        int[] A2 = {5, 6, 4};
        ListNode l1 = s.getList(A1);
        ListNode l2 = s.getList(A2);
        ListNode res = s.addTwoNumbers(l1, l2);
        for (ListNode x = res; x != null; x = x.next) {
            System.out.println(x.val);
        }
    }
        
}