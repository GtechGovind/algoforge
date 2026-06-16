/**
 * Backtracking algorithm practice: set partitioning
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return backtrack(...args);
}

var canPartitionKSubsets = function(nums, k) {
    let memo = new Map();
    function backtrack(k, bucket, nums, start, used, target) {
        if (k == 0) {
            return true;
        }
        if (bucket == target) {
            let res = backtrack(k - 1, 0, nums, 0, used, target);
            memo.set(used, res);
            return res;
        }
        if (memo.has(used)) {
            return memo.get(used);
        }
        for (let i = start; i < nums.length; i++) {
            if (((used >> i) & 1) == 1) {
                continue;
            }
            if (nums[i] + bucket > target) {
                continue;
            }
            let newUsed = used | (1 << i);
            let newBucket = bucket + nums[i];
            if (backtrack(k, newBucket, nums, i + 1, newUsed, target)) {
                return true;
            }
            newUsed ^= (1 << i);
            newBucket -= nums[i];
        }
        memo.set(used, false);
        return false;
    }
    if (k > nums.length) return false;
    let sum = 0;
    for (let v of nums) sum += v;
    if (sum % k != 0) return false;
    let used = 0;
    let target = sum / k;
    return backtrack(k, 0, nums, 0, used, target);
};
