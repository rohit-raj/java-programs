package ds.arrays;

//https://leetcode.com/problems/move-zeroes/
public class Move0sToEnd {

    static int[] moveAll0s(int[]inp){
        int n=inp.length;
        int i=0,j=-1;

        // find first occurrence of 0
        for(i=0;i<n;i++){
            if(inp[i] == 0){
                j=i;
                break;
            }
        }

        if(j == -1){
            return inp;
        }

        for(i=j+1;i<n;i++){
            if(inp[i]!=0){
                int temp = inp[i];
                inp[i] = inp[j];
                inp[j]=temp;
                j++;
            }
        }


        return inp;

    }

    public static void main(String[] args) {
        int[] input1 = {1};
        int [] res = moveAll0s(input1);
        printArray(res, false);
    }

    static void printArray (int[] array, boolean b) {
        if(b) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(i + ",\t");
            }
            System.out.println();
        }
        for (int value : array) {
            System.out.print(value + ",\t");
        }
        System.out.println();
    }
}
