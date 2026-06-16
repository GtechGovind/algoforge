/**
 * Summary of fancy reversal methods for singly linked lists
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return reverseList(...args);
}

var reverseList = function(head) {
    if (head === null || head.next === null) {
        return head;
    }
    var last = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return last;
};
