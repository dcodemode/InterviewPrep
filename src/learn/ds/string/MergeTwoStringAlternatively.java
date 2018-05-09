package learn.ds.string;

/**
 * Merge two strings alternatively
 *
 * Example:
 *
 * Given "abc", "pqrstu", you method should return "apbqcrstu"
 */

public class MergeTwoStringAlternatively {

    public static String mergeAlt(String str1, String str2){
        if(str1 == null && str2 == null){
            return str1;
        }else if(str1 == null && str2 !=null){
            return str2;
        }else if(str1 != null && str2 == null){
            return str1;
        }

        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        int len = c1.length + c2.length;

        char[] ret = new char[len];

        int j =0, k = 0;

        for (int i = 0; i < len; ) {
            if (j < c1.length && k < c2.length) {
                ret[i++] = c1[j++];
                ret[i++] = c2[k++];
            } else if (j >= c1.length && k < c2.length) {
                ret[i++] = c2[k++];
            } else if (j < c1.length && k >= c2.length) {
                ret[i++] = c1[j++];
            } else {
                i++;
            }
        }
        return  String.valueOf(ret);
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "pqrstu";
        System.out.println(mergeAlt(str1,str2));
    }
}
