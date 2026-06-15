# Design the timeline function of Moments

## Core idea
# Design the timeline function of Moments
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- Time: O(?)
- Space: O(?)

## Implementation

### Python

```python
class Twitter:
    def __init__(self):
        self.globalTime = 0
        self.idToUser = {}
    class Tweet:
        def __init__(self, id: int):
            self.id = id
            self.timestamp = Twitter.globalTime
            Twitter.globalTime += 1
            self.next = None
        def get_id(self) -> int:
            return self.id
        def get_timestamp(self) -> int:
            return self.timestamp
        def get_next(self):
            return self.next
        def set_next(self, next_tweet):
            self.next = next_tweet
    class User:
        def __init__(self, id: int):
            self.id = id
            self.tweet_head = None
            self.followed_user_set = set()
        def get_id(self):
            return self.id
        def get_tweet_head(self) -> Tweet:
            return self.tweet_head
        def get_followed_user_set(self):
            return self.followed_user_set
        def __eq__(self, other):
            return self.id == other.id
        def follow(self, other):
            self.followed_user_set.add(other)
        def unfollow(self, other):
            self.followed_user_set.discard(other)
        def post(self, tweet: Tweet):
            tweet.set_next(self.tweet_head)
            self.tweet_head = tweet
    def postTweet(self, userId: int, tweetId: int) -> None:
        if userId not in self.idToUser:
            self.idToUser[userId] = Twitter.User(userId)
        user = self.idToUser[userId]
        user.post(Twitter.Tweet(tweetId))
    def getNewsFeed(self, userId: int) -> List[int]:
        res = []
        if userId not in self.idToUser:
            return res
        user = self.idToUser[userId]
        followed_user_set = user.get_followed_user_set()
        pq = []
        if user.get_tweet_head():
            heappush(pq, (-user.tweet_head.timestamp, user.get_tweet_head()))
        for other in followed_user_set:
            if other.get_tweet_head():
                heappush(pq, (-other.tweet_head.timestamp, other.get_tweet_head()))
        count = 0
        while pq and count < 10:
            _, tweet = heappop(pq)
            res.append(tweet.get_id())
            if tweet.get_next():
                heappush(pq, (-tweet.get_next().timestamp, tweet.get_next()))
            count += 1
        return res
    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId not in self.idToUser:
            self.idToUser[followerId] = Twitter.User(followerId)
        if followeeId not in self.idToUser:
            self.idToUser[followeeId] = Twitter.User(followeeId)
        follower = self.idToUser[followerId]
        followee = self.idToUser[followeeId]
        follower.follow(followee)
    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId not in self.idToUser or followeeId not in self.idToUser:
            return
        follower = self.idToUser[followerId]
        followee = self.idToUser[followeeId]
        follower.unfollow(followee)
```

### Java

```java
class Twitter {
    int globalTime = 0;
    HashMap<Integer, User> idToUser = new HashMap<>();
    class Tweet {
        private int id;
        private int timestamp;
        private Tweet next;
        public Tweet(int id) {
            this.id = id;
            this.timestamp = globalTime++;
        }
        public int getId() {
            return id;
        }
        public int getTimestamp() {
            return timestamp;
        }
        public Tweet getNext() {
            return next;
        }
        public void setNext(Tweet next) {
            this.next = next;
        }
    }
    class User {
        private int id;
        private Tweet tweetHead;
        private HashSet<User> followedUserSet;
        public User(int id) {
            this.id = id;
            this.tweetHead = null;
            this.followedUserSet = new HashSet<>();
        }
        public int getId() {
            return id;
        }
        public Tweet getTweetHead() {
            return tweetHead;
        }
        public HashSet<User> getFollowedUserSet() {
            return followedUserSet;
        }
        public boolean equals(User other) {
            return this.id == other.id;
        }
        public void follow(User other) {
            followedUserSet.add(other);
        }
        public void unfollow(User other) {
            followedUserSet.remove(other);
        }
        public void post(Tweet tweet) {
            tweet.setNext(tweetHead);
            tweetHead = tweet;
        }
    }
    public void postTweet(int userId, int tweetId) {
        if (!idToUser.containsKey(userId)) {
            idToUser.put(userId, new User(userId));
        }
        User user = idToUser.get(userId);
        user.post(new Tweet(tweetId));
    }
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!idToUser.containsKey(userId)) {
            return res;
        }
        User user = idToUser.get(userId);
        Set<User> followedUserSet = user.getFollowedUserSet();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> {
            return b.timestamp - a.timestamp;
        });
        if (user.getTweetHead() != null) {
            pq.offer(user.getTweetHead());
        }
        for (User other : followedUserSet) {
            if (other.getTweetHead() != null) {
                pq.offer(other.tweetHead);
            }
        }
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            Tweet tweet = pq.poll();
            res.add(tweet.getId());
            if (tweet.getNext() != null) {
                pq.offer(tweet.getNext());
            }
            count++;
        }
        return res;
    }
    public void follow(int followerId, int followeeId) {
        if (!idToUser.containsKey(followerId)) {
            idToUser.put(followerId, new User(followerId));
        }
        if (!idToUser.containsKey(followeeId)) {
            idToUser.put(followeeId, new User(followeeId));
        }
        User follower = idToUser.get(followerId);
        User followee = idToUser.get(followeeId);
        follower.follow(followee);
    }
    public void unfollow(int followerId, int followeeId) {
        if (!idToUser.containsKey(followerId) || !idToUser.containsKey(followeeId)) {
            return;
        }
        User follower = idToUser.get(followerId);
        User followee = idToUser.get(followeeId);
        follower.unfollow(followee);
    }
}
```

### JavaScript

```javascript
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
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
