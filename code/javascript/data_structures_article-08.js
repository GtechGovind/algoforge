/**
 * Monotone stack algorithm template to solve three example problems
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return nextGreaterElement(...args);
}

var nextGreaterElement = function(nums1, nums2) {
    var greater = nextGreater(nums2);
    var greaterMap = new Map();
    for (var i = 0; i < nums2.length; i++) {
        greaterMap.set(nums2[i], greater[i]);
    }
    var res = new Array(nums1.length);
    for (var i = 0; i < nums1.length; i++) {
        res[i] = greaterMap.get(nums1[i]);
    }
    return res;
};
var nextGreater = function(nums) {
    var n = nums.length;
    var res = new Array(n);
    var s = [];
    for (var i = n - 1; i >= 0; i--) {
        while (s.length && s[s.length-1] <= nums[i]) {
            s.pop();
        }
        res[i] = s.length == 0 ? -1 : s[s.length-1];
        s.push(nums[i]);
    }
    return res;
};
