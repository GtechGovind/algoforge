/**
 * Sliding window algorithm core code template
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return lengthOfLongestSubstring(...args);
}

var lengthOfLongestSubstring = function(s) {
    let window = new Map();
    let left = 0, right = 0, res = 0;
    while (right < s.length) {
        let c = s[right];
        right++;
        window.set(c, (window.get(c) || 0) + 1);
        while (window.get(c) > 1) {
            let d = s[left];
            left++;
            window.set(d, window.get(d) - 1);
        }
        res = Math.max(res, right - left);
    }
    return res;
};
