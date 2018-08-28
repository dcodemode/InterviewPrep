package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 * 8/28/18
 * @author varpen01
 *
 * Given a binary tree, print out all of its root-to-leaf paths one per line.
 *
 *                1
 *             /    \
 *           2       3
 *         /   \
 *       4      5
 *
 * Examples:
 *   1 2 4
 *   1 2 5
 *   1 3
 *
 * https://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/
 */
public class FindAllRootToLeafPaths {

    public static void printAllRootToLeafPaths(TreeNode node){
       //To-Do
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        printAllRootToLeafPaths(root);
    }
}
