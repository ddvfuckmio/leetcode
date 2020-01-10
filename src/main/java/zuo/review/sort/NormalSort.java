package zuo.review.sort;

import utlis.Utils;

/**
 * @author : ddv
 * @since : 2020/1/3 5:29 PM
 */

public class NormalSort {

    public static void main(String[] args) {
        int[] array = {58, 66, 68, 24, 57, 56, 70, 15, 94, 28};
        insertSort(array);
        Utils.logArray(array);
        // Utils.jujgeArray(100, 10, 4);
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    Utils.swapElement(array, i, j);
                }
            }
        }
    }

    public static void insertSort(int[] array) {
        // 有序区末尾最后一位
        int sortedEndIndex = 0;
        for (int chaosIndex = 1; chaosIndex < array.length; chaosIndex++) {
            int currentIndex = sortedEndIndex;
            // 从有序区最后开始寻找应该插入的下标
            while (currentIndex > 0 && array[chaosIndex] < array[currentIndex]) {
                currentIndex--;
            }

            // 如果有序无序接触 则顺延即可
//            if (currentIndex + 1 == chaosIndex) {
//                sortedEndIndex++;
//                continue;
//            }

            int temp = array[chaosIndex];
            System.arraycopy(array, currentIndex, array, currentIndex + 1, chaosIndex - currentIndex);
            array[currentIndex] = temp;
            sortedEndIndex++;
        }
    }
}
