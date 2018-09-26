package learn.ds.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Varma Penmetsa
 *
 * Print first N Prime numbers, given no negative integer.
 *
 * Input  : 2
 * Output : [2,3]
 *
 * Input  : 3
 * Output : [2,3,5]
 *
 * Input  : 7
 * Output : [2, 3, 5, 7, 11, 13, 17]
 *
 */
public class NPrimeNumbers {

    /**
     * Using dynamic programming:
     *
     * Any number that is not prime is always divisible by at least one prime that comes before it in the number series.
     * If any number doest divide itself with all the prime numbers before it then that number is also prime
     *
     * Time Complexity   :
     * Space Complexity  :  O(n)
     *
     *
     * https://stackoverflow.com/questions/33725505/printing-the-first-n-prime-numbers
     */
    public static void printPrimeNumbers(int n) {
        if(n == 0){
            return;
        }
        List<Integer> primeNoList = new ArrayList<>();
        primeNoList.add(2);

        // skip over even numbers since they are not prime
        for (int i = 3; primeNoList.size() < n; i += 2) {
            boolean isPrime = true;

            for (Integer prime : primeNoList) { // check current prime numbers to see if it evenly divides into number
                if (i % prime == 0) { // when number is not prime
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primeNoList.add(i);
            }
        }
        System.out.println(primeNoList);
    }

    public static void main(String[] args) {
        printPrimeNumbers(7);
    }

}
