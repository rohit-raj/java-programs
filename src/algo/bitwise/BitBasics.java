package algo.bitwise;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=5rtVTYAk9KQ
 * &
 * https://www.youtube.com/watch?v=ZwU6wSkepBI
 *
 *  * Rough work or practice file
 *  *
 *  * Xor of 1-N :
 *  * 0^1 = 1, 1^2 = 3, 2^4 = 0, 3^4 = 4 :
 *  * if(n%4 == 0) return n   // if n = 4, 1^2^3^4 = 4
 *  * if(n%4 == 1) return 1   // if n=5, 1^2^3^4^5 = 1
 *  * if(n%4 == 2) return n+1 // if n=6, 1^2^3^4^5^6 = 6+1 = 7
 *  * if(n%4 == 3) return 0   // if n=7, 1^2^3^4^5^6^7 = 0
 *
 *  XORs of all subset of an array is always 0
 *  [1,2,3] = [[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]
 *  all elements occurs in multiple of 1 hence xor is always 0.
 *  [1^2^3^1^2^1^3^2^3^1^2^3] = 0
 *
 */
public class BitBasics {

    static void checkOddOrEven(int n){
        if((n & 1) == 0) System.out.println(n + " is : even");
        else System.out.println(n + " is : Odd");
    }

    static void checkIthBit(int n, int i){
        int mask = 1<<i;
        int bit = (n & mask);
        if((n & mask) != 0) System.out.println(i+ "-th Bit of "+ n +" is: "+bit);
        else System.out.println(i+ "-th Bit of "+ n +" is: "+bit);
    }

    static void setIthBit(int n, int i){
        int mask = 1<<i;
        int x = n | mask;
        System.out.println("set "+i+"-th Bit of : "+n+" : is : "+ x);
    }

    static void clearIthBit(int n, int i){
        int mask = 1<<i;
        mask = ~mask;

        int x= n & mask;
        System.out.println("clear "+i+"-th Bit of : "+n+" : is : "+ x);
    }

    static void clearLastSetBit(int n){
        int x = n &(n-1);
        System.out.println("clear last Bit of : "+n+" : is : "+ x);
    }

    static void countSetBits(int x){
        int n = x;
        int count = 0;
        while(n != 0){
            if((n & 1) == 1) count++;
            n = n >> 1;
        }
        System.out.println("Total set bits in "+x+" is : "+count);
    }

    static void checkRepeatedElement(){
        int[] nums = {1,7,1,9,4,3,7,4,5,8,9,2,8,2,5};
        int xorSum = 0;
        for(int num : nums){
            xorSum ^= num;
        }
        System.out.println("Repeated Number is : "+ xorSum);
    }

    static void checkPowerOf2(int x){
        int n = x;
        if((n & (n-1))==0) System.out.println(x+" is power of 2");
        else System.out.println(x+" is not a power of 2");
    }

    static int xorOf1toN(int n){

        if(n%4 == 0){
            System.out.println("xor of 1 to "+n+" is : "+n);
            return n;
        }

        if(n%4 == 1){
            System.out.println("xor of 1 to "+n+" is : "+1);
            return 1;
        }

        if(n%4 == 2){
            System.out.println("xor of 1 to "+n+" is : "+n+1);
            return n+1;
        }

        if(n%4 == 3){
            System.out.println("xor of 1 to "+n+" is : "+0);
            return 0;
        }
        return -1;
    }

    static void xorOfMtoN(int m, int n){
        int ans = xorOf1toN(n) ^ xorOf1toN(m-1);
        System.out.println("xor of "+m+" to "+n+" is : "+ ans);
    }

    static void getPowerOfTwo(int n){
        n = 1<<n;
        System.out.println("n : "+ n);
    }

    static void swap2Nos(int a, int b){
        System.out.println("a : "+ a + " : b : "+ b);
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("a : "+ a + " : b : "+ b);
    }

    static void sum(int a, int b){
        int carry = 0;
        while(b != 0){
            carry = a & b;
            a = a^b;
            b = carry << 1;
        }
        System.out.println("sum : "+ a);
    }

    static void divide(long a, long b){
        long sign = ((a<0 && b>=0) || (a>=0 && b<0))?-1L:1L;
        a = Math.abs(a);
        b = Math.abs(b);
        long ans = 0L;
        for(int i = 31; i>=0; i--){
            if(b<<i<=a){
                a -= b<<i;
                ans |= 1L<<i;
            }
        }
        long result = sign<0?-ans:ans;
        System.out.println("result "+ result );
    }

    public static void main(String[] args) {
        checkOddOrEven(49);
        checkIthBit(5, 0);
        setIthBit(5, 1);
        clearIthBit(7, 1);
        clearLastSetBit(5);
        countSetBits(5);
        checkRepeatedElement();
        checkPowerOf2(15);
        xorOf1toN(5);
        xorOfMtoN(3,6);
        getPowerOfTwo(3);
        swap2Nos(2,5);
        sum(5,8);
        divide(10,3);

        int[] x = {9,1,3};

        System.out.println("----------------");

    }
}
