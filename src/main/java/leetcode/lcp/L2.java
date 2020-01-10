package leetcode.lcp;

/**
 * @author : ddv
 * @since : 2019/9/27 2:34 PM
 */

public class L2 {

    /**
     * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
     * <p>
     * 示例 1： 输入：cont = [3, 2, 0, 2] 输出：[13, 4] 解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
     * 示例 2：
     * <p>
     * 输入：cont = [0, 0, 3] 输出：[3, 1] 解释：如果答案是整数，令分母为1即可。 限制：
     * <p>
     * cont[i] >= 0 1 <= cont的长度 <= 10 cont最后一个元素不等于0 答案的n, m的取值都能被32位int整型存下（即不超过2 ^ 31 - 1）。
     */

    public static void main(String[] args) {
        L2 l2 = new L2();
        int[] fraction = l2.fraction(new int[] {3, 2, 0, 2});
    }

    public int[] fraction(int[] cont) {
        int[] ans = new int[] {1, cont[cont.length - 1]};

        if (cont.length < 2) {
            return new int[] {cont[0], 1};
        }

        for (int i = cont.length - 2; i >= 0; i--) {
            int down = ans[1] * cont[i] + ans[0];
            int up = ans[1];
            ans[0] = up;
            ans[1] = down;
        }

        // 最后还要翻转一次

        int temp = ans[1];
        ans[1] = ans[0];
        ans[0] = temp;
        return ans;
    }

}
