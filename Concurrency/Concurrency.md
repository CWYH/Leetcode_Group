# Concurrency

## 1114. Print in Order -- Easy
1. 执行屏障
   这是一个典型的执行屏障的问题，可以通过构造屏障来实现。我们需要构造2道屏障，`second` 线程等待 `first` 屏障，`third` 线程等待 `second` 屏障。

2. 使用原子类