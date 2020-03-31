/**
 * 1114. Print in Order -- Easy
 */

class Foo {

    private Object lock = new Object();
    private boolean firstDone = false;
    private boolean secondDone = false;

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized(lock) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstDone = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(lock) {
            while (!firstDone) {
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondDone = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized(lock) {
            while (!secondDone) {
                lock.wait();
            }

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
        
    }

    // public static void main(String[] args) {
    //     Foo foo = new Foo();

    // }
}