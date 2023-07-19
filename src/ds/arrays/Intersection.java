package ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Intersection {
    //naive
    static int[] intersectionNaive(int[] inp1, int[] inp2){
        HashSet<Integer> set = new HashSet<>();

        for (int value : inp1) {
            for (int i : inp2) {
                if (value == i) {
                    set.add(value);
                }
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    static int[] intersectionNaive2(int[] inp1, int[] inp2){
        return inp1;
    }

    //optimal
    static int[] intersectionOptimal(int[] inp1, int[] inp2){
        int n1 = inp1.length;
        int n2 = inp2.length;
        int j=0, i=0;
        ArrayList<Integer> intersection = new ArrayList<>();
        while(i<n1 && j<n2){
            if(inp1[i] == inp2[j]) {
                if(!intersection.contains(inp1[i])) {
                    intersection.add(inp1[i]);
                }
                i++;
                j++;
            } else if(inp1[i] < inp2[j]){
                i++;
            } else {
                j++;
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] inp1 = {5,6,7,8,10,12,14,15,17};
        int[] inp2 = {1,2,3,4,5,6};
        int[] res1 = intersectionNaive(inp1, inp2);
        int[] res2 = intersectionOptimal(inp1, inp2);
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
//        for (int value : array) {
//            System.out.print(value + ",\t");
//        }
//        System.out.println();

        System.out.println(Arrays.toString(array));
    }
}
