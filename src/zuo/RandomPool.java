package zuo;

import utlis.Utils;

import java.util.HashMap;

/**
 * @author : ddv
 * @date : 2018/10/30 下午3:26
 */
public class RandomPool {
    private static HashMap<String, Integer> hashMap1;
    private static HashMap<Integer, String> hashMap2;
    private static int size;

    public RandomPool() {
        hashMap1 = new HashMap<>();
        hashMap2 = new HashMap<>();
        size = 0;
    }

    public void put(String key, Integer value) {
        hashMap1.put(key, value);
        hashMap2.put(value, key);
        size++;
    }

    public String getKey(Integer value) {
        return hashMap2.get(value);
    }

    public Integer getValue(String key) {
        return hashMap1.get(key);
    }

    public void remove(String key) {
        Integer value = hashMap1.get(key);
        hashMap1.remove(key);
        hashMap2.remove(value);
        hashMap2.put(value, hashMap2.get(size));
        hashMap2.remove(size--);
    }

    public String getRandom() {
        if (size == 0) {
            return null;
        }
        System.out.println("当前map长度:" + hashMap1.size() + " " + hashMap2.size());
        return hashMap2.get(Utils.getRandom(1, size));
    }

    public static void main(String[] args) throws InterruptedException {
       System.out.println(1|(1<<50));
    }
}
