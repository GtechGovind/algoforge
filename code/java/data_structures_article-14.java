public class Data_structures_article_14 {
    /**
     * Summary of fancy reversal methods for singly linked lists
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (ListNode head)");
        }

        Solution solution = new Solution();
        return solution.reverseList((ListNode) args[0]);
    }

    private static class Solution {

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }
    }
}
