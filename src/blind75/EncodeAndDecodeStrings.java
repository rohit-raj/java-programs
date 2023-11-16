package blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/encode-and-decode-strings/
 */

public class EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.replace("/","//")).append("/:");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<s.length()){
            if(i+1<s.length() && s.charAt(i) == '/' && s.charAt(i+1)== ':'){
                res.add(sb.toString());
                sb = new StringBuilder();
                i+=2;
            } else if(i+1<s.length() && s.charAt(i)=='/' && s.charAt(i+1)=='/'){
                sb.append('/');
                i+=2;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings codec = new EncodeAndDecodeStrings();
        String[] inp = {"Hello","World"};
        List<String> strs = new ArrayList<>(Arrays.asList(inp));

        System.out.println("input : "+ strs);
        System.out.println("===========================");
        String encoded = codec.encode(strs);
        List<String> decoded = codec.decode(encoded);
        System.out.println("=========output============");
        System.out.println(decoded);
    }
}
