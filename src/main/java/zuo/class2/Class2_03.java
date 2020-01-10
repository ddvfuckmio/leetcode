package zuo.class2;

import utlis.Utils;

/**
 *
 * 堆
 *
 * @author : ddv
 * @since : 2020/1/2 4:36 PM
 */

public class Class2_03 {

    public static void main(String[] args) {
         Utils.jujgeArray(100,10,2);
        // int[] array = {20, 45, 57, 99, 48, 49, 24, 78, 64, 46};
        // heapSort(array);
        // Utils.logArray(array);
    }

    /**
     * 堆排序
     */
    public static void heapSort(int[] array) {
        Heap heap = Heap.valueOf(array.length, array);
        heap.sort();
        int index = 0;
        for (int datum : heap.data) {
            array[index++] = datum;
        }
    }
}

class Heap {
    public int size;
    public int[] data;

    public static Heap valueOf(int size) {
        Heap heap = new Heap();
        heap.size = size;
        heap.data = new int[size];
        return heap;
    }

    public static Heap valueOf(int size, int[] data) {
        Heap heap = Heap.valueOf(size);
        heap.init(data);
        return heap;
    }

    private void init(int[] tempData) {
        int[] temp = new int[tempData.length];

        for (int i = 0; i < tempData.length; i++) {
            temp[i] = tempData[i];
            int point = i;
            while (temp[point] > temp[(point - 1) / 2]) {
                Utils.swapElement(temp, point, (point - 1) >> 1);
                point = (point - 1) >> 1;
            }
        }
        data = temp;
    }

    public void log() {
        Utils.logArray(data);
    }

    public void sort() {
        int index = size - 1;
        while (index > 0) {
            swapReSort(index--);
//            log();
        }
    }

    private void swapReSort(int lastIndex) {
        Utils.swapElement(data, 0, lastIndex);
        heapfiy(data, 0, lastIndex);

    }

    /**
     * 重新调整为大根堆
     */
    private void heapfiy(int[] data, int startIndex, int endIndex) {
        int leftChild = startIndex * 2 + 1;

        while (leftChild < endIndex) {
            int rightChild = leftChild + 1;
            // 先算出左右结点较大的下标
            int moreChildIndex = rightChild < endIndex && data[rightChild] > data[leftChild] ? rightChild : leftChild;
            int moreIndex = data[startIndex] > data[moreChildIndex] ? startIndex : moreChildIndex;

            if (moreIndex == startIndex) {
                // 无需下沉 父节点已经是最大
                break;
            }

            Utils.swapElement(data, moreIndex, startIndex);
            startIndex = moreIndex;
            leftChild = moreIndex * 2 + 1;
        }

    }

}
