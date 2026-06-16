public class Data_structures_article_12 {
    /**
     * Ring detection and topological sorting algorithm
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Expected: (int numCourses, int[][] prerequisites)");
        }

        Solution solution = new Solution();
        return solution.canFinish((int) args[0], (int[][]) args[1]);
    }

    private static class Solution {

        boolean[] onPath;
        boolean[] visited;
        boolean hasCycle = false;
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            visited = new boolean[numCourses];
            onPath = new boolean[numCourses];
            for (int i = 0; i < numCourses; i++) {
                traverse(graph, i);
            }
            return !hasCycle;
        }
        void traverse(List<Integer>[] graph, int s) {
            if (onPath[s]) {
                hasCycle = true;
            }
            if (visited[s] || hasCycle) {
                return;
            }
            visited[s] = true;
            onPath[s] = true;
            for (int t : graph[s]) {
                traverse(graph, t);
            }
            onPath[s] = false;
        }
        List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = new LinkedList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] edge : prerequisites) {
                int from = edge[1];
                int to = edge[0];
                graph[from].add(to);
            }
            return graph;
        }
    }
}
