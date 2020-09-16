package leetcode.greedy;

import java.util.LinkedList;

/**
 *
 * @author : ddv
 * @since : 2020/4/15 4:48 PM
 *
 *        给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 *        注意:
 *
 *        num 的长度小于 10002 且 ≥ k。 num 不会包含任何前导零。 示例 1 :
 *
 *        输入: num = "1432219", k = 3 输出: "1219" 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。 示例 2 :
 *
 *        输入: num = "10200", k = 1 输出: "200" 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。 示例 3 :
 *
 *        输入: num = "10", k = 2 输出: "0" 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 */

public class L402 {

    public static void main(String[] args) {
        System.out.println(removeKdigits("10200", 1));
    }

    public static String removeKdigits(String num, int k) {
        StringBuffer result = new StringBuffer();
        LinkedList<Integer> queue = new LinkedList<>();
        // init data
        {
            char[] chars = num.toCharArray();
            for (int i = 0; i <= chars.length - 1; i++) {
                (queue).offerLast(Integer.parseInt(chars[i] + ""));
            }
        }

        {
            int index = 1;
            while (index < queue.size() && k > 0) {
                Integer current = queue.get(index);
                Integer left = queue.get(index - 1);

                if (left > current) {
                    queue.remove(index - 1);
                    index = index == 1 ? index : index - 1;
                    k--;
                } else {
                    index++;
                }
            }
        }

        while (k > 0) {
            queue.removeLast();
            k--;
        }

        for (Integer integer : queue) {
            if (integer == 0) {
                continue;
            }
            result.append(integer);
        }

        return result.toString();
    }
}
