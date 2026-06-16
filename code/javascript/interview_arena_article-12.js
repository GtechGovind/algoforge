/**
 * How to find prime numbers efficiently
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return countPrimes(...args);
}

var countPrimes = function(n) {
    const isPrime = new Array(n).fill(true);
    for (let i = 2; i * i < n; i++) {
        if (isPrime[i]) {
            for (let j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
    }
    let count = 0;
    for (let i = 2; i < n; i++) {
        if (isPrime[i]) count++;
    }
    return count;
};
