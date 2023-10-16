package algo.misc;

import com.sun.org.apache.regexp.internal.RE;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/html-entity-parser/
 */
public class HtmlEntityParser {

    public static Map<String, Character> cases(){
        Map<String, Character> map = new HashMap<>();
        map.put("&quot;", '\"');
        map.put("&apos;", '\'');
        map.put("&amp;", '&');
        map.put("&gt;", '>');
        map.put("&lt;", '<');
        map.put("&frasl;", '/');
        return map;
    }
    public static String entityParser(String text) {
        Map<String, Character> casesMap = cases();
        StringBuilder sb = new StringBuilder();

        int i=0;
        while (i< text.length()){
            if(text.charAt(i) =='&'){
                StringBuilder s = new StringBuilder();
                s.append(text.charAt(i));
                int j = i+1;
                while(j < text.length() && text.charAt(j)!=';' && text.charAt(j)!='&'){
                    s.append(text.charAt(j));
                    j++;
                }

//                System.out.println("string : "+s.toString());
                if(j<text.length() && text.charAt(j)!='&'){
                    s.append(text.charAt(j));
                    char c = casesMap.getOrDefault(s.toString(), '*');
                    if(c != '*'){
                        sb.append(c);
                        i=j+1;
                        continue;
                    }
                }
            }
            sb.append(text.charAt(i));
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "and I quote: &quot;...&quot;";


        System.out.println("entityParser : "+ entityParser(s));
    }
}
