package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 * 8/31/18
 * @author varpen01
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *
 * Input:
 *     2
 *    / \
 *   1   3
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 *              is 5 but its right child's value is 4.
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/IsBST.java
 */
public class ValidateBinarySearchTree {

    /**
     * Algorithm:
     * Keep min, max for every recursion. Initial min and max is very small and very larger number. Check if root.data is in this range.
     * When you go left pass min and root.data and for right pass root.data and max.
     *
     * Time Complexity : O(n)
     */
    public static boolean checkBST(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val > max){
            return false;
        }

        return checkBST(root.left,min, root.val) && checkBST(root.right,root.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(checkBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE));

    }
}
