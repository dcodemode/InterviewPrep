package crackingcode.array;


/**
 *
 * 1.1 Strings & Arrays
 *
 * Implement an algorithm to determine if the string has all unique characters.
 *
 * What if you can't use additional data stricture
 */
public class IsUnique {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static boolean checkUniqueness(String text){
        if(text.length() > 128){
            return false;
            // Since we can only have 128 unique characters in base ASCII table
        }

        boolean[] char_set = new boolean[128];

        for(char c : text.toCharArray()){
            if(char_set[c]){
                return false;
            }else{
                char_set[c] = true;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(checkUniqueness("ab"));
    }
}