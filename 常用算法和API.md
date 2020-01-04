# 常用的算法和API使用

## Java
### 堆和优先队列
```java
PriorityQueue<T> queue = new PriorityQueue<T>(size ,new Comparator<T>(){  
    @Override  
    public int compare(T paramT1,  
                        T paramT2) {  
        return  paramT1.mPriority - paramT2.mPriority;  // 小顶堆
        
        // 大顶堆
        // return  paramT2.mPriority - paramT1.mPriority;
    }  
}); 
```