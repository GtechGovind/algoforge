/**
 * How to efficiently solve the problem of rainwater collection
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return maxArea(...args);
}

var maxArea = function(height) {
    let left = 0, right = height.length - 1;
    let res = 0;
    while (left < right) {
        const cur_area = Math.min(height[left], height[right]) * (right - left);
        res = Math.max(res, cur_area);
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    return res;
};
