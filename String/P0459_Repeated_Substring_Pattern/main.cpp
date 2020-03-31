/**
 * 459. Repeated Substring Pattern -- Easy
 *
 * Microsoft
 */

#include <iostream>
#include <string>
using namespace std;

// class Solution {
// public:
// 	bool repeatedSubstringPattern(string s) {
// 		if (s.size() <= 1) return false;
// 		for (int len = 1; len <= s.size() / 2; len++) {
// 			if (s.size() % len != 0) continue;
// 			string p = s.substr(0, len);
// 			bool match = true;
// 			for (int i = len; i < s.size(); i = i + len) {
// 				if (s.substr(i, len) != p) {
// 					match = false;
// 					break;
// 				}
// 			}
// 			if (match) return true;
// 		}

// 		return false;
// 	}
// };

class Solution {
public:
    bool repeatedSubstringPattern(string s) {
		string str = s + s;
		string tmpstr = str.substr(1, str.size() - 2);
		return tmpstr.find(s) != string::npos;
	}
};

int main() {
	Solution s;
	string str = "abab";
	cout << s.repeatedSubstringPattern(str) << endl;
	return 0;
}
