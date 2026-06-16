/**
 * BFS Algorithm Problem Solving Routine Framework
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return plusOne(...args);
}

var openLock = function(deadends, target) {
  const deads = new Set(deadends);
  const visited = new Set();
  const q = [];
  let step = 0;
  q.push("0000");
  visited.add("0000");
  while (q.length > 0) {
    let sz = q.length;
    for (let i = 0; i < sz; i++) {
      let cur = q.shift();
      if (deads.has(cur)) continue;
          if (cur === target) return step;
      for (let j = 0; j < 4; j++) {
        let up = plusOne(cur, j);
        if (!visited.has(up)) {
          q.push(up);
          visited.add(up);
        }
        let down = minusOne(cur, j);
        if (!visited.has(down)) {
          q.push(down);
          visited.add(down);
        }
      }
    }
    step++;
  }
  return -1;
}
function plusOne(s, j) {
  let ch = s.split("");
  if (ch[j] === "9") ch[j] = "0";
  else ch[j] = String(+ch[j]+1);
  return ch.join("");
}
function minusOne(s, j) {
  let ch = s.split("");
  if (ch[j] === "0") ch[j] = "9";
  else ch[j] = String(+ch[j]-1);
  return ch.join("");
}
