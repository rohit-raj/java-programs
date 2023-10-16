package algo.misc;

import ds.arrays.TwoSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/design-twitter/
 */
public class DesignTwitter {
    public class User {
        int userId;
        HashSet<Integer> follows;
        User(int _userId){
            userId = _userId;
            follows = new HashSet<>();
        }
    }

    public class Tweet{
        int tweetId;
        int userId;
        Tweet(int _userId, int _tweetId){
            userId = _userId;
            tweetId = _tweetId;
        }
    }

    HashMap<Integer, User> users;
    ArrayList<Tweet> tweets;


    public DesignTwitter() {
        users = new HashMap<>();
        tweets = new ArrayList<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)){
            users.put(userId, new User(userId));
        }
        tweets.add(new Tweet(userId, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId)){
            users.put(userId, new User(userId));
        }
        List<Integer> ans = new ArrayList<>();
        int i = tweets.size()-1;
        while (ans.size() < 10 && i>=0){
            if(tweets.get(i).userId == userId ||
                users.get(userId).follows.contains(tweets.get(i).userId)){
                ans.add(tweets.get(i).tweetId);
            }
            i--;
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)){
            users.put(followerId, new User(followerId));
        }
        if (!users.containsKey(followeeId)){
            users.put(followeeId, new User(followeeId));
        }
        User user = users.get(followerId);
        user.follows.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)){
            users.put(followerId, new User(followerId));
        }
        if (!users.containsKey(followeeId)){
            users.put(followeeId, new User(followeeId));
        }
        User user = users.get(followerId);
        user.follows.remove(followeeId);
    }

    public static void main(String[] args) {
        DesignTwitter twitter = new DesignTwitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.

    }
}
