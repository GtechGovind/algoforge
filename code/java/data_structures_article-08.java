public class Data_structures_article_08 {
    /**
     * Monotone stack algorithm template to solve three example problems
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Expected: (int[] nums1, int[] nums2)");
        }

        Solution solution = new Solution();
        return solution.nextGreaterElement((int[]) args[0], (int[]) args[1]);
    }

    private static class Solution {

        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] greater = nextGreaterElement(nums2);
            HashMap<Integer, Integer> greaterMap = new HashMap<>();
            for (int i = 0; i < nums2.length; i++) {
                greaterMap.put(nums2[i], greater[i]);
            }
            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                res[i] = greaterMap.get(nums1[i]);
            }
            return res;
        }
        int[] nextGreaterElement(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            Stack<Integer> s = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                while (!s.isEmpty() && s.peek() <= nums[i]) {
                    s.pop();
                }
                res[i] = s.isEmpty() ? -1 : s.peek();
                s.push(nums[i]);
            }
            return res;
        }
    }
}
