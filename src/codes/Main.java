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

	public int run() {
		try {
			System.out.println("run...");
			return count;
		} finally {
			System.out.println("done...");
		}


	}

}

class Consumer {
	public void buy(int bread) {
		System.out.println("消费 " + bread);
	}
}

public class Main {

	public static void main(String[] args) {
		Storage storage = new Storage();
		System.out.println(storage.run());
	}
}
