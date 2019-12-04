#include <iostream>
#include <vector>
using namespace std;

const int maxN = 10010;

#define lowbit(x) ((x) & (-x))

vector<int> c(maxN, 0);  // BIT


// add v to arr[x]
void update(int x, int v) {
    for (int i = x; i < c.size(); i = i + lowbit(i)) {
        c[i] += v;
    }
}

// sum of the front x numbers
int getSum(int x) {
    int sum = 0;
    for (int i = x; i > 0; i = i - lowbit(i)) {
        sum += c[i];
    }
    return sum;
}

int main() {
    int n, x;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> x;
        update(x, 1);
        cout << getSum(x - 1) << endl;  // the number of numbers less than x
    }

    return 0;
}