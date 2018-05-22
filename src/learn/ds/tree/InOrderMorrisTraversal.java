package learn.ds.tree;


import learn.ds.nodes.TreeNode;

/**
 * @author Varma
 *
 * Inorder Tree Traversal without recursion and without stack.
 *
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 * https://github.com/mission-peace/interview/blob/68f97392c6f6e14e2c08860684ed605a1a5e7e72/src/com/interview/tree/MorrisTraversal.java
 * https://www.youtube.com/watch?v=wGXB9OWhPTg&t=412s
 */

public class InOrderMorrisTraversal {

    /*
     * Time complexity  : O(n)
     * Space complexity : O(1)
     *
     * 1. Initialize current as root
     * 2. While current is not NULL
     * If current does not have left child
     *   a) Print current’s data
     *   b) Go to the right, i.e., current = current->right
     * Else
     *   a) Make current as right child of the rightmost node in current's left subtree
     *   b) Go to this left child, i.e., current = current->left
     */

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                TreeNode predecessor = current.left;

                while (predecessor.right != current && predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
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

        inOrder(root);
    }

}
