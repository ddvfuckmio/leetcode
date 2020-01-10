package leetcode.lcp;

/**
 * https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
 *
 * @author : ddv
 * @since : 2019/10/28 5:53 PM
 */

public class L1213 {
    /**
     * [[-4,-3],[1,0],[3,-1],[0,-1],[-5,2]]
     *
     * @param args
     */
    public static void main(String[] args) {
        L1213 l1213 = new L1213();
        int[][] array = new int[5][2];
        array[0] = new int[] {-4, -3};
        array[1] = new int[] {1, 0};
        array[2] = new int[] {3, -1};
        array[3] = new int[] {0, -1};
        array[4] = new int[] {-5, 2};
        l1213.checkStraightLine(array);
    }

    public boolean checkStraightLine(int[][] coordinates) {
        double k = 0;
        boolean origin = true;
        for (int i = 1; i < coordinates.length; i++) {
            int[] coordinate = coordinates[i - 1];
            int[] coordinateTwo = coordinates[i];
            double tempK;
            if ((coordinateTwo[0] == coordinate[0])) {
                tempK = 1;
            } else {
                tempK = ((double)(coordinateTwo[1] - coordinate[1])) / (coordinateTwo[0] - coordinate[0]);
            }

            if (origin) {
                k = tempK;
                origin = false;
            }

            if (k != tempK) {
                return false;
            }
        }

        return true;
    }
}
