package ds.arrays;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Find union of two arrays
 */
public class Union {
    //naive
    static int [] unionNaive(int[] inp1, int[] inp2){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<inp1.length;i++){
            set.add(inp1[i]);
        }
        for(int j=0;j<inp2.length;j++){
            set.add(inp2[j]);
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
    //optimal
    static int[] unionOptimal(int[] inp1, int[] inp2){
        int n1 = inp1.length;
        int n2 = inp2.length;
        int j=0, i=0;
        ArrayList<Integer> union = new ArrayList<>();
        while(i<n1 && j<n2){
            if(inp1[i] <= inp2[j]) {
                if(!union.contains(inp1[i])) {
                    union.add(inp1[i]);
                }
                i++;
            } else {
                if(!union.contains(inp2[j])) {
                    union.add(inp2[j]);
                }
                j++;
            }
        }

        while(i<n1){
            if(!union.contains(inp1[i])) {
                union.add(inp1[i]);
            }
            i++;
        }
        while(j<n2){
            if(!union.contains(inp2[j])) {
                union.add(inp2[j]);
            }
            j++;
        }
        return union.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] inp1 = {5,7,8,10,12,14,15,17};
        int[] inp2 = {1,2,3,4,5,6};
        int[] res1 = unionNaive(inp1, inp2);
        int[] res2 = unionOptimal(inp1, inp2);
        printArray(res1, false);
        printArray(res2, false);
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
