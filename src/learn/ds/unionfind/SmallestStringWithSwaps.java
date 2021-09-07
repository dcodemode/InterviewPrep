package learn.ds.unionfind;

import java.util.*;

/**
 *  1202. Smallest String With Swaps
 *
 *  You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 *
 * You can swap the characters at any pair of indices in the given pairs any number of times.
 *
 * Return lexicographically smallest string that s can be changed to after using the swaps.
 *
 * Example 1:
 * Input: s = "dcab", pairs = [[0,3],[1,2]]
 * Output: "bacd"
 *
 * Explaination:
 *  Swap s[0] and s[3], s = "bcad"
 *  Swap s[1] and s[2], s = "bacd"
 *
 *
 * Example 2:
 * Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * Output: "abcd"
 *
 * Explaination:
 *  Swap s[0] and s[3], s = "bcad"
 *  Swap s[0] and s[2], s = "acbd"
 *  Swap s[1] and s[2], s = "abcd"
 *
 * Example 3:
 * Input: s = "cba", pairs = [[0,1],[1,2]]
 * Output: "abc"
 *
 * Explaination:
 *  Swap s[0] and s[1], s = "bca"
 *  Swap s[1] and s[2], s = "bac"
 *  Swap s[0] and s[1], s = "abc"
 *
 *
 * Constraints:
 *  1 <= s.length <= 10^5
 *  0 <= pairs.length <= 10^5
 *  0 <= pairs[i][0], pairs[i][1] < s.length
 *  s only contains lower case English letters.
 *
 * https://leetcode.com/problems/smallest-string-with-swaps/
 *
 */

public class SmallestStringWithSwaps {


    class UnionFind{

        private int[] root, rank;
        private int count = 0;

        public UnionFind(int m){
            root = new int[m];
            rank = new int[m];
            count = m;

            for(int i = 0 ; i < m ; i++ ){
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x){
            if(x == root[x]){
                return x;
            }
            return root[x] = find(root[x]);
        }


        public void union(int x, int y){
            int rootX =  find(x);
            int rootY = find(y);

            if(rootX != rootY){
                if(rank[rootX] > rank[rootY]){
                    root[rootY] = rootX;
                }else if(rank[rootX] < rank[rootY]){
                    root[rootX] = rootY;
                }else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;

                }
                count--;
            }
        }


        public int count(){
            return count;
        }

    }


    /**
     * Time Complexity:  O(M* alpha(N) + NlogN ), where N = s.length(), M = pairs.size(), alpha(N)~=O(1)
     * Space Complexity: O(N)
     *
     * @param s
     * @param pairs
     * @return
     */
    public String smallestStringWithSwaps(String s,  int[][] pairs) {
        int m = s.length();

        UnionFind uf = new UnionFind(m);

        for(int[] pair : pairs){
            uf.union(pair[0], pair[1]);
        }

        // Make groups of connected nodes
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < m ; i++){
            int root = uf.find(i);
            List<Integer> grouped = map.getOrDefault(root, new ArrayList<>());
            if (grouped.isEmpty()) {
                map.put(root, grouped);
            }
            grouped.add(i);
        }

        // Create char array of connected node and then sort they to form smallest lexicographically string.
        char[] res = new char[m];
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            int key = entry.getKey();
            List<Integer> values = entry.getValue();

            //Sorting groped arrays
            char[] temp = new char[values.size()];
            int i = 0;
            for(int index : values){
                temp[i++] = s.charAt(index);
            }
            Arrays.sort(temp);

            //Setting sorted arrays in result
            i = 0;
            for(int index : values){
                res[index] = temp[i++];
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        SmallestStringWithSwaps s = new SmallestStringWithSwaps();
        int[][] paris = {{0,3},{1,2},{0,2}};
        System.out.println(s.smallestStringWithSwaps("dcab", paris));
    }

}
