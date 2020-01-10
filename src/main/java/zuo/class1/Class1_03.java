package zuo.class1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : ddv
 * @since : 2019/12/27 10:31 AM
 */

public class Class1_03 {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int[] array = new int[] {1, 3, 4, 2, 5};
        getReverseNum(0, array.length - 1, array, result);
        System.out.println(result);
    }

    /**
     * 打印逆序对 左边数比右边小 则是一对逆序对 将其打印出来
     */
    public static void getReverseNum(int left, int right, int[] array, List<List<Integer>> result) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        getReverseNum(left, mid, array, result);
        getReverseNum(mid + 1, right, array, result);
        mergeArray(left, right, array, result);
    }

    private static void mergeArray(int left, int right, int[] array, List<List<Integer>> result) {
        int mid = left + (right - left) >> 1;
        int leftPoint = left;
        int rightPoint = mid + 1;
        int helpPoint = 0;
        int[] help = new int[right - left + 1];
        while (leftPoint <= mid && rightPoint <= right) {
            if (array[leftPoint] < array[rightPoint]) {
                int point = rightPoint;
                while (point <= right) {
                    result.add(Arrays.asList(array[leftPoint], array[point++]));
                }
            }
            help[helpPoint++] = array[leftPoint] <= array[rightPoint] ? array[leftPoint++] : array[rightPoint++];
        }

        while (leftPoint <= mid) {
            help[helpPoint++] = array[leftPoint++];
        }

        while (rightPoint <= right) {
            help[helpPoint++] = array[rightPoint++];
        }

        for (int i = 0; i < help.length; i++) {
            array[left + i] = help[i];
        }
    }
}
