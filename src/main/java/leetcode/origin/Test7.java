package leetcode.origin;

/**
 * @author : ddv
 * @since : 2019/9/11 4:04 PM
 */

public class Test7 {

    public static void main(String[] args) {
        Test7 test = new Test7();
        int num = 123;
        // int num = 0;
        // int num = -123;
        // int num = 1534236469;
        System.out.println(test.reverse(num));

    }

    public int reverse(int x) {
        return method2(x);
    }

    private int method2(int x) {
        int sum = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // 因为这里限定了int 并且-10<pop<10 自己推导一下
            if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            sum = sum * 10 + pop;
        }

        return sum;
    }

    private int method1(int x) {
        int sum = 0;
        int temp = x;
        int radio = 0;
        int plus;

        while (temp != 0) {
            temp /= 10;
            radio++;
        }

        radio--;
        temp = x;

        while (temp != 0) {
            plus = temp % 10;
            sum += plus * Math.pow(10, radio--);
            temp /= 10;
            System.out.println("plus " + plus + " radio " + radio + " temp " + temp + " sum " + sum);
            if (sum <= Integer.MIN_VALUE || sum > Integer.MAX_VALUE - 1) {
                return 0;
            }
        }
        return sum;
    }
}
