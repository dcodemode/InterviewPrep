package learn.ds.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 *
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/
 *
 */
public class HappyNumber {

    /**
     *Time Complexity: O(log n)
     */
    public int nextNumber(int n){
        int sum = 0;
        while(n > 0){
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    /**
     * Hashset approach
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     */
    public boolean isHappy1(int n) {
        Set<Integer> seen = new HashSet<>();
        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            n = nextNumber(n);
        };
        if (n == 1){
            return true;
        }
        return false;

    }

    /**
     * Fords cycle algorithm
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public boolean isHappy2(int n) {
        int current = n;
        int next = nextNumber(n);

        while(current != 1 && current!=next){
            current = nextNumber(current);
            next = nextNumber(nextNumber(next));
        }
        return current==1;
    }
}
