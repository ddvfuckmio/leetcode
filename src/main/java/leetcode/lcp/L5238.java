package leetcode.lcp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.model.CustomFunction;

/**
 * https://leetcode-cn.com/problems/find-positive-integer-solution-for-a-given-equation/
 *
 * @author : ddv
 * @since : 2019/10/28 4:00 PM
 */

public class L5238 {

    public static void main(String[] args) {
        L5238 l = new L5238();
        l.findSolution((x, y) -> x + y, 100);
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        ans(customfunction, z, result, 1, 1000);
        return result;
    }

    private void ans(CustomFunction customfunction, int z, List<List<Integer>> result, int x, int y) {

        while (x <= 1000 && y >= 1) {
            int num = customfunction.f(x, y);

            if (num == z) {
                System.out.println(x + " " + y);
                result.add(Arrays.asList(x, y));
                x++;
                y--;
                continue;
            }

            if (num > z) {
                y--;
            } else {
                x++;
            }
        }
    }
}
