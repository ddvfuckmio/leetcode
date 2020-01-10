package codes.threads;

/**
 * @author : ddv
 * @date : 2018/11/30 下午2:26
 */
public class Daemon extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("daemon running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Daemon d1 = new Daemon();
        d1.setDaemon(Boolean.FALSE); // 设置为守护线程 主线程执行完后 收回线程会结束
        d1.start();
        Thread.sleep(5000);
    }
}
