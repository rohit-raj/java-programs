package ds.arrays;

//https://leetcode.com/problems/max-consecutive-ones/
public class ConsecutiveOnes {

    static int findOnes(int[] inp){
        int max = -1;
        int localCount = 0;
        for(int i=0;i<inp.length;i++){
            if(inp[i] ==1) {
                localCount++;
            } else {
                localCount = 0;
            }
            max = Math.max(max, localCount);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] inp = {1,1,0,1,1,1,1,1,1,1,0,0,0,1,1,0,1,1,1,1,1,1};
        int count = findOnes(inp);
        System.out.println("1's count : "+ count);
    }
}
