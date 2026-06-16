/**
 * Dijkstra algorithm template and application
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return dijkstra(...args);
}

var maxProbability = function(n, edges, succProb, start, end) {
    const graph = [];
    for (let i = 0; i < n; i++) {
        graph[i] = [];
    }
    for (let i = 0; i < edges.length; i++) {
        const from = edges[i][0];
        const to = edges[i][1];
        const weight = succProb[i];
        graph[from].push([to, weight]);
        graph[to].push([from, weight]);
    }
    return dijkstra(start, end, graph);
};
class State {
    constructor(id, distFromStart) {
        this.id = id;
        this.distFromStart = distFromStart;
    }
}
function dijkstra(start, end, graph) {
    const V = graph.length;
    const distTo = new Array(V).fill(-1);
    distTo[start] = 1;
    const pq = new PriorityQueue({
        compare: (a, b) => {
            return b.distFromStart - a.distFromStart;
        }
    });
    pq.enqueue(new State(start, 1));
    while (!pq.isEmpty()) {
        const curState = pq.dequeue();
        const curNodeID = curState.id;
        const curDistFromStart = curState.distFromStart;
        if (curNodeID === end) {
            return curDistFromStart;
        }
        if (curDistFromStart < distTo[curNodeID]) {
            continue;
        }
        for (const neighbor of graph[curNodeID]) {
            const nextNodeID = neighbor[0];
            const distToNextNode = distTo[curNodeID] * neighbor[1];
            if (distTo[nextNodeID] < distToNextNode) {
                distTo[nextNodeID] = distToNextNode;
                pq.enqueue(new State(nextNodeID, distToNextNode));
            }
        }
    }
    return 0.0;
}
