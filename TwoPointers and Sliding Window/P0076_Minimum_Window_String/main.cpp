/**
 * 76. Minimum Window String -- Hard
 */

//
// 双指针
// 动态维护一个区间。尾指针不断后扫，当扫到有一个窗口包含了所有T的字符后，
// 然后再收缩头指针，直到不能收缩为止。最后记录所有可能的情况中窗口最小的。
//

#include <iostream>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <climits>
#include <vector>
using namespace std;

// class Solution {
// public:
// 	string minWindow(string s, string t) {
// 		if (s.size() < t.size()) return "";

// 		int left = 0, right = 0;
// 		unordered_map<char, int> tmap;
// 		unordered_map<char, int> window;
// 		for (int i = 0; i < t.size(); i++) {
// 			if (tmap.find(t[i]) == tmap.end()) tmap[t[i]] = 1;
// 			else tmap[t[i]]++;
// 		}
// 		int formed = 0;
// 		string res = s;
// 		bool exist = false;
// 		while (right < s.size()) {
// 			if (window.find(s[right]) == window.end()) window[s[right]] = 1;
// 			else window[s[right]]++;

// 			if (tmap.find(s[right]) == tmap.end()) {
// 				right++;
// 				continue;
// 			}

// 			if (window[s[right]] == tmap[s[right]]) formed++;
// 			if (formed == tmap.size()) {
// 				exist = true;
// 				while (left <= right) {
// 					if (tmap.find(s[left]) == tmap.end()) {
// 						left++;
// 						continue;
// 					}
// 					if (window[s[left]] == tmap[s[left]]) {
// 						string tmp = s.substr(left, right - left + 1);
// 						if (tmp.size() < res.size()) res = tmp;
// 						formed--;
// 						window[s[left]]--;
// 						left++;
// 						break;
// 					}
// 					else {
// 						window[s[left]]--;
// 						left++;
// 					}
// 				}
// 			}
// 			right++;
// 		}

// 		return exist ? res : "";
// 	}
// };

class Solution {
public:
	string minWindow(string s, string t) {
		if (s.size() < t.size()) return "";

		vector<int> target(256, 0);
		vector<int> window(256, 0);

		for (int i = 0; i < t.size(); i++) target[t[i]]++;

		int minLen = INT_MAX, minStart = 0;
		int left = 0, right = 0;
		int appeard = 0;   // 完整包含一个t
		for (right = 0; right < s.size(); right++) {
			if (target[s[right]] > 0) {   // this char s[right] is part of t
				window[s[right]]++;
				if (window[s[right]] <= target[s[right]]) appeard++;
			}

			if (appeard == t.size()) {    // 完整包含了一个t
				while (window[s[left]] > target[s[left]] || target[s[left]] == 0) {
					if (target[s[left]] > 0) window[s[left]]--;
					left++;
				}
				if (minLen > right - left + 1) {
					minLen = right - left + 1;
					minStart = left;
				}
			}
		}

		return minLen == INT_MAX ? "" : s.substr(minStart, minLen);
	}
};

int main() {
	Solution solu;
	string s = "a";
	string t = "b";

	cout << solu.minWindow(s, t) << endl;

	return 0;
}