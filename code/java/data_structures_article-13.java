import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Design the timeline of moments with a tiny social feed:
 * each user has tweets in a linked list, and we always pull the newest tweet next.
 */
public class Data_structures_article_13 {

    /**
     * Build the Twitter simulator by giving the number of recent tweets to show.
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (int userCount)");
        }

        int cap = toInt(args[0]);
        return new Twitter(cap);
    }

    private int toInt(Object value) {
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        return Integer.parseInt(String.valueOf(value));
    }

    private static class Twitter {
        int globalTime = 0;
        Map<Integer, User> idToUser = new HashMap<>();

        class Tweet {
            private final int id;
            private final int timestamp;
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
            private final int id;
            private Tweet tweetHead;
            private final Set<User> followedUserSet;

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
            public Set<User> getFollowedUserSet() {
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

        public Twitter(int capacity) {
            this.globalTime = 0;
        }

        public void postTweet(int userId, int tweetId) {
            if (!idToUser.containsKey(userId)) {
                idToUser.put(userId, new User(userId));
            }
            User user = idToUser.get(userId);
            user.post(new Tweet(tweetId));
        }

        public int[] getNewsFeed(int userId) {
            if (!idToUser.containsKey(userId)) {
                return new int[]{};
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

            int[] res = new int[10];
            int count = 0;
            while (!pq.isEmpty() && count < 10) {
                Tweet tweet = pq.poll();
                res[count++] = tweet.getId();
                if (tweet.getNext() != null) {
                    pq.offer(tweet.getNext());
                }
            }
            if (count == 10) {
                return res;
            }
            int[] shortRes = new int[count];
            System.arraycopy(res, 0, shortRes, 0, count);
            return shortRes;
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
}
