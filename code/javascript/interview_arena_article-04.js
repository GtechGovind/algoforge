/**
 * Binary search efficiently determines subsequences
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return isSubsequence(...args);
}

var isSubsequence = function(s, t) {
    let i = 0, j = 0;
    while (i < s.length && j < t.length) {
        if (s.charAt(i) === t.charAt(j)) {
            i++;
        }
        j++;
    }
    return i === s.length;
};
