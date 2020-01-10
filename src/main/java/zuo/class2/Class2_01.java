package zuo.class2;

import utlis.Utils;

/**
 *
 * 荷兰国旗问题
 *
 * @author : ddv
 * @since : 2019/12/27 11:35 AM
 */

public class Class2_01 {
    public static void main(String[] args) {
        int[] array = new int[] {4, 5, 6, 1, 2, 9, 0, 3, 3, 3};
        partition(array, 3);
        Utils.logArray(array);
    }

    private static void print(int k) {
        System.out.println(k);
    }

    /**
     * 给定无序数组和数字k 整理数组为比k小的在前半部分，大于k的在后半部分
     *
     * 4, 5, 6, 1, 2, 9, 0, 3, 3, 3
     */
    private static void partition(int[] array, int k) {
        int leftPoint = -1;
        int rightPoint = array.length;
        int i = 0;
        while (i < array.length && i < rightPoint) {
            if (array[i] < k) {
                Utils.swapElement(array, i++, ++leftPoint);
            } else if (array[i] > k) {
                Utils.swapElement(array, i, --rightPoint);
            } else {
                i++;
            }

        }

    }

}
