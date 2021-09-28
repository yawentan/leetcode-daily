package yawen;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;
class ZeroEvenOdd {
    private int n;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private int flag = 0;
    private int num=1;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
    	lock.lock();
    	try {
    		while(num<=n) {
        		//зда§
        		while(flag!=0&&flag!=2&&num<=n) {
        			c1.await();
        		}
        		if(num<=n)
        			printNumber.accept(0);
        		flag++;
        		flag%=4;
        		c2.signal();
    		}
    		c2.signal();
    	}finally {
    		lock.unlock();
    	}
    }

    public void even(IntConsumer printNumber) throws InterruptedException {

    	lock.lock();
    	try {
    		while(num<=n) {
        		//зда§
        		while(flag!=3&&num<=n) {
        			c2.await();
        		}
        		if(num%2==0&&num<=n)
        			printNumber.accept(num);
        		num++;
        		flag++;
        		flag%=4;
        		c1.signal();
    		}
    		c2.signal();
    	}finally {
    		lock.unlock();
    	}
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {

    	lock.lock();
    	try {
    		while(num<=n) {
        		//зда§
        		while(flag!=1&&num<=n) {
        			c2.await();
        		}
        		if(num%2==1&&num<=n)
        			printNumber.accept(num);
        		num++;
        		flag++;
        		flag%=4;
        		c1.signal();
    		}
    		c2.signal();
    	}finally {
    		lock.unlock();
    	}
    }
}
public class LC1116 {
	public static void main(String[] args) {
		ZeroEvenOdd foo = new ZeroEvenOdd(1);
		new Thread(()->{
			try {
				foo.zero((int x)->{
					System.out.print(x);
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		new Thread(()->{
			try {
				foo.odd((int x)->{
					System.out.print(x);
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		new Thread(()->{
			try {
				foo.even((int x)->{
					System.out.print(x);
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
}
