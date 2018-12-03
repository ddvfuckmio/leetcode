package codes.threads;

/**
 * @author : ddv
 * @date : 2018/11/30 下午3:09
 */
public class Syn implements Runnable {
    private static Syn instance = new Syn();
    private static int i = 0;

    private synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) increase();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(i);
    }
}
