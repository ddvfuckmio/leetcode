package bzy;

import java.util.concurrent.CountDownLatch;

/*
 * @author : ddv
 * @date   : 2018/10/9 下午7:05
 */
class MyThread extends Thread {
    private CountDownLatch countDownLatch;

    public MyThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + "start...");
        try {
            this.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + "done...");
        countDownLatch.countDown();
    }
}

public class Main {
    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyThread t = new MyThread(countDownLatch);
            t.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main running...");
    }
}
