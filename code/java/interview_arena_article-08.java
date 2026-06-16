public class Interview_arena_article_08 {
    /**
     * Backtracking algorithm instantly kills all permutation/combination/subset problems
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Expected: (int[] candidates, int target)");
        }

        Solution solution = new Solution();
        return solution.combinationSum((int[]) args[0], (int) args[1]);
    }

    private static class Solution {

        List<List<Integer>> res = new LinkedList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates.length == 0) {
                return res;
            }
            backtrack(candidates, 0, target, 0);
            return res;
        }
        LinkedList<Integer> track = new LinkedList<>();
        void backtrack(int[] candidates, int start, int target, int sum) {
            if (sum == target) {
                res.add(new LinkedList<>(track));
                return;
            }
            if (sum > target) {
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                track.add(candidates[i]);
                sum += candidates[i];
                backtrack(candidates, i, target, sum);
                sum -= candidates[i];
                track.removeLast();
            }
        }
    }
}
