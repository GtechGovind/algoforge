public class Interview_arena_article_13 {
    /**
     * How to efficiently solve the problem of rainwater collection
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (int[] height)");
        }

        Solution solution = new Solution();
        return solution.maxArea((int[]) args[0]);
    }

    private static class Solution {

        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int res = 0;
            while (left < right) {
                int cur_area = Math.min(height[left], height[right]) * (right - left);
                res = Math.max(res, cur_area);
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return res;
        }
    }
}
