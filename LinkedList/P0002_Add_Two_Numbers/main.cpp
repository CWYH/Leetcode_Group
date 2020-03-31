/**
 * 2. Add Two Numbers -- Medium
 */ 

#include <iostream>
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
        ListNode* res = new ListNode(-1);
        ListNode* x = res;
        int carry = 0;
        while (l1 != nullptr || l2 != nullptr) {
            int a = l1 == nullptr ? 0 : l1->val;
            int b = l2 == nullptr ? 0 : l2->val;
            int r = a + b + carry;
            if (r >= 10) {
                r -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            x->next = new ListNode(r);
            x = x->next;
            if (l1 != nullptr) l1 = l1->next;
            if (l2 != nullptr) l2 = l2->next;
        }
        if (carry == 1) x->next = new ListNode(1);
        return res->next;
    }
};