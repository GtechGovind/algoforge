/**
 * Design the timeline function of Moments
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return Tweet(...args);
}

var Twitter = function() {
    let globalTime = 0;
    const idToUser = new Map();
    function Tweet(id) {
        this.id = id;
        this.timestamp = globalTime++;
        this.next = null;
    }
    function User(id) {
        this.id = id;
        this.tweetHead = null;
        this.followedUserSet = new Set();
    }
    User.prototype.equals = function(other) {
        return this.id === other.id;
    }
    User.prototype.follow = function(other) {
        this.followedUserSet.add(other);
    }
    User.prototype.unfollow = function(other) {
        this.followedUserSet.delete(other);
    }
    User.prototype.post = function(tweet) {
        tweet.next = this.tweetHead;
        this.tweetHead = tweet;
    }
    this.postTweet = function(userId, tweetId) {
        if (!idToUser.has(userId)) {
            idToUser.set(userId, new User(userId));
        }
        const user = idToUser.get(userId);
        user.post(new Tweet(tweetId));
    };
    this.getNewsFeed = function(userId) {
        const res = [];
        if (!idToUser.has(userId)) {
            return res;
        }
        const user = idToUser.get(userId);
        const followedUserSet = user.followedUserSet;
        const pq = new PriorityQueue((a, b) => {
            return b.timestamp - a.timestamp;
        });
        if (user.tweetHead !== null) {
            pq.offer(user.tweetHead);
        }
        for (const other of followedUserSet) {
            if (other.tweetHead !== null) {
                pq.offer(other.tweetHead);
            }
        }
        let count = 0;
        while (!pq.isEmpty() && count < 10) {
            const tweet = pq.poll();
            res.push(tweet.id);
            if (tweet.next !== null) {
                pq.offer(tweet.next);
            }
            count++;
        }
        return res;
    };
    this.follow = function(followerId, followeeId) {
        if (!idToUser.has(followerId)) {
            idToUser.set(followerId, new User(followerId));
        }
        if (!idToUser.has(followeeId)) {
            idToUser.set(followeeId, new User(followeeId));
        }
        const follower = idToUser.get(followerId);
        const followee = idToUser.get(followeeId);
        follower.follow(followee);
    };
    this.unfollow = function(followerId, followeeId) {
        if (!idToUser.has(followerId) || !idToUser.has(followeeId)) {
            return;
        }
        const follower = idToUser.get(followerId);
        const followee = idToUser.get(followeeId);
        follower.unfollow(followee);
    };
};
class PriorityQueue {
    constructor(comparator) {
        this.heap = [];
        this.comparator = comparator;
    }
    swim(index) {
        let currentIndex = index;
        while (currentIndex > 0) {
            const parentIndex = Math.floor((currentIndex - 1) / 2);
            if (this.comparator(this.heap[currentIndex], this.heap[parentIndex]) >= 0) {
                break;
            }
            [this.heap[currentIndex], this.heap[parentIndex]] = [this.heap[parentIndex], this.heap[currentIndex]];
            currentIndex = parentIndex;
        }
    }
    sink(index) {
        let currentIndex = index;
        while (currentIndex * 2 + 1 < this.heap.length) {
            const leftIndex = currentIndex * 2 + 1;
            const rightIndex = currentIndex * 2 + 2 < this.heap.length ? currentIndex * 2 + 2 : leftIndex;
            const smallerIndex = this.comparator(this.heap[leftIndex], this.heap[rightIndex]) <= 0 ? leftIndex : rightIndex;
            if (this.comparator(this.heap[currentIndex], this.heap[smallerIndex]) <= 0) {
                break;
            }
            [this.heap[currentIndex], this.heap[smallerIndex]] = [this.heap[smallerIndex], this.heap[currentIndex]];
            currentIndex = smallerIndex;
        }
    }
    offer(value) {
        this.heap.push(value);
        this.swim(this.heap.length - 1);
    }
    poll() {
        if (this.size() === 0) {
            return null;
        }
        if (this.size() === 1) {
            return this.heap.pop();
        }
        const top = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.sink(0);
        return top;
    }
    size() {
        return this.heap.length;
    }
}
