# Math

## Leetcode 

### Medium

#### 365. Water and Jug Problem -- Medium

The total water in the two jugs must be a multiple of GCD(x, y).

```C++
int gcd(int x, int y) {
    if (y == 0) return x;
   	else return gcd(y, x % y); 
}
```



