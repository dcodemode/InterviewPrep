package learn.ds.tree;

import learn.ds.nodes.TreeNode;

import java.util.Stack;

/**
 * @author Varma
 *
 * Iterative pre-order traversal
 *
 * https://www.geeksforgeeks.org/iterative-preorder-traversal/
 */
public class PreOrderIterative {

    /*
     * Time Complexity  : O(n)
     * Space Complexity : O(h)
     *
     * 1) Create an empty stack nodeStack and push root node to stack.
     * 2) Do following while nodeStack is not empty.
     *   a) Pop an item from stack and print it.
     *   b) Push right child of popped item to stack
     *   c) Push left child of popped item to stack
     */
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            System.out.print(node.data + " ");

            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
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

        preOrder(root);
    }
}
