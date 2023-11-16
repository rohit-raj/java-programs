package ds.arrays;

/**
 * https://www.geeksforgeeks.org/count-of-triplets-in-an-array-i-j-k-such-that-i-j-k-and-ak-ai-aj/
 *
 * Given an array arr[] of N integers, the task is to count number of triplets (i, j, k) in the array such that a[k] < a[i] < a[j] and i < j < k.
 * Examples:
 *
 * Input: arr[] = {2, 5, 1, 3, 0}
 * Output: 4
 * Explanation:
 * Below are the triplets (i, j, k) such that i < j < k and a[k] < a[i] < a[j]:
 * 1. (0, 1, 2) and arr[2] < arr[0] 1 < 2 < 5.
 * 2. (0, 1, 4) and arr[4] < arr[0] 0 < 2 < 5.
 * 3. (0, 3, 4) and arr[4] < arr[0] 0 < 2 < 3.
 * 4. (2, 3, 4) and arr[4] < arr[2] 0 < 1 < 3.
 * Input: arr[] = {2, 5, 1, 2, 0, 3, 10, 1, 5, 0 }
 * Output: 25
 */
public class CountTriplets {

    public static int countTripletsBrute(int[] arr, int n){
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[k] < arr[i] && arr[i]<arr[j]){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int countTripletsOptimal(int[] arr, int n){
        int ans=0;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=i+1;j<n;j++){
                if(arr[i]<arr[j])
                    count++;
                else ans+=count;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 2, 5, 1, 3, 0 };

        int n = arr.length;

        System.out.println("countTripletsBrute : " + countTripletsBrute(arr, n));
        System.out.println("countTripletsOptimal : " + countTripletsOptimal(arr, n));
    }
}
