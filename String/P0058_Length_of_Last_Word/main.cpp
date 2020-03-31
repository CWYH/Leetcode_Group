/**
 * 58. Length of Last Word -- Easy
 */

#include <string>
using namespace std;

class Solution {
public:
    int lengthOfLastWord(string s) {
        if (s.size() <= 0) return 0;

        int res = 0;
        int idx = s.size() - 1;
        while (idx >= 0 && s[idx] == ' ') idx--;
        while (idx >= 0) {
            if (s[idx] == ' ') break;
            idx--;
            res++;
        }
        return res;
    }
};

