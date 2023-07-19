package algo.bitwise;

/**
 * https://leetcode.com/problems/sum-of-two-integers/description/
 */
public class SumOfTwoNumbers {

    public static void main(String[] args) {
        int a = 17;
        int b = 29;

        while (b!=0) {
            int carry = a & b;
            System.out.println("carry : "+ carry);
            a = a ^ b;
            System.out.println("a : "+ a);
            b = carry << 1;
            System.out.println("b : "+ b);
        }
        System.out.println("sum : "+ a);;
    }
}
