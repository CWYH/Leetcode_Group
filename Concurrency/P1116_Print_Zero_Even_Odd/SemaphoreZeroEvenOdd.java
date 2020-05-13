import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class SemaphoreZeroEvenOdd {
    private int n;

    private Semaphore zeroSema = new Semaphore(1);
    private Semaphore evenSema = new Semaphore(0);
    private Semaphore oddSema = new Semaphore(0);
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSema.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                evenSema.release();
            } else {
                oddSema.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i = i + 2) {
            evenSema.acquire();
            printNumber.accept(i);
            zeroSema.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 2) {
            oddSema.acquire();
            printNumber.accept(i);
            zeroSema.release();
        }
    }
}