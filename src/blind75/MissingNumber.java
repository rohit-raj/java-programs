package blind75;

//https://leetcode.com/problems/missing-number/
public class MissingNumber {

    static int missingNumber(int[] nums) {
        int n=nums.length;
        int totalSum = n*(n+1)/2;

        int currentSum = 0;
        for(int i=0;i< nums.length;i++){
            currentSum += nums[i];
        }

        return totalSum-currentSum;
    }

    static int missingNumberXor(int[] nums){
        int n = nums.length;
        int xor1 = 0, xor2 = 0;

        for (int i = 1; i <= n; i++) {
            xor2 = xor2 ^ nums[i-1]; // XOR of array elements
            xor1 = xor1 ^ i; //XOR up to [1...N-1]
        }
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        int[] inp = {0,1};
        System.out.println(missingNumberXor(inp));
    }
}
