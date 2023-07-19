package ds.arrays;
//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
public class CheckIfArraySortedAndRotated {
    static boolean check(int[] inp) {
        int k = 0, n = inp.length;
        for (int i = 0; i < n; ++i) {
            if (inp[i] > inp[(i + 1) % n]) {
                k++;
            }
            if (k > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] inp = {6,3,9,4,5};

        System.out.println(check(inp));
    }
}
