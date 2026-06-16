/**
 * How to find missing and duplicate elements at the same time
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return findErrorNums(...args);
}

var findErrorNums = function(nums) {
    var n = nums.length;
    var dup = -1;
    for (var i = 0; i < n; i++) {
        var index = Math.abs(nums[i]) - 1;
        if (nums[index] < 0)
            dup = Math.abs(nums[i]);
        else
            nums[index] *= -1;
    }
    var missing = -1;
    for (var i = 0; i < n; i++)
        if (nums[i] > 0)
            missing = i + 1;
    return [dup, missing];
};
