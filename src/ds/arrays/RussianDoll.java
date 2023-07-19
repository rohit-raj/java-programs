package ds.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 * https://www.youtube.com/watch?v=DnR_k51J5PM
 */
public class RussianDoll {

    static int maxEnvelopes(int[][] envelopes){
        int n = envelopes[0].length;

        Arrays.sort(envelopes, (a,b)->Integer.compare(a[0], b[0]));

        int[] ans = new int[envelopes.length];

        int maxLen = 1;
        ans[0] = 1;

        for(int i=1;i<ans.length;i++){
            ans[i] = 1;
            for(int j=0;j<i;j++){
                if(envelopes[i][0] != envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    ans[i] = Math.max(ans[i], ans[j]+1);
                }
            }
            maxLen = Math.max(maxLen, ans[i]);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};

        System.out.println("maxEnvelopes : "+ maxEnvelopes(envelopes));
    }

    static void print2DArray(String message, int[][] mat){
        System.out.print(message);
        for (int[] ints : mat) {
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            System.out.print(list);
        }
        System.out.println();
    }

}
