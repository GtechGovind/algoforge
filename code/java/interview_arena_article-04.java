public class Interview_arena_article_04 {
    /**
     * Binary search efficiently determines subsequences
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Expected: (String s, String t)");
        }

        Solution solution = new Solution();
        return solution.isSubsequence((String) args[0], (String) args[1]);
    }

    private static class Solution {

        public boolean isSubsequence(String s, String t) {
            int i = 0, j = 0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                }
                j++;
            }
            return i == s.length();
        }
    }
}
