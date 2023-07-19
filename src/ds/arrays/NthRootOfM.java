package ds.arrays;

public class NthRootOfM {

    static int nthRootOfMBrute(int m, int n){
        for(int i=1;i<m;i++){
            int mul = 1;
            for(int j=1;j<=n;j++){
                mul = mul*i;
            }
            if(mul == m){
                return i;
            }
        }
        return -1;
    }


    static int nThPowerOfANum(int mid, int n, int m){
        int mul = 1;
        for(int i=1;i<=n;i++){
            mul  = mul*mid;
            if(mul > m){
                return 2;
            }
        }
        if(mul == m) return 1;
        return 0;
    }
    static int nthRootOfMOptimal(int m, int n){
        int low = 1;
        int high = m;
        while (low <= high){
            int mid = low + (high-low)/2;
            int val = nThPowerOfANum(mid, n, m);
            if(val == 1){
                return mid;
            } else if(val == 2){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int m = 27;
        int n = 3;

        System.out.println("nthRootOfMBrute : "+nthRootOfMBrute(m, n));
        System.out.println("nthRootOfMOptimal : "+nthRootOfMOptimal(m, n));
    }
}
