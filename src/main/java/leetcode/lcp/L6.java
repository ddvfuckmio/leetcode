package leetcode.lcp;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * @author : ddv
 * @since : 2020/9/8 9:11 PM
 *
 *
 */

public class L6 {

    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        if (s == null || s.equals("")) {
            return sb.toString();
        }

        if (numRows == 1) {
            return s;
        }

        char[] charArray = s.toCharArray();
        // 总步长
        int totalStep = (numRows - 1) * 2;
        // 本质上是轮流走两种步长[上升和下降] 步长可能存在为0的情况
        for (int rowIndex = 0; rowIndex < numRows && charArray.length - 1 >=rowIndex; rowIndex++) {
            boolean repeated = false;
            int currentIndex = rowIndex;
            // 起点直接加进去
            sb.append(charArray[rowIndex]);
            // 是否是上升波
            boolean upWave = true;
            // 上升波步长
            int upWaveStep = totalStep - (rowIndex * 2);
            while (currentIndex <= charArray.length - 1) {
                int currentStep = upWave ? upWaveStep : totalStep - upWaveStep;
                // 连续步长为0 死循环了
                if (currentStep == 0 && repeated) {
                    break;
                }
                currentIndex += currentStep;
                repeated = currentStep == 0;

                if (currentStep != 0 && currentIndex <= charArray.length - 1) {
                    sb.append(charArray[currentIndex]);
                }
                upWave = !upWave;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        L6 l6 = new L6();
        String leetcodeishiring = l6.convert("A", 2);
        System.out.println(leetcodeishiring);
    }
}
