/**
 * Algorithm problems that can be solved with one line of code
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return canWinNim(...args);
}

var canWinNim = function(n) {
    return n % 4 !== 0;
};
