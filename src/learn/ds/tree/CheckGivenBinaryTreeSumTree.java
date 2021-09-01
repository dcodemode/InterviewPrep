package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 * 8/27/2018
 * @author varpen01
 *
 * Check if a given Binary Tree is SumTree Write a function that returns true if the given Binary Tree is SumTree else false.
 *
 * A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree.
 *
 * An empty tree is SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
 *
 * Following is an example of SumTree.
 *
 *           26
 *         /   \
 *       10     3
 *     /    \     \
 *   4      6      3
 *
 * https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 */
public class CheckGivenBinaryTreeSumTree {

    //Recursive function to get sum of node
    public static int sum(TreeNode node){
        if(node == null){
            return 0;
        }
        return sum(node.left) + node.val + sum(node.right);
    }

    /**
     * Algorithm:
     * Recursively find sum for sub tree and find sum for left subtree and compare it with root sum
     *
     * Time Complexity  : O(n^2) in worst case. Worst case occurs for a skewed tree.
     * Space Complexity : O(n)
     */
    public static boolean checkSumTree(TreeNode node){
        if(node == null){
            return true;
        }
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        return (node.val == leftSum + rightSum) || (leftSum == 0 && rightSum == 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(3);

        System.out.println(checkSumTree(root));
    }
}
