package algo.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/remove-duplicates-from-a-string-in-o1-extra-space/
 * Remove duplicates from a string in O(1) extra space
 */
class RemoveDuplicatesFromString {
    static String removeDuplicates(String str){
        int n = str.length();
        int counter = 0;
        int x, i = 0, length = 0;
        StringBuilder str1 = new StringBuilder(str);

        while(i < n){
            x = str.charAt(i) - 97;
            if((counter & (1 <<x)) == 0){
                str1.setCharAt(length, str.charAt(i));
                counter = counter | (1 <<x);
                length++;
            }
            i++;
        }
        return str1.substring(0, length);
    }

    static String removeRep(String str){
        int n = str.length();
        int write = 0;
        Stack<Character> st = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
        }

        System.out.println("map : "+ map);

        for(int read=0;read<n;read++){
            if(!st.isEmpty() && st.peek() == str.charAt(read)){
                st.pop();
            } else {
                st.push(str.charAt(read));
            }
        }

//        StringBuilder s= new StringBuilder();
//        while (!st.isEmpty()){
//            s.insert()
//        }
        return st.toString();
    }
    public static void main(String[] args) {
        String str = "aabccd";
        System.out.println("Original String : "+ str);
        System.out.println(removeRep(str));
    }
}