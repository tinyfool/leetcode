package p0355;

import java.util.*;

//Runtime: 161 ms, faster than 5.01% of Java online submissions for Design Twitter.
//Memory Usage: 52.6 MB, less than 26.23% of Java online submissions for Design Twitter.

class Twitter {

    List<int[]> tws = new ArrayList<>();
    Map<Integer, Set<Integer>> foMap = new HashMap<>();
    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tws.add(new int[]{userId,tweetId});
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> feed = new ArrayList<>();
        int n = 0;
        for(int i=0;i<tws.size();i++) {


            int[] tw = tws.get(tws.size()-i-1);
            Set<Integer> set = foMap.get(userId);

            if(tw[0]==userId || (set!=null && set.contains(tw[0]))) {

                if(n==10)
                    break;
                feed.add(tw[1]);
                n++;
            }
        }
        return feed;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {

        Set<Integer> fos = foMap.getOrDefault(followerId,new HashSet<>());
        fos.add(followeeId);
        foMap.put(followerId,fos);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> fos = foMap.getOrDefault(followerId,new HashSet<>());
        fos.remove(followeeId);
        foMap.put(followerId,fos);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */