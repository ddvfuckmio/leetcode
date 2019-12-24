package leetcode.lcp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : ddv
 * @since : 2019/10/29 9:25 PM
 */

public class L1200 {

    public static void main(String[] args) {
        L1200 l1200 = new L1200();
        l1200.minimumAbsDifference(new int[] {4, 2, 1, 3});
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int difference = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int abs = Math.abs(arr[i] - arr[i + 1]);
            if (abs < difference) {
                result.clear();
                difference = abs;
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (abs == difference) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        return result;
    }
}
