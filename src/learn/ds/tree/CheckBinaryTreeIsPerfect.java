package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 * 8/28/18
 * @author varpen01
 *
 * Given a Binary Tree, write a function to check whether the given Binary Tree is a prefect Binary Tree or not.
 *
 * A Binary tree is Perfect Binary Tree in which all internal nodes have two children and all leaves are at same level.
 *
 * Examples:
 * The following tree is a perfect binary tree
 *
 *                10
 *            /       \
 *          20         30
 *         /  \        /  \
 *       40    50    60   70
 *
 *
 *                18
 *             /     \
 *           15       30
 * The following tree is not a perfect binary tree
 *
 *       1
 *     /    \
 *    2       3
 *     \     /  \
 *      4   5    6
 *
 */
public class CheckBinaryTreeIsPerfect {

    //Find depth if Binary tree
    public static int getDepth(TreeNode node){
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.left),getDepth(node.right))+1;
    }

    //Find number of node in a Binary tree
    public static int getNumberOfNodes(TreeNode node){
        if(node == null){
            return 0;
        }
        return getNumberOfNodes(node.left) + getNumberOfNodes(node.right) + 1;
    }

    /**
     * Algorithm:
     * 1. Find depth of binary tree
     * 2. Find number of nodes in binary tree.
     * 3. check if 2^h -1 = number of nodes in the tree
     *
     * Time Complexity: O(n)
     */
    public static boolean isTreePerfect(TreeNode node){
        if(node == null){
            return true;
        }

        int h = getDepth(node);
        //Number of nodes in perfect binary tree is equal to 2^h -1
        return getNumberOfNodes(node) == (Math.pow(2, h) - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(4);

        System.out.println(isTreePerfect(root));
    }

}
