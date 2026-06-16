/**
 * Thinking transformation between dynamic programming and backtracking algorithms
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return backtrack(...args);
}

var wordBreak = function(s, wordDict) {
  let res = [];
  let track = [];
  function backtrack(s, i, wordDict) {
    if (i === s.length) {
      res.push(track.join(" "));
      return;
    }
    if (i > s.length) {
      return;
    }
    for (let word of wordDict) {
      let len = word.length;
      if (i + len > s.length) {
        continue;
      }
      let subStr = s.substring(i, i + len);
      if (subStr !== word) {
        continue;
      }
      track.push(word);
      backtrack(s, i + len, wordDict);
      track.pop();
    }
  }
  backtrack(s, 0, wordDict);
  return res;
};
