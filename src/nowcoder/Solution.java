package nowcoder;

public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] flags = new boolean[rows][cols];
        return movingCount(0, 0, rows, cols, threshold, flags);
    }

    private int movingCount(int i, int j, int rows, int cols, int threshold, boolean[][] flags) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || flags[i][j] || (numSum(i)+numSum(j)>threshold)) {
            return 0;
        }
        flags[i][j] = true;
        return movingCount(i - 1, j, rows, cols, threshold, flags)
                + movingCount(i + 1, j, rows, cols, threshold, flags)
                + movingCount(i, j - 1, rows, cols, threshold, flags)
                + movingCount(i, j + 1, rows, cols, threshold, flags)
                + 1;
    }

    private static int numSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }

	public static void main(String[] args) throws Exception {
		Solution solution = new Solution();
	}
}
