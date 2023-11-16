package algo.misc;

import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/validate-ip-address
 */
public class ValidateIPAddress {
    public static String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]25[0-5])";
    public static Pattern patternIPV4 = Pattern.compile("^("+chunkIPv4+"\\.){3}"+chunkIPv4+"$");

    public static String chunkIPv6 = "([0-9a-fA-F]{1,4})";
    public static Pattern patternIPv6 = Pattern.compile("^("+chunkIPv6+"\\:){7}"+chunkIPv6+"$");

    public static String validIPAddress(String queryIP) {
        if(patternIPV4.matcher(queryIP).matches()) return "IPv4";
        else if(patternIPv6.matcher(queryIP).matches()) return "IPV6";
        else return "Neither";

    }

    public static void main(String[] args) {
        String[] ips = {"192.168.1.1", "192.168.1.00",
                "2001:0db8:85a3:0000:0000:8a2e:0370:7334", "02001:0db8:85a3:0000:0000:8a2e:0370:7334"};

        for(String ip : ips){
            System.out.println(ip + " : "+ validIPAddress(ip));
        }
    }
}
