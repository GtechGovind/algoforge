/**
 * Basics of graph theory algorithms
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return allPathsSourceTarget(...args);
}

var allPathsSourceTarget = function(graph) {
    var res = [];
    var traverse = function(graph, s, path) {
        path.push(s);
        var n = graph.length;
        if (s === n - 1) {
            res.push(path.slice());
            path.pop();
            return;
        }
        for (var i = 0; i < graph[s].length; i++) {
            traverse(graph, graph[s][i], path);
        }
        path.pop();
    };
    var path = [];
    traverse(graph, 0, path);
    return res;
};
