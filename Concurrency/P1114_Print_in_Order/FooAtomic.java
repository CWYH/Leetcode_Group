import java.util.concurrent.atomic.AtomicInteger;

class FooAtomic {

    private AtomicInteger i = new AtomicInteger(0);

    public FooAtomic() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        i.getAndIncrement();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (i.get() != 1) {}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        i.getAndIncrement();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (i.get() != 2) {}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}