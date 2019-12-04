/**
 * 409. Longest Palindrome -- Easy
 */

#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char, int> h;
        for (int i = 0; i < s.size(); i++) {
            if (h.find(s[i]) == h.end()) h[s[i]] = 1;
            else h[s[i]]++;
        }
        int res = 0;
        bool hasOdd = false;
        for (unordered_map<char, int>::iterator it = h.begin(); it != h.end(); it++) {
            if (it->second % 2 == 0) res += it->second;
            else {
                res += (it->second - 1);
                hasOdd = true;
            }
        }
        if (hasOdd) res++;
        return res;
    }
};