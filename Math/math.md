# Math

## Leetcode 

### Medium

#### 89. Gray Code
方法1. Gray码的镜像构造
```java
    public List<Integer> grayCode(int n) {
        if (n < 0) return new ArrayList<>();
        if (n == 0) return Arrays.asList(0);
        if (n == 1) return Arrays.asList(0, 1);
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0); res.add(1);
        int number = 2;
        for (int i = 2; i <= n; i++) {
            for (int j = number - 1; j >= 0; j--) {
                res.add(res.get(j) + number);
            }
            number <<= 1;
        }
        return res;
    }
```
方法2. 位运算
```java
    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        int size = 1 << n;  // 2^n
        for (int i = 0; i != size; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }
```

#### 365. Water and Jug Problem -- Medium

The total water in the two jugs must be a multiple of GCD(x, y).

```C++
int gcd(int x, int y) {
    if (y == 0) return x;
   	else return gcd(y, x % y); 
}
```

#### 372. Super Pow ***** -- Medium
计算$a^b \mod 1337$.

##### 方法一：
根据$(ab)\mod p = (a \mod p)(b \mod p) \mod p$, 有：
$$
\begin{aligned}
a^b \mod p = [(a^{\lfloor b/10\rfloor})^{10} \mod p] [(a^{b\mod10}) \mod p] \mod p
\end{aligned}
$$

##### 方法二：数论
###### 费马小定理（Fermat's little theorem）
如果$p$是一个素数，则对于任何整数$a$，有
$$
a^{p-1} \equiv 1 \pmod p
$$
###### 欧拉定理（Euler's theorem）
如果$n$和$a$是互素的，那么
$$
a^{\varphi(n)} \equiv 1 \pmod n
$$
其中，$\varphi(n)$为Euler's totient function. 定义为小于等于$n$的正整数中与$n$互素的正整数个数.

* 如果$m$和$n$互素，则$\varphi(mn)=\varphi(m)\varphi(n)$.
* 如果$n$和$a$是互素的, $x\equiv y\pmod {\varphi(n)}$, 则$a^x\equiv b^y \pmod n$

对于本题，1140只有两个素数因子，7和191，因此
$$
\varphi(1337) = \varphi(7) \times \varphi(191) = 1140
$$

* （1）如果a % 1337 == 0, 答案就是0.
* （2）如果7和191都不是$a$的因子，则$a$与1337互素
$$
a^b\pmod {1337} \equiv a^{b {\%} {\varphi(1337)}} \pmod {1337}
$$
* （3）如果7和191只有1个是$a$的因子， 和（2）一样