package learn.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public static List<List<String>> twoDStringArrayToList(String[][] arr) {
        int n = arr.length;
        List<List<String>> result = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>(Arrays.asList(arr[i])));
        }
        return result;
    }

    public static List<List<Integer>> twoDIntArrayToList(int[][] arr) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>(n);

        for (int[] a : arr) {
            List<Integer> list = new ArrayList<>(a.length);
            for(int i : a){
                list.add(i);
            }
            result.add(list);
        }
        return result;
    }
}
