package learn.ds.tree;


/**
 * Unique Binary Search Trees
 *
 * Given an integer n, return the number of structurally unique BST's (binary search trees) 
 * which has exactly n nodes of unique values from 1 to n.
 *
 *
 * Example 1:
 *   1        1                2                3             3
 *    \         \            /   \             /             /
 *     3         2          1     3           2             1
 *    /           \                          /               \
 *   2              3                       1                 2
 *
 * Input: n = 3
 * Output: 5
 * 
 * Example 2:
 * 
 * Input: n = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 *
 *
 * https://www.youtube.com/watch?v=GgP75HAvrlY
 * https://leetcode.com/problems/unique-binary-search-trees
 * https://leetcode.com/problems/unique-binary-search-trees/solution/
 */
public class UniqueBinaryTree {

    public int numTrees(int n){
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
              G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
    
}
