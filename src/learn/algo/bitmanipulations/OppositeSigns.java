package learn.algo.bitmanipulations;

/**
 * 8/24/18
 * @author Varma Penmetsa
 * Level: Easy
 *
 * Detect if two integers have opposite signs
 *
 * Given two signed integers, write a function that returns true if the signs of given integers are different, otherwise false.
 *
 * For example:
 *   Input   : -1 , 100
 *   Output  : true
 *
 *   Input   : -100 , -200
 *   Output  : false
 *
 * The function should not use any of the arithmetic operators.
 *
 * https://www.geeksforgeeks.org/detect-if-two-integers-have-opposite-signs/
 */
public class OppositeSigns {

    // The XOR of x and y will have the sign bit as 1 if they have opposite sign.
    // In other words, XOR of x and y will be negative number if x and y have opposite signs
   public static boolean checkSign(int x, int y){
       return ((x ^ y) < 0);
   }

    public static void main(String[] args) {
        System.out.println(checkSign(-1,-100));
    }
}
