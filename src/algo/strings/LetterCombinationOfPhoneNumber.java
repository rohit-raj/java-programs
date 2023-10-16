package algo.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number
 */
public class LetterCombinationOfPhoneNumber {
    char[][] buttons = {
        "abc".toCharArray(),
        "def".toCharArray(),
        "ghi".toCharArray(),
        "jkl".toCharArray(),
        "mno".toCharArray(),
        "pqrs".toCharArray(),
        "tuv".toCharArray(),
        "wxyz".toCharArray()
    };


    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();

        List<String> res = new ArrayList<>();

        generate(1, buttons[digits.charAt(0)-'0'-2], digits, new StringBuilder(), res);
        return res;

    }

    public void generate(int idx, char[] button, String digits, StringBuilder sb, List<String> res){
        if(sb.length() >= digits.length()){
            res.add(sb.toString());
            return;
        }
        for(int i=0;i<button.length;i++){
            sb.append(button[i]);
            if(idx>= digits.length()){
                generate(idx+1, button, digits, sb, res);
            } else {
                generate(idx+1, buttons[digits.charAt(idx)-'0'-2], digits, sb, res);
            }
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";

        LetterCombinationOfPhoneNumber com = new LetterCombinationOfPhoneNumber();
        List<String> ans = com.letterCombinations(digits);

        System.out.println("input : "+ digits);
        System.out.println("=================================");
        System.out.println("output : "+ ans);
    }
}
