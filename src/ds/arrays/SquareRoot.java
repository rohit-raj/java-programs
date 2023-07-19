package ds.arrays;

/**
 * https://youtu.be/Bsv3FPUX_BA
 */
public class SquareRoot {

    static int findRootBrute(int n){
        int i=0;
        int ans = -1;
        while(true){
            if(i*i <= n){
                ans = i;
                i++;
            } else {
                break;
            }
        }
        return ans;
    }

    static int findRootOptimal(int n){
        int low = 1;
        int high = n;
        int ans = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if((mid * mid) <= n){
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 20;

        System.out.println("findRootBrute : "+ findRootBrute(n));
        System.out.println("findRootOptimal : "+ findRootOptimal(n));
    }
}
