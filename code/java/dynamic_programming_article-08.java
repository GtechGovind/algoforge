public class Dynamic_programming_article_08 {
    /**
     * Thinking transformation between dynamic programming and backtracking algorithms
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Expected: (String s, List<String> wordDict)");
        }

        Solution solution = new Solution();
        return solution.wordBreak((String) args[0], (List<String>) args[1]);
    }

    private static class Solution {

        List<String> res = new LinkedList<>();
        LinkedList<String> track = new LinkedList<>();
        public List<String> wordBreak(String s, List<String> wordDict) {
            backtrack(s, 0, wordDict);
            return res;
        }
        void backtrack(String s, int i, List<String> wordDict) {
            if (i == s.length()) {
                res.add(String.join(" ", track));
                return;
            }
            if (i > s.length()) {
                return;
            }
            for (String word : wordDict) {
                int len = word.length();
                if (i + len > s.length()) {
                    continue;
                }
                String subStr = s.substring(i, i + len);
                if (!subStr.equals(word)) {
                    continue;
                }
                track.addLast(word);
                backtrack(s, i + len, wordDict);
                track.removeLast();
            }
        }
    }
}
