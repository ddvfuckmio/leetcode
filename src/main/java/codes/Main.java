package codes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ddv
 * @date : 2018/11/2 下午1:28
 */

public class Main {

    // balloon

    public static void main(String[] args) {
        Main main = new Main();
        // CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (Integer integer : list) {
            if (integer > 5) {
                list.remove(integer);
            }
        }

        System.out.println(list.size());
    }

    public int maxNumberOfBalloons(String text) {
        containChar(text, 'b');
        return min(containChar(text, 'b'), containChar(text, 'a'), containChar(text, 'l') / 2,
            containChar(text, 'o') / 2, containChar(text, 'n'));
    }

    private int containChar(String text, char c) {
        int count = 0;
        for (char currentChar : text.toCharArray()) {
            if (c == currentChar) {
                count++;
            }
        }
        return count;
    }

    private int min(int... args) {
        int minNum = Integer.MAX_VALUE;
        for (int arg : args) {
            minNum = Math.min(minNum, arg);
        }
        return minNum;
    }
}
