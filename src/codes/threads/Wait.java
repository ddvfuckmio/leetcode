package codes.threads;

/**
 * @author : ddv
 * @date : 2018/11/30 下午1:34
 */
public class Wait {
    private static Object object = new Object();

    static class T1 extends Thread {
        @Override
        public void run() {
            System.out.println("t1 start...");
            synchronized (object) {
				System.out.println("t1 get lock...");
                try {
                    System.out.println("t1 release lock...");
                    object.wait();
                    System.out.println("t1 get lock...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1 end...");
            }
        }
    }

    static class T2 extends Thread {
        @Override
        public void run() {
            System.out.println("t2 start...");
            synchronized (object) {
				System.out.println("t2 get lock...");
                object.notify();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
				System.out.println("t2 return lock");
            }

        }
    }

    public static void main(String[] args){
        T1 t1 = new T1();
		T2 t2 = new T2();
		t1.start();
		t2.start();
    }
}
