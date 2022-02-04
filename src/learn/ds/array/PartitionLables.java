package learn.ds.array;

import java.util.ArrayList;
import java.util.List;

/**
    You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
    Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

    Return a list of integers representing the size of these parts.

    Example 1:
    Input: s = "ababcbacadefegdehijhklij"
    Output: [9,7,8]
    Explanation:
    The partition is "ababcbaca", "defegde", "hijhklij".
    This is a partition so that each letter appears in at most one part.
    A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
    
    Example 2:
    Input: s = "eccbbbbdec"
    Output: [10]
    
    Constraints:
    1 <= s.length <= 500
    s consists of lowercase English letters.

    https://leetcode.com/problems/partition-labels/
 */
public class PartitionLables {

    /**
     * We need an array last[char] -> index of S where char occurs last. Then, let anchor and j be the start and end of the current partition.
     * If we are at a label that occurs last at some index after j, we'll extend the partition j = last[c]. If we are at the end of the partition (i == j) 
     * then we'll append a partition size to our answer, and set the start of our new partition to i+1.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1) since lastIndex only contains 26 chars
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitionLengths = new ArrayList<>();
        
        int[] lastIndex = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            lastIndex[s.charAt(i) - 'a'] = i; 
        }
        
        int i = 0;
        
        while(i < s.length()){
            int end = lastIndex[s.charAt(i) - 'a'];
            int j = i;
            while(j != end){
                end = Math.max(end, lastIndex[s.charAt(j) - 'a']);
                j++;
            }
            partitionLengths.add(j - i + 1);
            i = j + 1;
        }
        return partitionLengths;
    }
}
