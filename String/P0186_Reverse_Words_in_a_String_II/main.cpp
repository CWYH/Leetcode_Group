/**
 * 186. Reverse Words in a String II -- Medium
 *
 * -- Microsoft
 *
 * -----------------------------------------------------------------------------
 * Given an input string , reverse the string word by word. 
 *
 * Example:
 * 
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * 
 * Note: 
 * 
 *     A word is defined as a sequence of non-space characters.
 *     The input string does not contain leading or trailing spaces.
 *     The words are always separated by a single space.
 * 
 * Follow up: Could you do it in-place without allocating extra space?
 */

//
// 思路: 先对每一个单词实现翻转，再对整个数组实现翻转。 这样单词实现了两次翻转，所以单词个体的顺序仍不变，但单词间的顺序发生了变化。
//

#include <vector>
#include <string>
#include <stack>
using namespace std;

class Solution {
public:
    // void reverseWords(vector<char>& s) {
    //     if (s.size() <= 1) return;
    //     stack<string> stk;
    //     int i = 0;
    //     while (i < s.size()) {
    //         int j = i;
    //         string str = "";
    //         while (j < s.size() && s[j] != ' ') str += s[j++];
    //         stk.push(str);
    //         i = j + 1;
    //     }

    //     i = 0;
    //     while (i < s.size()) {
    //         if (!stk.empty()) {
    //             string str = stk.top();
    //             stk.pop();
    //             for (int k = 0; k < str.size(); k++) s[i++] = str[k];
    //             if (!stk.empty()) s[i++] = ' ';
    //         }
    //     }
    // }

    void reverseWords(vector<char> & s) {
        if (s.size() <= 1) return;
        int i = 0, j = 0;
        while (i < s.size()) {
            while (j < s.size() && s[j] != ' ') j++;
            reverseWord(s, i, j - 1);
            i = j + 1;
            j = i;
        }
        reverseWord(s, 0, s.size() - 1);
    }

private:
    void reverseWord(vector<char> & s, int lo, int hi) {
        while (lo < hi) {
            swap(s[lo++], s[hi--]);
        }
    }
};