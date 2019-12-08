/**
 * 355. Twitter -- Medium
 */

#include <iostream>
#include <vector>
#include <queue>
#include <unordered_map>
#include <unordered_set>
using namespace std;

struct Tweet {
	int id;
	int timestamp;
	Tweet* next;

	Tweet(int id, int timestamp) {
		this->id = id;
		this->timestamp = timestamp;
		this->next = nullptr;
	}
};

struct Cmp {
public:
	bool operator() (const Tweet* t1, const Tweet* t2) const {
		return t1->timestamp < t2->timestamp;
	}
};

class User {
private:
	int id;
public:
	unordered_set<int> follows;
	Tweet* head;
public:
	User() : id(-1), head(nullptr) {}

	User(int userId) {
		this->id = userId;
		this->head = nullptr;
		follow(id);  // 关注自己
	}

	void follow(int followId) {
		follows.insert(followId);
	}

	void unfollow(int followId) {
		if (followId != this->id) {
			follows.erase(followId);
		}
	}

	void postTweet(int tweetId, int timestamp) {
		Tweet* twt = new Tweet(tweetId, timestamp);
		twt->next = head;
		head = twt;
	}
};

class Twitter {
public:
	/** Initialize your data structure here. */
	Twitter() {
		timestamp = 0;
	}

	/** Compose a new tweet. */
	void postTweet(int userId, int tweetId) {
		if (userMap.find(userId) == userMap.end()) {
			User u(userId);
			userMap[userId] = u;
		}
		userMap[userId].postTweet(tweetId, timestamp);
		timestamp++;
	}

	/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	vector<int> getNewsFeed(int userId) {
		if (userMap.find(userId) == userMap.end()) {
			return vector<int>();
		}
		priority_queue<Tweet*, vector<Tweet*>, Cmp> pq;
		unordered_set<int> follows = userMap[userId].follows;
		for (auto it = follows.begin(); it != follows.end(); it++) {
			Tweet* head = userMap[*it].head;
			if (head == nullptr || head == NULL) continue;
			pq.push(head);
		}
		vector<int> res;
		while (!pq.empty() && res.size() < 10) {
			Tweet* t = pq.top();
			pq.pop();
			res.push_back(t->id);
			t = t->next;
			if (t != nullptr) {
				pq.push(t);
			}
		}
		return res;
	}

	/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	void follow(int followerId, int followeeId) {
		if (userMap.find(followerId) == userMap.end()) {
			User u(followerId);
			userMap[followerId] = u;
		}
		if (userMap.find(followeeId) == userMap.end()) {
			User u(followeeId);
			userMap[followeeId] = u;
		}
		userMap[followerId].follow(followeeId);
	}

	/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	void unfollow(int followerId, int followeeId) {
		if (userMap.find(followerId) != userMap.end()) {
			userMap[followerId].unfollow(followeeId);
		}
	}

private:
	int timestamp;
	unordered_map<int, User> userMap;
};

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter* obj = new Twitter();
 * obj->postTweet(userId,tweetId);
 * vector<int> param_2 = obj->getNewsFeed(userId);
 * obj->follow(followerId,followeeId);
 * obj->unfollow(followerId,followeeId);
 */

int main() {
	Twitter twitter;
	twitter.postTweet(1, 5);
	vector<int> r1 = twitter.getNewsFeed(1);
	for (auto it = r1.begin(); it != r1.end(); it++) cout << *it << " ";
	cout << endl;
	twitter.follow(1, 2);
	twitter.postTweet(2, 6);
	vector<int> r2 = twitter.getNewsFeed(1);
	for (auto it = r2.begin(); it != r2.end(); it++) cout << *it << " ";
	cout << endl;
	twitter.unfollow(1, 2);
	vector<int> r3 = twitter.getNewsFeed(1);
	for (auto it = r3.begin(); it != r3.end(); it++) cout << *it << " ";
	cout << endl;
	return 0;
}