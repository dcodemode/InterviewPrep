package crackingcode.array;

/**
 *  1.3 Arrays and Strings
 *
 *  Write a method to replace all spaces in a string with '%20'. You may assume that the sting
 *  has sufficient space at the end to hold the additional characters, and that you are given
 *  the "true" length of the string.
 *
 *  Note: If implemented in Java, please use character array so that you can perform this operation in place
 *
 *  Example:
 *
 *  Input:  "Mr John Smith    ", 13
 *  Output: "Mr%20John%20Smith"
 *
 *  Input: "Mr John Smith", 13
 *  Output: Mr%20John%20Smith
 *
 *  https://www.geeksforgeeks.org/urlify-given-string-replace-spaces/
 */
public class Urlify {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public static String convert(String str, int len){
        int spaces = 0;
        for(int i = 0 ; i < len ; i++){
            if(str.charAt(i) == ' '){
                spaces++;
            }
        }

        int new_length = len + 2 * spaces;
        char[] new_char = new char[new_length];

        int index = new_length -1;

        char[] char_arr = str.toCharArray();
        for(int i = len - 1 ; i >= 0 ; i--){
            if(char_arr[i]  != ' '){
                new_char[index--] = char_arr[i];
            }else{
                new_char[index--] = '0';
                new_char[index--] = '2';
                new_char[index--] = '%';
            }
        }
        return new String(new_char);
    }

    public static void main(String[] args) {
        System.out.println(convert("Mr John Smith", 13));
    }
}
