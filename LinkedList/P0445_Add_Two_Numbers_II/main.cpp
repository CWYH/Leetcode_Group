/**
 * 445. Add Two Numbers -- Medium
 * 
 * Microsoft, Amazon, ByteDance, Bloomberg
 */

#include <iostream>
#include <algorithm>
#include <stack>
using namespace std;

/**
 * Definition for singly-linked list.
 */
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
 
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        stack<int> stk1;
        stack<int> stk2;
        getStack(l1, stk1);
        getStack(l2, stk2);

        stack<int> stk;
        int a = 0, b = 0;
        int carry = 0;
        while (!stk2.empty() || !stk1.empty()) {
            if (stk1.empty()) a = 0;
            else {
                a = stk1.top();
                stk1.pop();
            }
            if (stk2.empty()) b = 0;
            else {
                b = stk2.top();
                stk2.pop();
            }
            
            int r = a + b + carry;
            if (r >= 10) {
                carry = 1;
                r -= 10;
            } else {
                carry = 0;
            }

            stk.push(r);
        }
        if (carry == 1) stk.push(1);
        
        ListNode* dummy = new ListNode(-1);
        ListNode* x = dummy;
        while (!stk.empty()) {
            x->next = new ListNode(stk.top());
            stk.pop();
            x = x->next;
        }
        return dummy->next;
    }

private:
    void getStack(ListNode* l, stack<int>& stk) {
        for (ListNode* x = l; x != nullptr; x = x->next) {
            stk.push(x->val);
        }
    }
};