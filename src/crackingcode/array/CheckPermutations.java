package crackingcode.array;

/**
 *  1.2 Strings & Arrays
 *
 *  Given two strings, write a method to decide if one is a permutation of the other
 *
 *  A Permutation of a string is another string that contains same characters, only the order of characters can be different.
 *
 *  For example, “abcd” and “dabc” are Permutation of each other
 *
 *  Conditions:
 *
 *  1. Permutations are case sensitive
 *    Eg: "God" not same as "dog"
 *  2. White Space are significant
 *    Eg: "god       " is different from "dog"
 *
 *
 */
public class CheckPermutations {


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static boolean check(String a, String b){
        if(a.length() != b.length()){
            return false;
        }

        int[] memo = new int[128];

        for(int i = 0 ; i < a.length() ; i++){
            int val = (int) a.charAt(i);
            memo[val] = memo[val] + 1;
        }

        for(int i =0 ; i < b.length() ; i++){
            int val = (int) b.charAt(i);
            if(memo[val] == 0){
                return false;
            }
            memo[val] = memo[val] - 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(check("abakh;l","baahgvhjvhj"));
    }
}
