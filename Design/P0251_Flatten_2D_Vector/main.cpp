/**
 * 251. Flatten 2D Vector -- Medium
 * 
 * Microsoft
 * 
 * Design and implement an iterator to flatten a 2d vector. It should support the following 
 * operations: next and hasNext.
 * 
 *  
 * 
 * Example:
 * 
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 * 
 * iterator.next(); // return 1
 * iterator.next(); // return 2
 * iterator.next(); // return 3
 * iterator.hasNext(); // return true
 * iterator.hasNext(); // return true
 * iterator.next(); // return 4
 * iterator.hasNext(); // return false
 *  
 * 
 * Notes:
 * 
 * Please remember to RESET your class variables declared in Vector2D, as static/class variables 
 * are persisted across multiple test cases. Please see here for more details. You may assume that
 * next() call will always be valid, that is, there will be at least a next element in the 2d vector 
 * when next() is called.
 */

#include <iostream>
#include <vector>
using namespace std;

// class Vector2D {
// public:
//     Vector2D(vector<vector<int>>& v) {
//         for (int i = 0; i < v.size(); i++) {
//             for (int j = 0; j < v.size(); j++) {
//                 vec.push_back(v[i][j]);
//             }
//         }
//         idx = 0;
//     }
    
//     int next() {
//         int res = vec[idx];
//         idx++;
//         return res;
//     }
    
//     bool hasNext() {
//         return idx < vec.size();
//     }

// private:
//     vector<int> vec;
//     int idx;
// };

class Vector2D {
public:
    Vector2D(vector<vector<int>>& v) {
        this->vec = v;
        i = 0;
        j = 0;
    }
    
    int next() {
        skipEmpty();
        int res = vec[i][j];
        j++;
        if (j == vec[i].size()) {
            j = 0;
            i++;
            skipEmpty();
        }
        return res;
    }
    
    bool hasNext() {
        skipEmpty();
        if (i >= vec.size()) return false;
        return true;
    }

private:
    vector<vector<int>> vec;
    int i;
    int j;

private:
    void skipEmpty() {
        while (i < vec.size() && vec[i].size() == 0) {
            i++;
        }
    }
};


/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D* obj = new Vector2D(v);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
