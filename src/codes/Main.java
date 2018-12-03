package codes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ddv
 * @date : 2018/11/2 下午1:28
 */
class Storage {
    private List<Integer> bread = new ArrayList<>();
    private int count = 0;

    public void produce() {
        bread.add(count++);
    }

}

class Consumer {
    public void buy(int bread) {
        System.out.println("消费 " + bread);
    }
}

public class Main {

    public static void main(String[] args) {}
}
