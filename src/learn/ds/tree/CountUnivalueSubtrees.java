package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 * Given the root of a binary tree, return the number of uni-value subtrees.
 *
 * A uni-value subtree means all nodes of the subtree have the same value.
 *
 *
 *
 * Example 1:
 *  Input: root of below tree
 *               5
 *              / \
 *             1   5
 *            / \   \
 *           5   5   5
 *   Output: 4
 *
 * Example 2:
 *  Input: root of below tree
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 *
 *  Output: 5
 * Constraints:
 *
 * https://leetcode.com/problems/count-univalue-subtrees/
 */
public class CountUnivalueSubtrees {

    /**
     * Given a node in our tree, we know that it is a univalue subtree if it meets one of the following criteria:
     *
     * The node has no children (base case)
     *
     * All of the node's children are univalue subtrees, and the node and its children all have the same value
     *
     * With this in mind we can perform a depth-first-search on our tree, and test if each subtree is uni-value in a bottom-up manner.
     */
    private static int count = 0;
    public static int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return count;
    }

    public static boolean helper(TreeNode root){
        if(root == null){
            return true;
        }
        boolean left = helper(root.left);
        boolean right  = helper(root.right);

        if(left && right){
            if(root.left != null && root.val != root.left.val){
                return false;
            }

            if(root.right != null && root.val != root.right.val){
                return false;
            }
            count++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        System.out.println(countUnivalSubtrees(root));
    }
}
