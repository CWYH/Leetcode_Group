import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 1195. Fizz Buzz Multithreaded -- Medium
 */

class FizzBuzz {
    private int n;
    private int num = 1;

    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();
    private int state = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    // If the number is divisible by 3, output "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i = i + 3) {
            if (i % 5 == 0) continue;
            lock.lock();
            try {
                while (state != 3) cond.await();
                printFizz.run();
                changeState(i + 1);
                cond.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    // If the number is divisible by 5, output "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i = i + 5) {
            if (i % 3 == 0) continue;
            lock.lock();
            try {
                while (state != 5) cond.await();
                printBuzz.run();
                changeState(i + 1);
                cond.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    // If the number is divisible by both 3 and 5, output "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i = i + 15) {
            lock.lock();
            try {
                while (state != 15) cond.await();
                printFizzBuzz.run();
                changeState(i + 1);
                cond.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 1) {
            if (i % 3 == 0 || i % 5 == 0) continue;
            lock.lock();
            try {
                while (state != 1) cond.await();
                printNumber.accept(i);
                changeState(i + 1);
                cond.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    private void changeState(int i) {
        if (i % 3 == 0 && i % 5 != 0) state = 3;
        else if (i % 5 == 0 && i % 3 != 0) state = 5;
        else if (i % 3 == 0 && i % 5 == 0) state = 15;
        else state = 1;
    }

    static class printFizz implements Runnable {
        @Override
        public void run() {
            System.out.println("fizz");
        }
    }

    static class printBuzz implements Runnable {
        @Override
        public void run() {
            System.out.println("buzz");
        }
    }

    static class printFizzBuzz implements Runnable {
        @Override
        public void run() {
            System.out.println("fizzbuzz");
        }
    }

    public static void main(String[] args) {
        int n = 15;
        FizzBuzz FB = new FizzBuzz(n);

        new Thread(()->{
            try {
                FB.fizz(new printFizz());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                FB.buzz(new printBuzz());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                FB.fizzbuzz(new printFizzBuzz());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                FB.number(e->System.out.println(e));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}