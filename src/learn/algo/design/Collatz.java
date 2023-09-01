package learn.algo.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 
 * Compute the number of Collatz Conjecture steps from a given starting point.
 * The Collatz Conjecture says if you take a positive integer N and repeatedly set either N=N/2 (if it's even) or N= 3N+1 (if it's odd), N will eventually be 1.
 * 
 * Example:  5 -> 16 -> 8 -> 4 -> 2 -> 1 (5 steps).
 * Write a class called Collatz with one method, steps_from(n), that returns the smallest number of steps required to get from N to 1.
 * 
 * The steps_from(n) method may be called many times for a given instance of the class.
 * 
 */
public class Collatz {

    public static Collatz instance = null;

    private Map<Integer, Integer> memo;

    private Collatz(){
        System.out.println("Creating Collatz class");
memo = new HashMap<>();
    }

    public static Collatz getInstance(){
        if(instance == null){
            instance = new Collatz();
        }
        return instance;
    }
    
    public int stepsFrom(int num) {
        if(memo.containsKey(num)) {
            System.out.println("Retrving " + num + " from memo");
            return memo.get(num);
        }
        int stepCount = 0;
        int orig = num; 
        while(num > 1){
            if(num % 2 == 0){
                num = num / 2;
            }else{
                num = (3 * num ) + 1;
            }
            if(memo.containsKey(num)) {
                System.out.println("Retrving " + num + " from memo");
                stepCount += memo.get(num);
            }else{
                stepCount++;
            }
        }
        memo.put(orig, stepCount);
        return stepCount;
   }

   public static void main(String[] args) {
    
    Collatz  obj = Collatz.getInstance();

    Random rand = new Random();

    for(int i = 0 ; i < 50 ; i++){
        int n = rand.nextInt(50);
        System.out.println("Collatz Conjecture for " + n + " is " + obj.stepsFrom(n));
    }
    
   }
   
}
