package blind75;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {
    //Naive : n2
    static boolean findDuplicateNaive(int[] inp){
        for(int i=0;i<inp.length-1;i++){
            for(int j=i+1;j<inp.length;j++){
                if(inp[i] == inp[j]){
                    return true;
                }
            }
        }
        return false;
    }


    static boolean findDuplicateOptimal(int[] inp){
        HashSet<Integer> set = new HashSet<>();
        for(int value : inp){
            set.add(value);
        }

        return set.size() < inp.length;
    }

    public static void main(String[] args) {
        int[] inp = {3,5,6,1,4};
        System.out.println(findDuplicateNaive(inp));
        System.out.println(findDuplicateOptimal(inp));
    }
}
