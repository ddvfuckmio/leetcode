import utlis.Utils;

/**
 * @author : ddv
 * @since : 2020/1/4 10:52 AM
 */

public class Test {

    @org.junit.Test
    public void test() {
        int[] src = new int[] {0, 1, 2, 3, 4, 5};
        int[] dest = new int[] {1, 2, 3, 4, 5};
        System.arraycopy(src, 0, src, 1, 3);
        Utils.logArray(src);
//        Utils.logArray(dest);
    }
}
