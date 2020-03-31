/**
 * 297. Serialize and Deserialize Binary Tree -- Hard
 */ 

#include <iostream>
#include <string>
#include <sstream>
using namespace std;

/**
 * Definition for a binary tree node.
 */ 
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        stringstream ss;
        serialize(root, ss);
        return ss.str();
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        stringstream ss(data);
        return deserialize(ss);
    }

private:
    void serialize(TreeNode* root, stringstream& ss) {
        if (root == nullptr) {
            ss << "# ";
        } else {
            ss << root->val << " ";
            serialize(root->left, ss);
            serialize(root->right, ss);
        }
    }

    TreeNode* deserialize(stringstream& ss) {
        string val;
        ss >> val;
        if (val == "#") return nullptr;
        TreeNode* root = new TreeNode(stoi(val));
        root->left = deserialize(ss);
        root->right = deserialize(ss);
        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));

int main() {
    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    
    Codec codec;
    string str = codec.serialize(root);
    cout << str << endl;
    TreeNode* new_root = codec.deserialize(str);

    return 0;
}