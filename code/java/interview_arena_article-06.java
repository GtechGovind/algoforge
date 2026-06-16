public class Interview_arena_article_06 {
    /**
     * How to judge palindrome linked list
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (ListNode head)");
        }

        Solution solution = new Solution();
        return solution.isPalindrome((ListNode) args[0]);
    }

    private static class Solution {

        public boolean isPalindrome(ListNode head) {
            ListNode slow, fast;
            slow = fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if (fast != null)
                slow = slow.next;
            ListNode left = head;
            ListNode right = reverse(slow);
            while (right != null) {
                if (left.val != right.val)
                    return false;
                left = left.next;
                right = right.next;
            }
            return true;
        }
        ListNode reverse(ListNode head) {
            ListNode pre = null, cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
