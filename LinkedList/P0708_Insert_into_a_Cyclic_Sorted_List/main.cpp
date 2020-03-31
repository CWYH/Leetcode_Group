/**
 * 708. Insert into a Cyclic Sorted List -- Medium
 * 
 * Microsoft
 * 
 * Given a node from a cyclic linked list which is sorted in ascending order, write a function to 
 * insert a value into the list such that it remains a cyclic sorted list. The given node can be a 
 * reference to any single node in the list, and may not be necessarily the smallest value in the 
 * cyclic list.
 * 
 * If there are multiple suitable places for insertion, you may choose any place to insert the new value. 
 * After the insertion, the cyclic list should remain sorted.
 * 
 * If the list is empty (i.e., given node is null), you should create a new single cyclic list and return 
 * the reference to that single node. Otherwise, you should return the original given node.
 * 
 */

#include <iostream>
using namespace std;

/*
// Definition for a Node.
*/
class Node {
public:
    int val;
    Node* next;

    Node() {}

    Node(int _val, Node* _next) {
        val = _val;
        next = _next;
    }
};

class Solution {
public:
    Node* insert(Node* head, int insertVal) {
        if (head == nullptr) {
            head = new Node(insertVal, head);
            return head;
        }
        Node* x = head;
        Node* pre = x;
        while (pre->val <= x->val) {
            pre = x;
            x = x->next;
            if (x == head) {
                break;
            }
        }

        /* insertVal is the smallest or largest*/
        if (insertVal <= x->val || insertVal >= pre->val) { 
            pre->next = new Node(insertVal, x);
            return head;
        } 

        /* insertVal should be in the list */
        while (x->val < insertVal) {
            pre = x;
            x = x->next;
        }
        pre->next = new Node(insertVal, x);
        return head;
    }
};