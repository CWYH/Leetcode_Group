/**
 * 84. Largest Rectangle in Histogram -- Hard
 */

// 单调栈
// https://www.jianshu.com/p/43bb5204bc6f

#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        heights.push_back(0);  // 结尾时入栈元素0，重复合并一次
        stack<int> st;         // 注意st内存放数组下标!
        int res = 0;

        int i = 0;
        while (i < heights.size()) {
            if (st.empty() || heights[st.top()] <= heights[i]) {  // 保证栈内元素单调递增
                st.push(i++);
            } else {
                // 当前元素heights[i]小于栈顶元素, 则合并现有栈，直到栈顶元素小于当前元素
                int tmp = st.top();
                st.pop();
                res = max(res, heights[tmp] * (st.empty() ? i : i - st.top() - 1));
            }
        }

        return res;
    }
};