public class Interview_arena_article_05 {
    /**
     * Thinking framework when actually using binary search
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Expected: (int[] weights, int days)");
        }

        Solution solution = new Solution();
        return solution.shipWithinDays((int[]) args[0], (int) args[1]);
    }

    private static class Solution {

        public int shipWithinDays(int[] weights, int days) {
            int left = 0;
            int right = 1;
            for (int w : weights) {
                left = Math.max(left, w);
                right += w;
            }
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (f(weights, mid) <= days) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
        int f(int[] weights, int x) {
            int days = 0;
            for (int i = 0; i < weights.length; ) {
                int cap = x;
                while (i < weights.length) {
                    if (cap < weights[i]) break;
                    else cap -= weights[i];
                    i++;
                }
                days++;
            }
            return days;
        }
    }
}
