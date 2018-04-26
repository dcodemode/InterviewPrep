package learn.ds.array;

/**
 * Maximum Length Bitonic Subarray
 *
 * Simple Examples
 *   1) A[] = {12, 4, 78, 90, 45, 23}, length 5.
 *   2) A[] = {20, 4, 1, 2, 3, 4, 2, 10}, length 5.
 * Extreme Examples
 *   1) A[] = {10}, Output 1.
 *   2) A[] = {10, 20, 30, 40}, Output : 4.
 *   3) A[] = {40, 30, 20, 10}, Output : 4.
 *
 * https://www.geeksforgeeks.org/maximum-length-bitonic-subarray/
 */
public class BitonicSubarrayMaxLength {

    /**
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     */
    public static int maxLength(int[] array){
        int[] inc = new int[array.length];
        int[] dec = new int[array.length];

        // Increasing sub-sequence
        int count = 1;
        for(int i = 0 ;i < inc.length-1 ; i++){
           if(array[i] <= array[i+1]){
               inc[i+1] = count++;
           }else {
               count = 1;
           }
        }

        //Decreasing sub-sequence
        count = 1;
        for(int i = array.length - 1; i > 0 ; i-- ){
            if(array[i] <= array[i-1]){
                dec[i-1] = count++;
            }else {
                count = 1;
            }
        }

        //Find Max inc[i] + dec[i]
        int max = 0;
        for(int i = 0; i < array.length; i++){
            max = Integer.max(max,inc[i]+dec[i]);
        }
        return max+1;
    }

    public static void main(String[] args) {
        int[] array = {20, 4, 1, 2, 3, 4, 2, 10};
        System.out.println(maxLength(array));

    }
}
