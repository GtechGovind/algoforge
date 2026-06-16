public class Interview_arena_article_03 {
    /**
     * Algorithm problems that can be solved with one line of code
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (int n)");
        }

        Solution solution = new Solution();
        return solution.canWinNim((int) args[0]);
    }

    private static class Solution {

        public boolean canWinNim(int n) {
            return n % 4 != 0;
        }

    }

}
