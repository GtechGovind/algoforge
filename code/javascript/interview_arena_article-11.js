/**
 * How to arrange candidates’ seats
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return ExamRoom(...args);
}

var ExamRoom = function(N) {
    this.startMap = new Map();
    this.endMap = new Map();
    this.pq = new TreeMap((a, b) => {
        let distA = this.distance(a);
        let distB = this.distance(b);
        if (distA === distB) {
            return b[0] - a[0];
        }
        return distA - distB;
    });
    this.N = N;
    this.addInterval([-1, N]);
};
ExamRoom.prototype.seat = function() {
    let longest = this.pq.last();
    let x = longest[0];
    let y = longest[1];
    let seat;
    if (x === -1) {
        seat = 0;
    } else if (y === this.N) {
        seat = this.N - 1;
    } else {
        seat = Math.floor((y - x) / 2) + x;
    }
    let left = [x, seat];
    let right = [seat, y];
    this.removeInterval(longest);
    this.addInterval(left);
    this.addInterval(right);
    return seat;
};
ExamRoom.prototype.leave = function(p) {
    let right = this.startMap.get(p);
    let left = this.endMap.get(p);
    let merged = [left[0], right[1]];
    this.removeInterval(left);
    this.removeInterval(right);
    this.addInterval(merged);
};
ExamRoom.prototype.addInterval = function(intv) {
    this.pq.add(intv);
    this.startMap.set(intv[0], intv);
    this.endMap.set(intv[1], intv);
};
ExamRoom.prototype.removeInterval = function(intv) {
    this.pq.remove(intv);
    this.startMap.delete(intv[0]);
    this.endMap.delete(intv[1]);
};
ExamRoom.prototype.distance = function(intv) {
    let x = intv[0];
    let y = intv[1];
    if (x === -1) {
        return y;
    }
    if (y === this.N) {
        return this.N - 1 - x;
    }
    return Math.floor((y - x) / 2);
};
