package algo.sorting;

public class Selection {

    static void selectionSort(int[] inp){
        int n = inp.length;
        for(int i=0; i<n-1; i++){
            int index = i;
            int j = i+1;
            for(; j<n;j++){
                if(inp[index] > inp[j]){
                    index = j;
                }
            }
            System.out.println("index :: " + i + " :::: min :: "+j);
            if(inp[index] < inp[i]) {
                int temp = inp[i];
                inp[i] = inp[index];
                inp[index] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] inp = {64, 25, 12, 22, 11};
        selectionSort(inp);
        printArray(inp);
    }

    static void printArray (int[] array) {
        for (int value : array) {
            System.out.print(value + ",\t");
        }
        System.out.println();
    }
}
