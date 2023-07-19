package algo.strings;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */

public class ReverseWordsInAString {


    static String reverseBrute(String str){
        Stack<String> stack = new Stack<>();

        String res = "";
        for (int i=0;i<str.length();i++){
            if(str.charAt(i) == ' ') {
                stack.push(res);
                res = "";
            } else {
                res += str.charAt(i);
            }
        }

        StringBuilder s = new StringBuilder();
        int i = 1;
        while (stack.size() != 0){
            s.append(stack.pop());
            s.append(" ");
        }

        return s.toString();
    }


    static String reverseOptimal(String str){
        int n = str.length();
        char[] ans = new char[n+1];

        int k = 0;
        for (int i=n-1;i>=0;i--) {
            char c = str.charAt(i);
            if(c == ' ') continue;

            int right = i;

            while (i>=0 && str.charAt(i) != ' '){
                i--;
            }

            for (int j=i+1;j<=right;j++) {
                ans[k++] = str.charAt(j);
            }
            ans[k++] = ' ';
        }
        return new String(ans, 0, k-1);
    }

    /**
     * This is still not faster than reverseOptimal,
     * reverseOptimal2 beats ~15% only
     * reverseOptimal beats ~99%
     */
    static String reverseOptimal2(String str){
        int n = str.length();
        String ans = "";

        for (int i=0;i <n;i++) {
            char c = str.charAt(i);
            if(c == ' ') continue;

            String temp = " ";
            while (i<n && str.charAt(i) != ' '){
                temp = temp+str.charAt(i);
                i++;
            }
            ans = temp+ans;
        }
        return ans.substring(1);
    }

    static String reverseOptimal3(String str){
        int n = str.length();

        int left = 0;
        int right = n-1;

        char[] strArr = str.toCharArray();

        StringBuilder temp = new StringBuilder();
        String ans = "";

        while (left <= right && strArr[left] == ' ') {
            left++;
        }

        while (left <= right && strArr[right] == ' ') {
            right--;
        }
//        System.out.println(left);
//        System.out.println(right);

        while (left<=right){
            char c = strArr[left];
//            System.out.println("c :: "+c);
            if(c != ' '){
                temp.append(c);
            } else {
//                int kk = 0;
                if(ans.equals("")){
                    ans = c+temp.toString();
//                    kk = 5;
                    temp = new StringBuilder();
//                    left++;
                }
                System.out.println("ans : " + ans.charAt(0)+" : temp : "+ temp+ " : c : "+c);

                if(temp.length() < 1 && ans.charAt(0) == ' '){
                    left++;
//                    temp = new StringBuilder();
                    continue;
                } else {
//                    left++;
//                    System.out.println("here : "+ temp+" :: kk "+kk);
                    ans = c+temp.toString()+ans;
                    temp = new StringBuilder();
                }

//                System.out.println("ans : " + ans);
//                temp = new StringBuilder();
            }

            left++;
        }
        if(!temp.toString().equals("")){
            if(ans.equals("")){
                ans = temp.toString();
            } else {
                ans=temp+ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "  hello  this is  world  ";
//        String str = "the sky is blue";
        System.out.println("str : "+ str);

//        String reverseBrute = reverseBrute(str);
        String reverseOptimal = reverseOptimal(str);

//        System.out.println("reverseBrute : "+ reverseBrute + " : len : "+ reverseBrute.length());
        System.out.println("reverseOptim : "+ reverseOptimal + " : len : "+ reverseOptimal.length());
    }
}
