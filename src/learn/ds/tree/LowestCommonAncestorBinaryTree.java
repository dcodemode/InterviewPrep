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
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 */
public class LowestCommonAncestorBinaryTree {

    /**
     * Algorithm
     * The idea is to traverse the tree starting from root. If any of the given keys (n1 and n2) matches with root, then root is LCA (assuming that both keys are
     * present). If root doesn’t match with any of the keys, we recur for left and right subtree. The node which has one key present in its left subtree and the
     * other key present in right subtree is the LCA. If both keys lie in left subtree, then left subtree has LCA also, otherwise LCA lies in right subtree
     *
     * Time Complexity : O(n)
     */
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(9);
        System.out.println(LCA(root,root.left.left,root.left.right.right).data);
    }
}
