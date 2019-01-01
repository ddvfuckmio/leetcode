package codes.threads;

import codes.designs.Node;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author : ddv
 * @date : 2018/11/23 下午2:08
 */

class Job implements Runnable {
	private CyclicBarrier cyclicBarrier;
	private String name;

	public Job(CyclicBarrier barrier, String name) {
		this.cyclicBarrier = barrier;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000 * new Random().nextInt(10));
			System.out.println(name + " ready...");
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(name + " go");
	}
}

public class Main {

	public static void main(String[] args) throws InterruptedException {

//		CountDownLatch countDownLatch = new CountDownLatch(10);
		CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			executorService.submit(new Job(cyclicBarrier, i + ""));
		}

		executorService.shutdown();

	}
}
