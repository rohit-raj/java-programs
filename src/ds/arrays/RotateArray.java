package ds.arrays;
//https://leetcode.com/problems/rotate-array/
public class RotateArray {

    static void reverse(int[] inp, int start, int end){
        int temp;
        while(start < end){
            temp = inp[start];
            inp[start] = inp[end];
            inp[end]= temp;
            start++;
            end--;
        }
    }

    static void rotateByGivenCountRightShift(int[] inp, int d){
        int n = inp.length;
        d= d%n;

        reverse(inp, 0, n-d-1);
        reverse(inp, n-d, n-1);
        reverse(inp, 0, n-1);
    }

    static void rotateByGivenCountLeftShift(int[] inp, int d){
        int n = inp.length;
        d= d%n;

        reverse(inp, 0, d-1);
        reverse(inp, d, n-1);
        reverse(inp, 0, n-1);
    }

    public static void main(String[] args) {
        int[] inp = {1,2,3,4,5,6,7,8};
        int d = 2;
        rotateByGivenCountRightShift(inp, d);
        printArray(inp, false);

        int[] inp2 = {1,2,3,4,5,6,7,8};
        rotateByGivenCountLeftShift(inp2, d);
        printArray(inp2, false);

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
