package learn.ds.tree;


import learn.ds.nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Unique Binary Search Trees II
 *
 * Given an integer n, return all the structurally unique BST's (binary search trees),
 * which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 *
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
 * Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 *
 *
 * https://www.youtube.com/watch?v=GgP75HAvrlY
 * https://leetcode.com/problems/unique-binary-search-trees-ii
 * https://leetcode.com/problems/unique-binary-search-trees-ii/solution/
 */
public class UniqueBinarySubtreesII {

    public List<TreeNode> generateTrees(int n){
        return  helper(1, n);
    }


    private List<TreeNode> helper(int start, int end){
        List<TreeNode> all_trees = new ArrayList<>();
        if(start > end){
            all_trees.add(null);
            return all_trees;
        }

        for(int i = start ; i < end ; i++ ){
            List<TreeNode> left_tree = helper(start, i-1);
            List<TreeNode> right_tree = helper(i+1, end);

            for(TreeNode l : left_tree){
                for (TreeNode r : right_tree){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    all_trees.add(root);
                }
            }
        }
        return all_trees;
    }

    public static void main(String[] args) {
        UniqueBinarySubtreesII ubt = new UniqueBinarySubtreesII();
        List<TreeNode> list = ubt.generateTrees(3);
        System.out.println(list);

    }
}
