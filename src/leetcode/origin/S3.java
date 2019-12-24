package leetcode.origin;

/**
 * @author : ddv
 * @date : 2018/12/10 上午10:39
 */
import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * <p>示例 1:
 *
 * <p>输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。 示例 2:
 *
 * <p>输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。 示例 3:
 *
 * <p>输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class S3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();

        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        S3 s3 = new S3();
        System.out.println(s3.lengthOfLongestSubstring("abacadw"));
    }
}
