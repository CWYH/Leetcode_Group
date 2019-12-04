/**
 * 295. Find Medium from Data Stream -- Hard 
 */

// 
// See https://leetcode.com/articles/find-median-from-data-stream/
//
// Use the property of Red-Black Tree (Self-Banancing Binary Search Tree)
//
// std::multiset -- implemented by rbTree
//
// 
// Algorithm
//
// * Two iterators/pointers lo_median and hi_median, which iterate over the data multiset.
// * While adding a number num, three cases arise:
// 
//     1. The container is currently empty. Hence we simply insert num and set both pointers to point to this element.
//     2. The container currently holds an odd number of elements. This means that both the pointers currently point to the same element.
//
//         * If num is not equal to the current median element, then num goes on either side of it. Whichever side it goes, the size of 
//           that part increases and hence the corresponding pointer is updated. For example, if num is less than the median element, 
//           the size of the lesser half of input increases by 1 on inserting num. Thus it makes sense to decrement lo_median.
//
//         * If num is equal to the current median element, then the action taken is dependent on how num is inserted into data. 
//           NOTE: In our given C++ code example, std::multiset::insert inserts an element after all elements of equal value. 
//                 Hence we increment hi_median.
//     3. The container currently holds an even number of elements. This means that the pointers currently point to consecutive elements.
//         * If num is a number between both median elements, then num becomes the new median. Both pointers must point to it.
//         * Otherwise, num increases the size of either the lesser or higher half of the input. We update the pointers accordingly. 
//           It is important to remember that both the pointers must point to the same element now.
//
// * Finding the median is easy! It is simply the mean of the elements pointed to by the two pointers lo_median and hi_median.
//

#include <iostream>
#include <set>
#include <algorithm>
using namespace std;

class MedianFinder {
public:
    /** initialize your data structure here. */
    MedianFinder() {
        lo_medium = data.end();
        hi_medium = data.end();
    }
    
    void addNum(int num) {
        const int N = data.size();
        data.insert(num);

        if (!N) {
            // no elements before
            lo_medium = data.begin();
            hi_medium = data.begin();
        } else if (N & 1 == 1) {
            // N is odd and lo_medium = hi_medium
            if (num < *lo_medium) {
                lo_medium--;
            } else {
                hi_medium++;
            }
        } else {
            // N is even and hi_medium = lo_medium + 1 before
            if (num >= *lo_medium && num < *hi_medium) {
                lo_medium++;
                hi_medium--;
            } else if (num < *lo_medium) {
                hi_medium--;
            } else {
                lo_medium++;
            }
        }
    }
    
    double findMedian() {
        return (*lo_medium + *hi_medium) / 2.0;
    }

private:
    multiset<int> data;
    multiset<int>::iterator lo_medium, hi_medium;
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */