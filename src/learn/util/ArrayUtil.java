package learn.util;

import java.util.Random;

public class ArrayUtil {


    public static void display(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] generateRandomArray(int size, int bound){
        int[] array = new int[size];
        Random rand = new Random();
        for(int i =0; i< size ; i++){
            array[i] = rand.nextInt(bound);
        }
        return array;
    }

    public static int[] generateRandomArray(int size){
        int[] array = new int[size];
        Random rand = new Random();
        for(int i =0; i< size ; i++){
            array[i] = rand.nextInt();
        }
        return array;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
