public class Data_structures_article_03 {
    /**
     * Dijkstra algorithm template and application
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 5) {
            throw new IllegalArgumentException("Expected: (int n, int[][] edges, double[] succProb, int start, int end)");
        }

        Solution solution = new Solution();
        return solution.maxProbability((int) args[0], (int[][]) args[1], (double[]) args[2], (int) args[3], (int) args[4]);
    }

    private static class Solution {

        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            List<double[]>[] graph = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int i = 0; i < edges.length; i++) {
                int from = edges[i][0];
                int to = edges[i][1];
                double weight = succProb[i];
                graph[from].add(new double[]{(double)to, weight});
                graph[to].add(new double[]{(double)from, weight});
            }
            return dijkstra(start, end, graph);
        }
        class State {
            int id;
            double distFromStart;
            State(int id, double distFromStart) {
                this.id = id;
                this.distFromStart = distFromStart;
            }
        }
        double dijkstra(int start, int end, List<double[]>[] graph) {
            int V = graph.length;
            double[] distTo = new double[V];
            Arrays.fill(distTo, -1);
            distTo[start] = 1;
            Queue<State> pq = new PriorityQueue<>((a, b) -> {
                return Double.compare(b.distFromStart, a.distFromStart);
            });
            pq.offer(new State(start, 1));
            while (!pq.isEmpty()) {
                State curState = pq.poll();
                int curNodeID = curState.id;
                double curDistFromStart = curState.distFromStart;
                if (curNodeID == end) {
                    return curDistFromStart;
                }
                if (curDistFromStart < distTo[curNodeID]) {
                    continue;
                }
                for (double[] neighbor : graph[curNodeID]) {
                    int nextNodeID = (int)neighbor[0];
                    double distToNextNode = distTo[curNodeID] * neighbor[1];
                    if (distTo[nextNodeID] < distToNextNode) {
                        distTo[nextNodeID] = distToNextNode;
                        pq.offer(new State(nextNodeID, distToNextNode));
                    }
                }
            }
            return 0.0;
        }
    }
}
