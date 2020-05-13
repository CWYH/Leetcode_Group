/**
 * 1115. Print FooBar Alternately -- Medium
 */

class FooBar {
    private int n;

    private Object lock = new Object();
    private volatile boolean first = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (!first) {
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                first = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (first) {
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                first = true;
                lock.notifyAll();
            }
        }
    }

    static class printFoo implements Runnable {
        @Override
        public void run() {
            System.out.print("foo");
        }
    }

    static class printBar implements Runnable {
        @Override
        public void run() {
            System.out.print("bar");
        }
    }

    public static void main(String[] args) {
        int n = 20;
        FooBar FB = new FooBar(n);

        new Thread(() -> {
            try {
                FB.foo(new printFoo());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                FB.bar(new printBar());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
