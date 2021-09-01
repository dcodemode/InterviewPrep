package learn.ds.tree;

import learn.ds.nodes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Varma
 *
 *Print level order traversal line by line
 *
 * Example:
 *               1
 *            /    \
 *           2      3
 *         /   \     \
 *       4     5      6
 *           /  \    /
 *          7    8  9
 * Output for above tree should be
 *   1
 *   2 3
 *   4 5 6
 *   7 8 9
 *
 * https://www.geeksforgeeks.org/print-level-order-traversal-line-line/
 */
public class LevelOrderLineByLine {

    /*
     * Using one Queue
     * Time  : O(n^2)
     * Space : O(h)
     */
    public static void levelOrder(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int nodeCount = q.size();
            while (nodeCount > 0) {
                TreeNode node = q.poll();
                System.out.print(node.val + " ");

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
            System.out.println();
        }
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

        levelOrder(root);

    }
}
