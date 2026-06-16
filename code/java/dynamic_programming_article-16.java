public class Dynamic_programming_article_16 {
    /**
     * Interval scheduling problem of greedy algorithm
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (int[][] intervals)");
        }

        Solution solution = new Solution();
        return solution.eraseOverlapIntervals((int[][]) args[0]);
    }

    private static class Solution {

        public int eraseOverlapIntervals(int[][] intervals) {
            int n = intervals.length;
            return n - intervalSchedule(intervals);
        }
        int intervalSchedule(int[][] intvs) {
            if (intvs.length == 0) return 0;
            Arrays.sort(intvs, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[1] - b[1];
                }
            });
            int count = 1;
            int x_end = intvs[0][1];
            for (int[] interval : intvs) {
                int start = interval[0];
                if (start >= x_end) {
                    count++;
                    x_end = interval[1];
                }
            }
            return count;
        }
    }
}
