public class Algorithm_thinking_article_15 {
    /**
     * Shaobing sorting algorithm
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (int[] cakes)");
        }

        Solution solution = new Solution();
        return solution.pancakeSort((int[]) args[0]);
    }

    private static class Solution {

        LinkedList<Integer> res = new LinkedList<>();
        public List<Integer> pancakeSort(int[] cakes) {
            sort(cakes, cakes.length);
            return res;
        }
        void sort(int[] cakes, int n) {
            if (n == 1) return;
            int maxCake = 0;
            int maxCakeIndex = 0;
            for (int i = 0; i < n; i++)
                if (cakes[i] > maxCake) {
                    maxCakeIndex = i;
                    maxCake = cakes[i];
                }
            reverse(cakes, 0, maxCakeIndex);
            res.add(maxCakeIndex + 1);
            reverse(cakes, 0, n - 1);
            res.add(n);
            sort(cakes, n - 1);
        }
        void reverse(int[] arr, int i, int j) {
            while (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
    }
}
