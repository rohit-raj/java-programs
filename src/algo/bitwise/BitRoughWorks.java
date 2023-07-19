package algo.bitwise;

/**
 * Rough work or practice file
 *
 * Xor of 1-N :
 * 0^1 = 1, 1^2 = 3, 2^4 = 0, 3^4 = 4 :
 * if(n%4 == 0) return n   // if n = 4, 1^2^3^4 = 4
 * if(n%4 == 1) return 1   // if n=5, 1^2^3^4^5 = 1
 * if(n%4 == 2) return n+1 // if n=6, 1^2^3^4^5^6 = 6+1 = 7
 * if(n%4 == 3) return 0   // if n=7, 1^2^3^4^5^6^7 = 0
 */


public class BitRoughWorks {

    static int solution(int[] nums) {
        return 0;
    }


    public static void main(String[] args) {
        int[] nums = {5,1,6};
        System.out.println(solution(nums));
    }
}
