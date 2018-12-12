package nowcoder;

import user.User;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static User user = new User();
    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            final int index = i;
            new Thread(
                            () -> {
                                User user1 = new User();
                                user1.setName("" + index);
                                word(user1);
                            })
                    .start();
        }
        countDownLatch.await();
    }

    private static synchronized void word(User user1) {
        System.out.println(Thread.currentThread().getName() + " before " + user);
        user = user1;
        System.out.println(Thread.currentThread().getName() + " after " + user);
        countDownLatch.countDown();
    }
}
