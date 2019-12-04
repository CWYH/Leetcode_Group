/**
 * 243. Shortest Word Distance -- Easy
 *
 * Microsoft
 *
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * Example:
 *   Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 *     Input: word1 = “coding”, word2 = “practice”
 *     Output: 3
 *     Input: word1 = "makes", word2 = "coding"
 *     Output: 1
 * Note:
 *   You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */

#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

class Solution {
public:
	int shortestDistance(vector<string>& words, string word1, string word2) {
		vector<int> v1;
		vector<int> v2;
		for (int i = 0; i < words.size(); i++) {
			if (words[i] == word1) v1.push_back(i);
			if (words[i] == word2) v2.push_back(i);
		}

		int res = INT_MAX;
		for (int i = 0; i < v2.size(); i++) {
			vector<int>::iterator it = lower_bound(v1.begin(), v1.end(), v2[i]);  // binary search
			int pos = it - v1.begin();
			if (pos < v1.size()) res = min(res, abs(v1[pos] - v2[i]));
            else if (pos == v1.size()) res = min(res, abs(v1[pos - 1] - v2[i]));
			
			if (pos > 0) res = min(res, abs(v1[pos - 1] - v2[i]));
			else res = min(res, abs(v1[0] - v2[i]));
		}

		return res;
	}
};

int main() {
	Solution s;
	vector<string> words = { "a", "b" };
	string word1 = "a";
	string word2 = "b";
	cout << s.shortestDistance(words, word1, word2) << endl;
	return 0;
}