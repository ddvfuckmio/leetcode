package codes.threads;

// thread.join 等待该线程执行完毕
public class Join {
    private static int i = 0;

    public static void main(String[] args) {
        Thread t1 =
                new Thread(
                        () -> {
                            for (int i = 0; i < 10; i++) {
                                System.out.println(i);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main " + i);
    }
}
