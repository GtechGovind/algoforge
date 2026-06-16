public class Interview_arena_article_12 {
    /**
     * How to find prime numbers efficiently
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (int n)");
        }

        Solution solution = new Solution();
        return solution.countPrimes((int) args[0]);
    }

    private static class Solution {

        public int countPrimes(int n) {
            boolean[] isPrime = new boolean[n];
            Arrays.fill(isPrime, true);
            for (int i = 2; i * i < n; i++)
                if (isPrime[i])
                    for (int j = i * i; j < n; j += i)
                        isPrime[j] = false;
            int count = 0;
            for (int i = 2; i < n; i++)
                if (isPrime[i]) count++;
            return count;
        }
    }
}
