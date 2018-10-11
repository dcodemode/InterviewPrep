package learn.algo.math;

/**
 * How we check whether a number is Prime or not?
 *
 * https://www.geeksforgeeks.org/prime-numbers/
 */

public class CheckPrimeNumber {

    /*
     * Brute force
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void check(int number){
        if(number <= 1){
            System.out.println("False");
            return;
        }

        int n = number - 1;
        while(n > 1){
            if(number % n == 0){
                System.out.println("False");
                return;
            }
            n--;
        }
        System.out.println("True");
    }

    public static void main(String[] args) {
        check(11);
    }

}
