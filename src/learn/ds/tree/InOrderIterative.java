package learn.ds.tree;

import learn.ds.nodes.TreeNode;

import java.util.Stack;

/**
 * @author Varma
 *
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 *
 */
public class InOrderIterative {


    /*   Using Stacks:
     *
     *   Time Complexity  :  O(n)
     *   Space Complexity :  O(h), where h is height of tree
     *
     *   1) Create an empty stack S.
     *   2) Initialize current node as root
     *   3) Push the current node to S and set current = current->left until current is NULL
     *   4) If current is NULL and stack is not empty then
     *     a) Pop the top item from stack.
     *     b) Print the popped item, set current = popped_item->right
     *     c) Go to step 3.
     *   5) If current is NULL and stack is empty then we are done.
     */

    public static void inOrder(TreeNode root) {

        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;

        while (node != null) {
            st.push(node);
            node = node.left;
        }

        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            System.out.print(temp.val + " ");

            if (temp.right != null) {
                temp = temp.right;
                while (temp != null) {
                    st.push(temp);
                    temp = temp.left;
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
