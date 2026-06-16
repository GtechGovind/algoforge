/**
 * Queue implementation stack and stack implementation queue
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return MyStack(...args);
}

var MyStack = function() {
    this.q = [];
    this.top_elem = 0;
};
MyStack.prototype.push = function(x) {
    this.q.push(x);
    this.top_elem = x;
};
MyStack.prototype.top = function() {
    return this.top_elem;
};
MyStack.prototype.pop = function() {
    var size = this.q.length;
    while (size > 2) {
        this.q.push(this.q.shift());
        size--;
    }
    this.top_elem = this.q[0];
    this.q.push(this.q.shift());
    return this.q.shift();
};
MyStack.prototype.empty = function() {
    return this.q.length === 0;
};
