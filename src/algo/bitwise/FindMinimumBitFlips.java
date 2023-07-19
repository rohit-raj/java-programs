package algo.bitwise;

/**
 * https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/
 */
public class FindMinimumBitFlips {

    static int minBitFlips(int start, int goal) {
        int allSetBits = start^goal;

        //count setBits
        int count = 0;
        while (allSetBits!=0){
            if((allSetBits & 1) == 1) count++;
            allSetBits = allSetBits>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        int start = 7;
        int goal = 10;

        System.out.println("minBitFlips : "+ minBitFlips(start, goal));
    }

}
