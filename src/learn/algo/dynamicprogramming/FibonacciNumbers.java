package learn.algo.dynamicprogramming;

/**
 * @author Varma Penmetsa
 *
 * Input  : n = 2
 * Output : 1
 *
 * Input  : n = 9
 * Output : 34
 *
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 */
public class FibonacciNumbers {

    /**
     * Using Recursion
     * Time Complexity: T(n) = T(n-1) + T(n-2)
     * Extra Space: O(n)
     */
    public static int fibonacci(int n){
        if(n <= 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    /**
     * Using Dynamic Programming
     * Time Complexity: O(n)
     * Extra Space: O(n)
     */
    public static int fibonacci1(int n) {
        int[] temp = new int[n + 2];

        temp[0] = 0;
        temp[1] = 1;
        for (int i = 2; i <= n; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }
        return temp[n];
    }

    /**
     * Space Optimized
     * Time Complexity: O(n)
     * Extra Space: O(1)
     */
    public static int fibonacci2(int n){
        int a = 0, b = 1, c;

        if (n == 0) {
            return a;
        }

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci2(9));
    }

}
