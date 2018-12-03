package codes.sorts;

import utlis.Utils;

public class Sort {

    // 插入排序 最好n 最坏n^2
    public static void insertSort(int[] a) {
        if (a.length <= 1) return;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                Utils.changeInt(a, j, j - 1);
            }
        }
    }

    // 选择排序
    public static void chooseSort(int[] a) {
        int index = 0;
        int value = Integer.MAX_VALUE;
        boolean sign = false;
        if (a.length <= 1) return;
        for (int i = 0; i < a.length - 1; i++) {
            sign = false;
            index = i;
            value = Integer.MAX_VALUE;
            for (int j = i; j < a.length; j++) {
                if (a[j] < value) {
                    sign = true;
                    value = a[j];
                    index = j;
                }
            }
            if (sign) Utils.changeInt(a, i, index);
        }
    }

    // 快速排序❤️ 平均:O(nlogn) 最坏:O(n^2)
    public static void quickSort(int[] a) {
        if (a == null || a.length < 2) return;
        quickSort(a, 0, a.length - 1);
    }

    public static void quickSort(int[] a, int left, int right) {
        if (left >= right) return;
        int originLeft = left;
        int originRight = right;
        while (left != right) {
            while (a[right] >= a[originLeft] && left < right) right--;
            while (a[left] <= a[originLeft] && left < right) left++;
            if (left < right) Utils.changeInt(a, left, right);
        }
        Utils.changeInt(a, originLeft, right);
        quickSort(a, originLeft, left - 1);
        quickSort(a, right + 1, originRight);
    }

    // 归并排序
    public static void mergeSort(int[] a) {
        if (a == null || a.length < 2) return;
        int[] temp = new int[a.length];
        mergeSort(a, 0, a.length - 1, temp);
    }

    public static void mergeSort(int[] a, int left, int right, int[] temp) {
        if (left == right) return;
        int mid = (left + right) >> 1;
        mergeSort(a, left, mid, temp);
        mergeSort(a, mid + 1, right, temp);
        mergeArray(a, left, mid, right, temp);
    }

    public static void mergeArray(int[] a, int left, int mid, int right, int[] temp) {
        int originLeft = left;
        int length = right - left + 1;
        int index = 0;
        int rightStart = mid + 1;

        while (left <= mid && rightStart <= right) {
            if (a[left] <= a[rightStart]) temp[index++] = a[left++];
            else temp[index++] = a[rightStart++];
        }

        while (left <= mid) temp[index++] = a[left++];
        while (rightStart <= right) temp[index++] = a[rightStart++];

        index--;
        for (int i = 0; i < length; i++, index--) a[originLeft + index] = temp[index];
    }

    // 希尔排序 💕
    public static void shellSort(int[] a) {
        if (a == null || a.length < 2) return;
        for (int step = a.length >> 1; step > 0; step = step >> 1) {
            for (int i = step; i < a.length; i++) {
                for (int j = i; j - step >= 0 && a[j] < a[j - step]; j -= step) {
                    Utils.changeInt(a, j, j - step);
                }
            }
        }
    }
}
