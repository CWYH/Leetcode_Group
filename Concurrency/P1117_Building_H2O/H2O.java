import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1117. Building H2O -- Medium
 */

class H2O {

    private int Hs = 0;
    private Lock lock = new ReentrantLock(); 
    private Condition condition = lock.newCondition();

    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        try {
            while (Hs == 2) {
                condition.await();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            Hs++;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        try {
            while (Hs < 2) {
                condition.await();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            Hs = 0;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}