package ds.arrays;

import java.util.HashMap;

public class MaxSubArrayWithGivenSum {

    static int add(int[] inp, int start, int end){
        int sum=0;
        for(int i=start;i<=end;i++){
            sum+=inp[i];
        }
        return sum;
    }

    static int lengthOfSubArrayNaive(int[] inp, int sum){
        int maxLength = -1;
        int low = -1;
        int high = -1;
        for(int i=0;i<inp.length;i++){
            for(int j=i;j<inp.length;j++){
                int calculatedSum = add(inp, i,j);
                if(sum == calculatedSum){
                    if(maxLength < j+1-i) {
                        maxLength = j+1-i;
                        low = i;
                        high = j;
                    }
                }
            }
        }
//        System.out.println("low : "+low+" : high : "+high);
        return maxLength;
    }

    static int lengthOfSubArrayBetter(int[] inp, int sum){
        int maxLength = -1;
        int low = -1;
        int high = -1;
        for(int i=0;i<inp.length;i++){
            int calculatedSum=0;
            for(int j=i;j<inp.length;j++){
                calculatedSum+=inp[j];
                if(sum == calculatedSum){
                    if(maxLength < j+1-i) {
                        maxLength = j+1-i;
                        low = i;
                        high = j;
                    }
                }
            }
        }
//        System.out.println("low : "+low+" : high : "+high);
        return maxLength;
    }

    static int lengthOfSubArrayBetter2(int[] inp, int sum){
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        int calculatedSum = 0;
        int maxLen = 0;
        for(int i=0;i<inp.length;i++){
            calculatedSum+=inp[i];
            if(calculatedSum == sum){
                maxLen = Math.max(maxLen, i+1);
            }

            int prevSum = calculatedSum - sum;
            if(preSumMap.containsKey(prevSum)){
                int len = i-preSumMap.get(prevSum);
                maxLen = Math.max(maxLen, len);
            }
            if(!preSumMap.containsKey(calculatedSum))
                preSumMap.put(calculatedSum,i);
        }
        return maxLen;
    }

    static int lengthOfSubArrayOptimal(int[] inp, long sum){
        long calculatedSum = inp[0];
        int maxLen = 0;
        int left=0;
        int right=0;
        while(right<inp.length){
            while(left<=right && calculatedSum > sum){
                calculatedSum-=inp[left++];
            }

            if(calculatedSum == sum){
                maxLen = Math.max(maxLen, right-left+1);
            }

            right++;
            if(right<inp.length) calculatedSum+=inp[right];
        }
//        System.out.println("low : "+left+" : high : "+right);
        return maxLen;
    }



    public static void main(String[] args) {
        int[] inp = {1,2,1,3,0,2,4,2,3,1,1,1,1};
        int k = 6;

        System.out.println("lengthOfSubArrayNaive :: "+ lengthOfSubArrayNaive(inp, k));
        System.out.println("lengthOfSubArrayBetter :: "+ lengthOfSubArrayBetter(inp, k));
        System.out.println("lengthOfSubArrayBetter2 :: "+ lengthOfSubArrayBetter2(inp, k));
        System.out.println("lengthOfSubArrayOptimal :: "+ lengthOfSubArrayOptimal(inp, k));
    }
}
