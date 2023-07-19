package algo.bitwise;

/**
 * https://youtu.be/ZwU6wSkepBI?t=2286
 * Question to find 2 single elements among repeated elements.
 * Repeated elements are twice only.
 * The array is not sorted.
 *
 * eg : [6,2,1,3,2,1]
 */
public class FindSingleNos {

    static int findSetBit(int n){
        int count = 0;
        while(n != 0){
            if((n & 1) == 1) break;
            count++;
            n = n >> 1;
        }
        return count;
    }

    static void find2SingleNos(){
        int[] nums = {4,6,2,1,3,2,5,1,7,4,7,5};

        int xorSum = 0;
        for(int num : nums){
            xorSum ^= num;
        }

        System.out.println("xors : "+ xorSum);

        int setBitLocation = findSetBit(xorSum);

        System.out.println("set bit : "+ setBitLocation);

        int xor1 = 0;
        int xor2 = 0;
        for(int num : nums){
            /**
             * num & (1<<setBitLocation)
             * this is going to check if the 1st set bit of xorSum is set in num or not.
             *
             */
            if((num & (1<<setBitLocation)) != 0){
                xor1 = xor1 ^ num;
            } else
                xor2 = xor2 ^ num;
        }

        System.out.println("number1 : "+ xor1+ " : number 2 : "+ xor2);

    }

    public static void main(String[] args) {
        find2SingleNos();
    }
}
