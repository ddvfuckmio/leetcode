package codes.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : ddv
 * @date : 2018/12/10 下午2:30
 */
public class ConditionDemo implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    @Override
    public void run() {

        try {
            lock.lock();
            System.out.println("lock down...");
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
        	lock.unlock();
        	System.out.println("unlock down...");
		}
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionDemo conditionDemo = new ConditionDemo();
        new Thread(conditionDemo).start();
        Thread.sleep(5000);
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
