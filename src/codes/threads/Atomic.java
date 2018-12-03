package codes.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// 线程安全的计数器
public class Atomic {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) {
        final Atomic sc = new Atomic();
        List<Thread> threadList = new ArrayList<>();

        for (int j = 0; j < 100; j++) {
            Thread thread =
                    new Thread(
                            new Runnable() {
                                @Override
                                public void run() {
                                    for (int i = 0; i < 100; i++) {
                                        sc.safeCount();
                                        sc.count();
                                    }
                                }
                            });
            threadList.add(thread);
        }
        for (Thread thread : threadList) thread.start();

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sc.atomicInteger.get());
        System.out.println(sc.i);
    }

    private void safeCount() {
        for (; ; ) {
            int i = atomicInteger.get();
            boolean sign = atomicInteger.compareAndSet(i, ++i);
            if (sign) {
                break;
            }
        }
    }

    private void count() {
        i++;
    }
}
