package codes.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author : ddv
 * @date : 2018/12/10 下午2:50
 */
public class SemaphoreDemo implements Runnable {
    private Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println("out...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
        	semaphore.release();
		}
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        for (int i = 0; i < 20; i++) {
            executorService.submit(semaphoreDemo);
        }
    }
}
