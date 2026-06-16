/**
 * Monotone queue structure solves the sliding window problem
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return maxSlidingWindow(...args);
}

var maxSlidingWindow = function(nums, k) {
    class MonotonicQueue {
        constructor() {
            this.q = []
        }
        push(n) {
            while (this.q.length !== 0 && this.q[this.q.length - 1] < n) {
                this.q.pop()
            }
            this.q.push(n)
        }
        max() {
            return this.q[0]
        }
        pop(n) {
            if (this.q[0] === n) {
                this.q.shift()
            }
        }
    }
    const window = new MonotonicQueue()
    const res = []
    for (let i = 0; i < nums.length; i++) {
        if (i < k - 1) {
            window.push(nums[i])
        } else {
            window.push(nums[i])
            res.push(window.max())
            window.pop(nums[i - k + 1])
        }
    }
    return res
}
