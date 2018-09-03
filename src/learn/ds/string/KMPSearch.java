package learn.ds.string;

/**
 * 9/3/18
 * @author Varma Penmetsa
 *
 * Pattern Search Using KMP
 *
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/string/SubstringSearch.java
 * https://www.youtube.com/watch?annotation_id=annotation_109280825&feature=iv&src_vid=KG44VoDtsAA&v=GTJr8OvyEVQ
 */
public class KMPSearch {

    /**
     * Calculate temporary array
     * Time/space complexity is O(size of pattern)
     */
    public static int[] computeTemporaryArray(char[] pattern){
        int[] lps = new int[pattern.length];
        int index = 0;
        for(int i = 1; i < lps.length; ){
            if(pattern[index] == pattern[i]){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = lps[index-1];
                }else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     *  Time complexity  : O(m + n) where m is length of text and n is length of pattern
     *  Space complexity : O(n)
     */
    public static boolean kmpSearch(char[] text, char[] pattern) {
        if (text == null) {
            return false;
        }
        int lps[] = computeTemporaryArray(pattern);
        int i = 0, j = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        if (j == pattern.length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        System.out.println(kmpSearch(str.toCharArray(),subString.toCharArray()));
    }

}
