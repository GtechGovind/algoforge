/**
 * Interval scheduling problem of greedy algorithm
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return eraseOverlapIntervals(...args);
}

var eraseOverlapIntervals = function(intervals) {
    var n = intervals.length;
    return n - intervalSchedule(intervals);
};
var intervalSchedule = function(intvs) {
    if (intvs.length === 0) return 0;
    intvs.sort((a, b) => a[1] - b[1]);
    var count = 1;
    var x_end = intvs[0][1];
    for (var i = 1; i < intvs.length; i++) {
        var start = intvs[i][0];
        if (start >= x_end) {
            count++;
            x_end = intvs[i][1];
        }
    }
    return count;
};
