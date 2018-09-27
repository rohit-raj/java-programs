package algo;

class CountSetBitsOfNumber {

    static int countSetBits(int a){
        int count = 0;

        while (a > 0){
            a &= (a-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 3;

        System.out.println("set bit count = " + countSetBits(a));

        /**
         * If we get set bit count as 1 then that number is a power of 2
         * 4 : 0100, 2 : 0010, 8 : 1000 etc
         */
    }
}