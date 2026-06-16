public class Data_structures_article_10 {
    /**
     * Basics of graph theory algorithms
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (int[][] graph)");
        }

        Solution solution = new Solution();
        return solution.allPathsSourceTarget((int[][]) args[0]);
    }

    private static class Solution {

        List<List<Integer>> res = new LinkedList<>();
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            LinkedList<Integer> path = new LinkedList<>();
            traverse(graph, 0, path);
            return res;
        }
        void traverse(int[][] graph, int s, LinkedList<Integer> path) {
            path.addLast(s);
            int n = graph.length;
            if (s == n - 1) {
                res.add(new LinkedList<>(path));
                path.removeLast();
                return;
            }
            for (int v : graph[s]) {
                traverse(graph, v, path);
            }
            path.removeLast();
        }
    }
}
