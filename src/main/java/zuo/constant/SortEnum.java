package zuo.constant;

import java.util.HashMap;
import java.util.Map;

import zuo.class2.Class2_02;
import zuo.class2.Class2_03;
import zuo.review.sort.NormalSort;

/**
 * @author : ddv
 * @since : 2019/12/27 6:26 PM
 */

public enum SortEnum {
    /**
     * 快排
     */
    Quick_Sort(1, "快速排序") {
        @Override
        public void sort(int[] array) {
            Class2_02.quickSort(0, array.length - 1, array);
        }
    },
    /**
     * 堆排
     */
    Heap_Sort(2, "堆排序") {
        @Override
        public void sort(int[] array) {
            Class2_03.heapSort(array);
        }
    },
    /**
     * 冒泡排序
     */
    Bubble_Sort(3, "冒泡排序") {
        @Override
        public void sort(int[] array) {
            NormalSort.bubbleSort(array);
        }
    },
	/**
	 * 插入排序
	 */
	Insert_Sort(4,"插入排序"){
		@Override
		public void sort(int[] array) {
			NormalSort.insertSort(array);
		}
	},



    //
    ;

    SortEnum(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    private int id;
    private String desc;
    private static Map<Integer, SortEnum> ID_TO_TYPE = new HashMap<>();

    static {
        for (SortEnum anEnum : SortEnum.values()) {
            ID_TO_TYPE.put(anEnum.id, anEnum);
        }
    }

    public void sort(int[] array) {

    }

    public static SortEnum getById(int id) {
        return ID_TO_TYPE.get(id);
    }
}
