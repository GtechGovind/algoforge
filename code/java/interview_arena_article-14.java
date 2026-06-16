public class Interview_arena_article_14 {
    /**
     * How to find missing and duplicate elements at the same time
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (int[] nums)");
        }

        Solution solution = new Solution();
        return solution.findErrorNums((int[]) args[0]);
    }

    private static class Solution {

        public int[] findErrorNums(int[] nums) {
            int n = nums.length;
            int dup = -1;
            for (int i = 0; i < n; i++) {
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] < 0)
                    dup = Math.abs(nums[i]);
                else
                    nums[index] *= -1;
            }
            int missing = -1;
            for (int i = 0; i < n; i++)
                if (nums[i] > 0)
                    missing = i + 1;
            return new int[]{dup, missing};
        }
    }
}
