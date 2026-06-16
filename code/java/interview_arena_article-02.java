public class Interview_arena_article_02 {
    /**
     * How to reverse a linked list in groups of k
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Expected: (ListNode head, int k)");
        }

        Solution solution = new Solution();
        return solution.reverseKGroup((ListNode) args[0], (int) args[1]);
    }

    private static class Solution {

        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) return null;
            ListNode a, b;
            a = b = head;
            for (int i = 0; i < k; i++) {
                if (b == null) return head;
                b = b.next;
            }
            ListNode newHead = reverse(a, b);
            a.next = reverseKGroup(b, k);
            return newHead;
        }
        ListNode reverse(ListNode a, ListNode b) {
            ListNode pre, cur, nxt;
            pre = null;
            cur = a;
            nxt = a;
            while (cur != b) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            return pre;
        }
    }
}
