"""Design the timeline function of Moments.

Think of every tweet as a card in a linked chain (newest first).
The feed pulls the newest visible card and then updates to the next newest one.
"""

from __future__ import annotations

from heapq import heappush, heappop
from typing import Any, Dict, List


def solve(*args: Any, **kwargs: Any) -> Any:
    """Build and return a Twitter timeline object for quick learning."""
    return Twitter(*args, **kwargs)


class Twitter:
    def __init__(self, capacity: int):
        self.globalTime = 0
        self.idToUser: Dict[int, "Twitter.User"] = {}

    class Tweet:
        def __init__(self, id: int, owner: "Twitter"):
            self.owner = owner
            self.id = id
            self.timestamp = owner.globalTime
            owner.globalTime += 1
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

        def get_tweet_head(self):
            return self.tweet_head

        def get_followed_user_set(self):
            return self.followed_user_set

        def __eq__(self, other):
            return self.id == other.id

        def follow(self, other):
            self.followed_user_set.add(other)

        def unfollow(self, other):
            self.followed_user_set.discard(other)

        def post(self, tweet: "Twitter.Tweet"):
            tweet.set_next(self.tweet_head)
            self.tweet_head = tweet

    def postTweet(self, userId: int, tweetId: int) -> None:
        if userId not in self.idToUser:
            self.idToUser[userId] = self.User(userId)
        user = self.idToUser[userId]
        tweet = Twitter.Tweet(tweetId, self)
        user.post(tweet)

    def getNewsFeed(self, userId: int) -> List[int]:
        res: List[int] = []
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
            nxt = tweet.get_next()
            if nxt:
                heappush(pq, (-nxt.timestamp, nxt))
            count += 1
        return res

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId not in self.idToUser:
            self.idToUser[followerId] = self.User(followerId)
        if followeeId not in self.idToUser:
            self.idToUser[followeeId] = self.User(followeeId)
        follower = self.idToUser[followerId]
        followee = self.idToUser[followeeId]
        follower.follow(followee)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId not in self.idToUser or followeeId not in self.idToUser:
            return
        follower = self.idToUser[followerId]
        followee = self.idToUser[followeeId]
        follower.unfollow(followee)
