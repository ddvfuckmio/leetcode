package codes.api.nio;

/**
 * @author : ddv
 * @date : 2018/11/16 下午4:32
 */
public class Main {

    public static void main(String[] args) {
        String s = "hello";
        String t = "hello";
        String v = new String("hello");
        char[] c = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(s.equals(t));
        System.out.println(t.equals(c));
        System.out.println(s == v);
    }
}
