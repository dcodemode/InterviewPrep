package learn.ds.tree;

import learn.ds.nodes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Varma Penmetsa
 *
 * Breadth First Traversal:
 *
 * Example:
 *
 *                 1
 *              2     3
 *           4     5
 *
 * Level Order Traversal: 1, 2, 3, 4, 5
 *
 */
public class BFS {

    /**
     * Using Queue's
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(w) , w is width of binary tree.
     *
     */
    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Level Order Traversal");
        levelOrderTraversal(root);
    }
}
