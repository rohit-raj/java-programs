package algo.sorting;

public class MergeSort {

    static void merge(int[] inp, int low, int mid, int high){
        int n1 = mid-low+1;
        int n2 = high -mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        /*
         * copying into Left Array
         */
        /*for(int i=0; i<n1; i++){
            L[i] = inp[low+i];
        }*/
        if (n1 >= 0) System.arraycopy(inp, low, L, 0, n1);

        /*
         * copying into Right Array
         */
        /*for(int j=0; j<n2; j++){
            R[j] = inp[mid+1+j];
        }*/
        if (n2 >= 0) System.arraycopy(inp, mid + 1, R, 0, n2);


        int i=0,j=0,k=low;

        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                inp[k]=L[i];
                i++;
            } else{
                inp[k]= R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            inp[k]=L[i];
            i++;
            k++;
        }

        while (j<n2){
            inp[k]= R[j];
            j++;
            k++;
        }
    }

    static void sort(int[] inp, int low, int high){
        if(high > low){
            int mid = low + (high - low)/2;
            sort(inp, low, mid);
            sort(inp, mid+1, high);
            merge(inp, low, mid, high);
        }
    }
    public static void main(String[] args) {
        int[] inp = {64, 25, 12, 22, 11,29};
        sort(inp, 0, inp.length-1);
        printArray(inp);
    }

    static void printArray (int[] array) {
        for (int value : array) {
            System.out.print(value + ",\t");
        }
        System.out.println();
    }
}
