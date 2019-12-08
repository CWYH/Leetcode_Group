import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 355. Twitter -- Medium
 */

class Twitter {

    private static int timestamp = 0;
    private HashMap<Integer, User> userMap;  // userId -> User

    /**
     * Tweet类，链表节点
     */
    private static class Tweet {
        private int id;     // Tweet id
        private int time;   // Tweet timestamp
        private Tweet next; // the next tweet node

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    private static class User {
        private int id;
        public Set<Integer> followed;
        public Tweet head;    // 该用户发表的tweets的链表头结点

        public User(int userId) {
            this.id = userId;
            this.followed = new HashSet<>();
            this.head = null;
            follow(id);        // 关注一下自己
        }

        // 关注
        public void follow(int userId) {
            followed.add(userId);
        }

        // 取消关注
        public void unfollow(int userId) {
            // 不可以取关自己
            if (userId != this.id) {
                followed.remove(userId);
            }
        }

        // 发表tweet
        public void post(int tweetId) {
            Tweet twt = new Tweet(tweetId, timestamp);
            timestamp++;
            // 新的tweet插到链表头
            twt.next = head;
            head = twt;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User user = userMap.get(userId);
        user.post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. 
     * Each item in the news feed must be posted by users who the user 
     * followed or by the user herself. Tweets must be ordered from most
     * recent to least recent. 
     * 
     * 返回该user关注的人(包括)他自己最近的动态id, 最多10条，按由近及远的时间线排列.
     * 
     * k个排序链表合并问题
     * */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res;
        User user = userMap.get(userId);
        Set<Integer> follows = user.followed;   // userId 关注的用户
        PriorityQueue<Tweet> pq = new PriorityQueue<>(follows.size(), new Comparator<Tweet>() {
            public int compare(Tweet t1, Tweet t2) {
                return t2.time - t1.time;
            }
        });
        for (int id : follows) {
            Tweet t = userMap.get(id).head;
            if (t == null) continue;
            pq.add(t);
        }

        while (!pq.isEmpty()) {
            if (res.size() == 10) break;
            Tweet t = pq.poll();
            res.add(t.id);
            if (t.next != null) {
                pq.add(t.next);
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        User u = userMap.get(followerId);
        u.follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            User follower = userMap.get(followerId);
            follower.unfollow(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);
        
        // User 1's news feed should return a list with 1 tweet id -> [5].
        List<Integer> r1 = twitter.getNewsFeed(1);
        for (Integer e : r1) System.out.print(e + " ");
        System.out.println();
        
        // User 1 follows user 2.
        twitter.follow(1, 2);
        
        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);
        
        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        List<Integer> r2 = twitter.getNewsFeed(1);
        for (Integer e : r2) System.out.print(e + " ");
        System.out.println();
        
        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);
        
        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        List<Integer> r3 = twitter.getNewsFeed(1);
        for (Integer e : r3) System.out.print(e + " ");
        System.out.println();
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