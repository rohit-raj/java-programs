package ds.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class KthSmallestNumberInMatrix {

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while (low < high){
            int mid = low + (high-low)/2;
            int count = lessEqual(matrix, mid);
            if(count < k)
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }

    public static int lessEqual(int[][] matrix, int target){
        int count = 0, len = matrix.length, i = len-1, j=0;
        while (i>=0 && j<len){
            if(matrix[i][j] > target) {
                i--;
            } else {
                count = count + i + 1;
                j++;
            }
        }
        return count;
    }

    public static int findBrute(int[][] matrix, int k){
        int n = matrix.length;
        int[] nums = new int[n*n];
        int l=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                nums[l++] = matrix[i][j];
            }
        }
        Arrays.sort(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        return nums[k-1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,14,15}};
        int k = 8;

        System.out.println("findBrute : "+ findBrute(matrix, k));
        System.out.println("kthSmallest : "+ kthSmallest(matrix, k));
    }
}
