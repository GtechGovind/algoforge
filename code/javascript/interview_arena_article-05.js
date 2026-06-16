/**
 * Thinking framework when actually using binary search
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return f(...args);
}

var shipWithinDays = function(weights, days) {
    let left = 0;
    let right = 1;
    for (let w of weights) {
        left = Math.max(left, w);
        right += w;
    }
    while (left < right) {
        let mid = left + Math.floor((right - left) / 2);
        if (f(weights, mid) <= days) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;
};
function f(weights, x) {
    let days = 0;
    for (let i = 0; i < weights.length; ) {
        let cap = x;
        while (i < weights.length) {
            if (cap < weights[i]) break;
            else cap -= weights[i];
            i++;
        }
        days++;
    }
    return days;
}
