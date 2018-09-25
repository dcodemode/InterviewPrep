package learn.ds.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Varma Penmetsa
 *
 *
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 *
 * Example 1:
 *
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 *
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 *
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 *
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *
 * https://leetcode.com/problems/integer-to-english-words/description/
 * https://www.programcreek.com/2014/05/leetcode-integer-to-english-words-java/
 */
public class NumberToEnglishWord {

    Map<Integer, String> map = new HashMap<>();
    //Fill map with distinct values.
    public void fillMap(){
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
    }

    //This method handles triplet ie ( 3 digit numbers)
    public String convert(int num) {
        fillMap();

        StringBuffer sb = new StringBuffer();

        if (num >= 100) {
            int numHundreds = num / 100;
            sb.append(" " + map.get(numHundreds) + " Hundred");
            num = num % 100;
        }

        if (num > 0) {
            if (num > 0 && num < 20) {
                sb.append(" " + map.get(num));
            } else {
                int numTens = num / 10;
                sb.append(" " + map.get(numTens * 10));
                num = num % 10;

                if (num > 0) {
                    sb.append(" " + map.get(num));
                }
            }
        }
        return sb.toString();
    }

    //General Method all numbers
    public String numberToWord(int num){
        fillMap();
        StringBuilder sb = new StringBuilder();

        if(num == 0){
            sb.append(map.get(num));
        }

        if(num >= 1000000000){
            int extra = num/1000000000;
            sb.append(convert(extra) + " Billion");
            num = num%1000000000;
        }

        if(num >= 1000000){
            int extra = num/1000000;
            sb.append(convert(extra) + " Million");
            num = num%1000000;
        }

        if(num >= 1000){
            int extra = num/1000;
            sb.append(convert(extra) + " Thousand");
            num = num%1000;
        }

        if(num > 0){
            sb.append(convert(num));
        }

        return sb.toString().trim();

    }



    public static void main(String[] args) {
        System.out.println(new NumberToEnglishWord().convert(556));
    }

}
