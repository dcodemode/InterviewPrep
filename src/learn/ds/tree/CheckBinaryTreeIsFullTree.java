package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 * 8/28/18
 * @author varpen01
 *
 * Check whether a binary tree is a full binary tree or not
 * A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes.
 * Conversely, there is no node in a full binary tree, which has one child node.
 *
 *               1
 *            /   \
 *          2      3
 *        /  \
 *      4     5
 */
public class CheckBinaryTreeIsFullTree {

    //Time Complexity : O(n)
    public static boolean isFull(TreeNode node){
        if(node.left == null && node.right == null){
            return true;
        }else if(node.left != null && node.right != null){
            return isFull(node.left) && isFull(node.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(isFull(root));
    }
}
