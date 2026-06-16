/**
 * Commonly used bit operations
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return singleNumber(...args);
}

var singleNumber = function(nums) {
    let res = 0;
    for (let n of nums) {
        res ^= n;
    }
    return res;
};
