package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 * 8/31/18
 * @author varpen01
 *
 * Given a binary search tree and a key, return node which has data as this key or return null if no node has data as key.
 *
 *                 20
 *                /  \
 *              8     22
 *            /  \
 *          4     12
 *               /  \
 *             10   14
 * Example:
 *    If "4" is given return node 4;
 *    if "11" is given return "null"
 *
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/BSTSearch.java
 */
public class CheckIfNodeExistsBST {

    //Time Complexity : O(log n)
    public static TreeNode searchBST(TreeNode root, int n1) {
        if (root == null) {
            return null;
        }
        if (root.data == n1) {
            return root;
        } else if (root.data > n1) {
            return searchBST(root.left, n1);
        } else {
            return searchBST(root.right, n1);
        }
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        System.out.println(searchBST(root,12));
        System.out.println(searchBST(root,11));
    }
}
