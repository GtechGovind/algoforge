/**
 * Check if a numeric string can be split into an additive sequence.
 */
public class Multi_language_solution_code {
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (String num)");
        }
        return new Solution().isAdditiveNumber(String.valueOf(args[0]));
    }

    private static class Solution {
        public boolean isAdditiveNumber(String num) {
            int n = num.length();
            for (int i = 1; i <= n; i++) {
                String first = num.substring(0, i);
                for (int j = i + 1; j <= n; j++) {
                    String second = num.substring(i, j);
                    if (isValid(num, first, second)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean isValid(String num, String first, String second) {
            if (first.startsWith("0") && first.length() > 1 || second.startsWith("0") && second.length() > 1) {
                return false;
            }
            String sumStr = strAdd(first, second);
            String next = num.substring(first.length() + second.length());
            if (!next.startsWith(sumStr)) {
                return false;
            }
            if (next.equals(sumStr)) {
                return true;
            }
            return isValid(num.substring(first.length()), second, sumStr);
        }

        private String strAdd(String a, String b) {
            int i = a.length() - 1;
            int j = b.length() - 1;
            int add = 0;
            StringBuilder builder = new StringBuilder();

            while (i >= 0 || j >= 0 || add != 0) {
                int x = i >= 0 ? a.charAt(i) - '0' : 0;
                int y = j >= 0 ? b.charAt(j) - '0' : 0;
                int result = x + y + add;
                builder.append(result % 10);
                add = result / 10;
                i--;
                j--;
            }
            return builder.reverse().toString();
        }
    }
}
