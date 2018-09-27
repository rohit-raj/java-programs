package algo.strings;

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
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println("Original String : "+ str);
        System.out.println(removeDuplicates(str));
    }
}