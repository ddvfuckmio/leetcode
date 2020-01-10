package codes.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : ddv
 * @date : 2018/12/31 下午7:59
 */

public class ReadWriteLockDemo {
	private static Lock lock = new ReentrantLock();

	private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private static Lock readLock = readWriteLock.readLock();
	private static Lock writeLock = readWriteLock.writeLock();

	int data;

	public void write(Lock lock, int data) throws InterruptedException {
		try {
			lock.lock();
			Thread.sleep(1000);
			this.data = data;
		} finally {
			lock.unlock();
		}

	}

	public int read(Lock lock) throws InterruptedException {
		try {
			lock.lock();
			Thread.sleep(1000 / 5);
			return this.data;
		} finally {
			lock.unlock();
		}

	}

	public static void main(String[] args) {

		ReadWriteLockDemo demo = new ReadWriteLockDemo();
		CountDownLatch countDownLatch1 = new CountDownLatch(20);
		CountDownLatch countDownLatch2 = new CountDownLatch(20);
		long start = System.currentTimeMillis();
		getStart(demo, countDownLatch1, lock);
		try {
			countDownLatch1.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println((end - start));

		start = System.currentTimeMillis();
		getStart(demo, countDownLatch2, readLock);

		end = System.currentTimeMillis();
		System.out.println((end - start));


		try {
			countDownLatch2.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void getStart(ReadWriteLockDemo demo, CountDownLatch countDownLatch1, Lock lock) {
		for (int i = 0; i < 20; i++) {
			new Thread(() -> {
				try {
					demo.read(lock);
					countDownLatch1.countDown();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();
		}
		return;
	}
}
