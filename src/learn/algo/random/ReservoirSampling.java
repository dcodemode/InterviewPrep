package learn.algo.random;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class ReservoirSampling {

    /**
     * This function generates K random samples from array of nums
     * @param nums integer array in numbers
     * @param k random samples
     * @return random samples
     */

   public int[] generateSamples(int[] nums, int k) throws NoSuchAlgorithmException{
        // Create a reservoir array of k samples
        int[] reservoir = new int[k];

        // Initialize it with first k elements from nums
        int i = 0;
        for( ; i < k ; i++){
            reservoir[i] = nums[i];
        }

        //Using SecureRandom over Random for random number generation consistancy
        Random random = SecureRandom.getInstanceStrong();
        
        // Iterate from the (k+1)th element to nth element
        for( ; i < nums.length ; i++){
            // Pick a random index from 0 to i.
            int j = random.nextInt(i + 1);

            // If the randomly  picked index is smaller than
            // k, then replace the element present at the
            // index with new element from nums
            if(j < k){
                reservoir[j] = nums[i];
            }
        }

        System.out.println("Reservoir : " + Arrays.toString(reservoir));
        return reservoir;
    }

    public static void main(String[] args) {
        ReservoirSampling rs = new ReservoirSampling();

        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int k = 5;

        try {
           rs.generateSamples(nums, k);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
