/**
 * 1031. Partition Array Into Three Parts With Equal Sum -- Easy
 */

#include <vector>
using namespace std;

class Solution {
public:
    bool canThreePartsEqualSum(vector<int>& A) {
        long long sum = 0;
        for (int i = 0; i < A.size(); i++) {
        	sum += A[i];
        }
        if (sum % 3 != 0) return false;
        sum /= 3;
        
        long long s = 0;
        int i = 0;
        while (i < A.size()) {
        	s += A[i];
        	i++;
        	if (s == sum) break;
        }
        if (i >= A.size() - 1) return false;

        s = 0;
        while (i < A.size()) {
        	s += A[i];
        	i++;
        	if (s == sum) break;
        }
        if (i >= A.size()) return false;

        return true;
    }
};