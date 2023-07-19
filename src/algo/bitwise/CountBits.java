package algo.bitwise;

/**
 * https://www.geeksforgeeks.org/count-total-set-bits-in-all-numbers-from-1-to-n/
 */
class CountBits {

    static int countSetBits(int a){
        int count = 0;

        while (a > 0){
            a &= (a-1);
            count++;
        }
        return count;
    }

    static int countSetBitsUtil(int x) {
        int count = 0;
        for(int i = 1; i <= x; i++){
            count += countSetBits(i);
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 3;
        System.out.println("set bit count = " + countSetBitsUtil(a));

    }
}