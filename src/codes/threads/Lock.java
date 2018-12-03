package codes.threads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : ddv
 * @date : 2018/11/30 下午3:32
 */
public class Lock implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    private static int i = 0;

    private void increase() {
        for (int k = 0; k < 10000; k++) {
            try {
                lock.lock();

                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    @Override
    public void run() {
        increase();
    }

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new Lock();
        Thread t1 = new Thread(lock);
        Thread t2 = new Thread(lock);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(i);
    }
}
