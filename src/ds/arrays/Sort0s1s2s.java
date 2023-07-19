package ds.arrays;

public class Sort0s1s2s {

    static void sortArrayBetter(int[] inp){
        int count_0=0, count_1 = 0, count_2 = 0;

        for(int i=0;i < inp.length;i++){
            if(inp[i] == 0){
                count_0++;
            } else if(inp[i]==1){
                count_1++;
            } else
                count_2++;
        }

        for(int i =0;i<inp.length;i++){
            if(count_0 >0){
                inp[i] = 0;
                count_0--;
            } else if(count_1 > 0){
                inp[i] = 1;
                count_1--;
            } else {
                inp[i]=2;
                count_2--;
            }
        }

    }

    /**
     * Dutch national flag problem
     * @param inp
     */

    static void sortArrayOptimal(int[] inp){
        int mid = 0;
        int low = 0;
        int high = inp.length-1;
        int temp;

        while(mid <= high){
            if(inp[mid] == 0){
                temp = inp[low];
                inp[low] = inp[mid];
                inp[mid] = temp;
                low++;
                mid++;
            }
            else if(inp[mid] == 2){
                temp = inp[high];
                inp[high] = inp[mid];
                inp[mid] = temp;
                high--;
            }
            else{
                mid++;
            }
        }
    }
    public static void main(String[] args) {
        int[] inp = {0,0,2,2,1,0,0,0,0,2,1,2,0,0,1};

//        sortArrayBetter(inp);
//        printArray(inp, false);

        sortArrayOptimal(inp);
        printArray(inp, false);
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
