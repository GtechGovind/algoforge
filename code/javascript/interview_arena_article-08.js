/**
 * Backtracking algorithm instantly kills all permutation/combination/subset problems
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return backtrack(...args);
}

var combinationSum = function(candidates, target) {
    let res = [];
    let track = [];
    backtrack(candidates, 0, target, 0, track);
    return res;
    function backtrack(candidates, start, target, sum, track) {
        if (sum === target) {
            res.push([...track]);
            return;
        }
        if (sum > target) {
            return;
        }
        for (let i = start; i < candidates.length; i++) {
            track.push(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, i, target, sum, track);
            sum -= candidates[i];
            track.pop();
        }
    }
};
