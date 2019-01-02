package codes.threads;

import codes.designs.Node;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author : ddv
 * @date : 2018/11/23 下午2:08
 */

class Job implements Runnable {
	private CountDownLatch countDownLatch;
	private String name;

	public Job(CountDownLatch countDownLatch, String name) {
		this.countDownLatch = countDownLatch;
		this.name = name;
	}

	@Override
	public void run() {
		try {
//			Thread.sleep(1000);
//			System.out.println(name + " done... " + Thread.currentThread().getName());
			System.out.println(System.currentTimeMillis());
			countDownLatch.countDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class Main {

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(10);

		ExecutorService executorService = Executors.newSingleThreadScheduledExecutor
				();
//		for (int i = 0; i < 10; i++) {
//			executorService.submit(new Job(countDownLatch, i + ""));
			((ScheduledExecutorService) executorService).scheduleWithFixedDelay(new Job(countDownLatch, 1 + ""), 3, 1, TimeUnit.SECONDS);
//		}
		countDownLatch.await();
		executorService.shutdown();

	}
}
