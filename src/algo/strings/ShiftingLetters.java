package algo.strings;

/**
 * https://leetcode.com/problems/shifting-letters/
 */
public class ShiftingLetters {

    public static String shiftingLettersBrute(String s, int[] shifts){
        char[] ans = s.toCharArray();
        for(int i=0;i<shifts.length;i++){
            for(int j=0;j<=i;j++){
//                System.out.print(ans[j]+" "+" : int value : "+ (ans[j]-'a')+'\t');
                int value = ans[j]-'a';
                value= (value+shifts[i])%26;
                ans[j] = (char)(value+'a');
            }
//            System.out.println();
        }
        return String.valueOf(ans);
    }

    public static String shiftingLettersOptimal(String s, int[] shifts){
        char[] ans = s.toCharArray();
        int x = 0;
        for(int shift : shifts){
            x = (x+shift)%26;
        }
//        System.out.println("x : "+x);
//        System.out.println();

        for(int i=0;i<ans.length;i++){
            int value = ans[i]-'a';
            value= (value+x)%26;
            ans[i] = (char)(value+'a');
//            x = (x-shifts[i])%26;
            x = Math.floorMod(x-shifts[i], 26);
//            System.out.println("x : "+x);
        }
        return String.valueOf(ans);
    }

    /**
     * instead of calculating from start
     * @param s
     * @param shifts
     * @return
     */
    public static String shiftingLettersOptimal2(String s, int[] shifts){
        char[] ans = s.toCharArray();

        int total = 0;
        int i = s.length()-1;
        while (i>=0){
            total+=shifts[i]%26;
            ans[i] = (char)(((ans[i]-'a'+total)%26)+'a');
            i--;
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        String s = "ruu";//getSaltString();
        int[] shifts = {26,9,17};

        System.out.println("input : "+s);
        System.out.println("shiftingLettersBrute : " +shiftingLettersBrute(s, shifts));
        System.out.println("shiftingLettersOptimal : " +shiftingLettersOptimal(s, shifts));
        System.out.println("shiftingLettersOptimal2 : " +shiftingLettersOptimal2(s, shifts));
    }
}
