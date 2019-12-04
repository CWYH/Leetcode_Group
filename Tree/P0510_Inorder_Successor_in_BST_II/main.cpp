/**
 * 510. Inorder Successor in BST II -- Medium
 *
 * Microsoft
 *
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * The successor of a node p is the node with the smallest key greater than p.val.
 * You will have direct access to the node but not to the root of the tree. Each node will have a reference to its parent node.
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
    Node* left;
    Node* right;
    Node* parent;
};

class Solution {
public:
    Node* inorderSuccessor(Node* node) {
        if (node == nullptr) return nullptr;
        if (node->right != nullptr) {
        	Node* x = node->right;
        	while (x->left != nullptr) {
        		x = x->left;
        	}
        	return x;
        } else {
        	Node* x = node;
        	while (x->parent != nullptr && x->parent->left != x) {
        		x = x->parent;
        	}
        	return x->parent;
        }
    }
};
