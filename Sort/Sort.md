# Sort
## Leetcode

### Medium
#### 274. H-Index***** -- Medium
**Bucket Sort**
也可以用二分搜索

#### 280. Wiggle Sort* -- Meidum
一次遍历，时间复杂度$O(N)$
```java
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0) == (nums[i] > nums[i + 1])) {
                int tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
            } 
        }
    }
```