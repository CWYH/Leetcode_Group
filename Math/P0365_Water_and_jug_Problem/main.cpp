/**
 * 365. Water and Jug Problem -- Medium
 */

// The total water in the two jugs must be a multiple of GCD(x, y) !!

#include <cmath>
#include <unordered_set>
#include <queue>
using namespace std;

class Solution {
public:
    bool canMeasureWater(int x, int y, int z) {
    	if (x < 0 || y < 0 || z < 0) return false;
    	if (x + y < z) return false;
    	if (x == 0 && y == 0 && z == 0) return true;  
    	return z % gcd(x, y) == 0;
    }

    int gcd(int x, int y) {
    	if (y == 0) return x;
    	else return gcd(y, x % y); 
    }
};