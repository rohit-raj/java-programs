package algo.bitwise;

class PowerOfTwo {

    /**
     * basically this solution works on the fact that the bitwise and
     * when we do bitwise and of the number which is a square with (number - 1) then it results in 0
     * a square number will only have 1 set bit, and the (number -1) will have all the bit set expect the
     * bit set in the original number
     * eg: 4 : 0100, 8 : 1000 etc, 3 : 0011, 7 : 0111 etc
     * 4 & 3 will result in 0 : 0100 & 0011 = 0000
     *
     * Another solution is to count the set bit, if the set bit is 1 then the number is power of 2.
     * @param a
     * @return
     */

    static boolean isPowerOf2(int a){
        return ((a != 0) && (a &(a-1)) == 0);
    }

    public static void main(String[] args) {
        int a = 9;
        if(isPowerOf2(a)){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}