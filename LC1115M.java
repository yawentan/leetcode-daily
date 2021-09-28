package yawen;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    private int n;
    private boolean flag = false;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        lock.lock();
        for (int i = 0; i < n; i++) {
            while(flag) {
            	c1.await();
            }
        	printFoo.run();
        	flag = !flag;
        	c2.signal();
        }
        lock.unlock();
    }

    public void bar(Runnable printBar) throws InterruptedException {
        lock.lock();
        for (int i = 0; i < n; i++) {
            while(!flag) {
            	c2.await();
            }
        	printBar.run();
        	flag = !flag;
        	c1.signal();
        }
        lock.unlock();
    }
}

public class LC1115M {
	
	public static void main(String[] args) {
		FooBar foo = new FooBar(1000);

		new Thread(()->{
			try {
				foo.foo(()->{
					System.out.print("foo");
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		new Thread(()->{
			try {
				foo.bar(()->{
					System.out.print("bar");
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
}
