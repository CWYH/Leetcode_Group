import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1188. Design Bounded Blocking Queue -- Medium
 */

class BoundedBlockingQueue {

    private Queue<Integer> q = new LinkedList<>();
    private int capacity = 0;

    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (q.size() == capacity) {
                cond.await();
            }
            q.offer(element);
            cond.signalAll();
        } finally {
            lock.unlock();
        }
    }
    
    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (q.isEmpty()) {
                cond.await();
            }
            int res = q.poll();
            cond.signalAll();
        } finally {
            lock.unlock();
        }
        return res;
    }
    
    public int size() {
        return q.size();
    }
}