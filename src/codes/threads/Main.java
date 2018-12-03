package codes.threads;

import codes.designs.Node;

/**
 * @author : ddv
 * @date : 2018/11/23 下午2:08
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Node node = new Node();
        while (true) {
            Thread t1 =
                    new Thread(
                            () -> {
                                while (true) {
                                    //
                                    //	if(Thread.currentThread().isInterrupted()){return;}
                                    final Node node1 = node;
                                    Thread.yield();
                                    node.data = 1;
                                }
                            });
            t1.start();

            while (true) {
                Thread.sleep(1000);
                t1.interrupt();
                System.out.println(node.data);
                node.data = 2;
            }
        }
    }
}
