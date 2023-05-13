package learn.algo.random;

import java.util.Random;

public class ReservoirSampling {

    /**
     * This function generates K random samples from array of nums
     * @param nums integer array in numbers
     * @param k random samples
     * @return random samples
     */
    public static int[] generateSamples(int[] nums, int k){
        // Create a reservoir array of k samples
        int[] reservoir = new int[k];

        // Initialize it with first k elements from nums
        int i = 0;
        for( ; i < k ; i++){
            reservoir[i] = nums[i];
        }

        Random random = new Random();

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

        return reservoir;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        for(int i : generateSamples(nums, 5)){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
