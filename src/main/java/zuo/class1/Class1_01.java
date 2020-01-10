package zuo.class1;

import utlis.Utils;

/**
 * @author : ddv
 * @since : 2019/12/23 6:06 PM
 */

public class Class1_01 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 1};
        mergeSort(array);
        Utils.logArray(array);
    }

    private static void mergeSort(int[] array) {
        int[] help = new int[array.length];
        mergeSort(0, array.length - 1, array, help);
    }

    private static void mergeSort(int left, int right, int[] array, int[] help) {
        if (left == right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(left, mid, array, help);
        mergeSort(mid + 1, right, array, help);
        mergeArray(left, right, array, help);
    }

    /**
     * 合并数组
     */
    private static void mergeArray(int left, int right, int[] array, int[] help) {
        if (left == right) {
            return;
        }
        int moveLeft = left;
        int mid = (left + right) >> 1;
        int moveRight = mid + 1;
        int helpIndex = moveLeft;
        while (moveLeft <= mid && moveRight <= right) {
            help[helpIndex++] = array[moveLeft] <= array[moveRight] ? array[moveLeft++] : array[moveRight++];
        }

        while (moveLeft <= mid) {
            help[helpIndex++] = array[moveLeft++];
        }

        while (moveRight <= right) {
            help[helpIndex++] = array[moveRight++];
        }

        System.arraycopy(help, left, array, left, right - left + 1);
    }

    /**
     * 寻找a数组没有而b有的数字
     */
    private static void findDifferentNum() {
        int[] array = new int[] {1, 3, 5, 6, 9};
        int[] secondArray = new int[] {1, 4, 5, 7, 9};
        int pointA = 0;
        int pointB = 0;

        while (pointA < array.length - 1 || pointB < secondArray.length - 1) {
            if (secondArray[pointB] < array[pointA]) {
                System.out.print(secondArray[pointB++] + " ");
            } else if (secondArray[pointB] == array[pointA]) {
                pointB++;
            } else {
                pointA++;
            }
        }

        System.out.println();
    }
}
