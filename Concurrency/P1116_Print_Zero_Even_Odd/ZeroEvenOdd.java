import java.util.function.IntConsumer;

/**
 * 1116. Print Zero Even Odd -- Meidum
 */

class ZeroEvenOdd {
    private int n;

    private Object lock = new Object();
    private boolean zeroTurn = true;
    private boolean oddTurn = true;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            synchronized(lock) {
                while (!zeroTurn) {
                    lock.wait();
                }
                printNumber.accept(0);
                zeroTurn = false;
                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i = i + 2) {
            synchronized(lock) {
                while (zeroTurn || oddTurn) {
                    lock.wait();
                }
                printNumber.accept(i);
                zeroTurn = true;
                oddTurn = true;
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 2) {
            synchronized(lock) {
                while (zeroTurn || !oddTurn) {
                    lock.wait();
                }
                printNumber.accept(i);
                zeroTurn = true;
                oddTurn = false;
                lock.notifyAll();
            }
        }
    }
}