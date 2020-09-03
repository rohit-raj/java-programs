package algo.primeNumbers;

/**
 * Created by rohit on 03/09/20.
 */
public class PrimeCount {

    /**
     * find count of all prime numbers below a certain number
     * Leetcode : https://leetcode.com/problems/count-primes/discuss/57593/12-ms-Java-solution-modified-from-the-hint-method-beats-99.95
     *
     * The idea is, count of prime number will always be less than or equal to half of the number.
     * and in that half of the number, there can be odd composite number like :
     * 9, 15, 21, 25 etc.
     * So remove these odd composite numbers and the actual count will be n/2  -count of composite numbers
     *
     * The loop runs from 3 with diff of 2, just to skip the even numbers, as we have already removed them from
     * counting
     *
     * This is only for the count of numbers and not for generating the prime number sequence
     */
    static int findPrimeCount(int n) {
        if (n < 3)
            return 0;

        boolean[] compositeList = new boolean[n];
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
//            System.out.println("i : "+i+ " ::: f[i] :: "+compositeList[i]);
            if (compositeList[i])
                continue;

            for (int j = i * i; j < n; j += 2 * i) {
//                System.out.println("j : "+j+ " ::: compositeList[j] :: "+compositeList[j]);
                if (!compositeList[j]) {
                    --count;
                    compositeList[j] = true;
                }
            }
        }

        return count;
    }


    static int findPrimeCountInRange(int m, int n) {
        int mPrimeCount = findPrimeCount(m);
        int nPrimeCount = findPrimeCount(n);

        return nPrimeCount - mPrimeCount;
    }
    public static void main(String[] args) {
        System.out.println("\nprime count : "+ findPrimeCount(30));
        System.out.println("\nprime count : "+ findPrimeCount(13));
        System.out.println("\nprime count in range : "+ findPrimeCountInRange(13, 30));

    }
}
