public class Multi_language_article_01 {
    /**
     * Fix errors in the labuladong quiz plug-in
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Expected: (int[][] matrix, int target)");
        }

        Solution solution = new Solution();
        return solution.searchMatrix((int[][]) args[0], (int) args[1]);
    }

    private static class Solution {

        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int left = 0, right = m * n - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(get(matrix, mid) == target)
                    return true;
                else if (get(matrix, mid) < target)
                    left = mid + 1;
                else if (get(matrix, mid) > target)
                    right = mid - 1;
            }
            return false;
        }
        int get(int[][] matrix, int index) {
            int m = matrix.length, n = matrix[0].length;
            int i = index / n, j = index % n;
            return matrix[i][j];
        }
    }
}
