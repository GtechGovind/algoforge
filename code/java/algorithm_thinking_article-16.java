public class Algorithm_thinking_article_16 {
    /**
     * Fancy traversal techniques for two-dimensional arrays
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (String s)");
        }

        Solution solution = new Solution();
        return solution.reverseWords((String) args[0]);
    }

    private static class Solution {

        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != ' ') {
                    sb.append(c);
                } else if (!sb.isEmpty() && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
            if (sb.isEmpty()) {
                return "";
            }
            if (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            char[] chars = sb.toString().toCharArray();
            int n = chars.length;
            reverse(chars, 0, n - 1);
            for (int i = 0; i < n; ) {
                for (int j = i; j < n; j++) {
                    if (j + 1 == n || chars[j + 1] == ' ') {
                        reverse(chars, i, j);
                        i = j + 2;
                        break;
                    }
                }
            }
            return new String(chars);
        }
        void reverse(char[] arr, int i, int j) {
            while (i < j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
    }
}
