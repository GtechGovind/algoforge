/**
 * How to reverse a linked list in groups of k
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return reverseKGroup(...args);
}

var reverseKGroup = function(head, k) {
    if (!head) return null;
    let a = head, b = head;
    for (let i = 0; i < k; i++) {
        if (!b) return head;
        b = b.next;
    }
    let newHead = reverse(a, b);
    a.next = reverseKGroup(b, k);
    return newHead;
};
var reverse = function(a, b) {
    let pre = null, cur = a, nxt = a;
    while (cur !== b) {
        nxt = cur.next;
        cur.next = pre;
        pre = cur;
        cur = nxt;
    }
    return pre;
};
