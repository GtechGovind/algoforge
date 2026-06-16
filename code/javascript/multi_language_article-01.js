/**
 * Fix errors in the labuladong quiz plug-in
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return searchMatrix(...args);
}

var searchMatrix = function(matrix, target) {
    var m = matrix.length, n = matrix[0].length;
    var left = 0, right = m * n - 1;
    while(left <= right) {
        var mid = left + Math.floor((right - left) / 2);
        if(get(matrix, mid) == target)
            return true;
        else if (get(matrix, mid) < target)
            left = mid + 1;
        else if (get(matrix, mid) > target)
            right = mid - 1;
    }
    return false;
};
var get = function(matrix, index) {
    var m = matrix.length, n = matrix[0].length;
    var i = Math.floor(index / n), j = index % n;
    return matrix[i][j];
};
