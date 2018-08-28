package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 *
 * 8/28/18
 * @author varpen01
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2       0       8
 *          /  \
 *          7   4
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of of nodes 5 and 1 is 3.
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
 *              according to the LCA definition.
 *
 */
public class LowestCommonAncestorBinaryTree {

    public static TreeNode LCA(TreeNode root, TreeNode n1, TreeNode n2){
        if(root == null){
            return null;
        }

        if(root == n1 || root == n2){
            return root;
        }
        TreeNode left = LCA(root.left,n1,n2);
        TreeNode right = LCA(root.right,n1,n2);
        if(left != null && right !=null){
            return root;
        }
        return (left != null ? left : right);
    }
}
