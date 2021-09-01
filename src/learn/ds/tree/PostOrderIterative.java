package learn.ds.tree;

import learn.ds.nodes.TreeNode;

import java.util.Stack;

/**
 * @author Varma Penmetsa
 */
public class PostOrderIterative {

    /**
     * Using two stacks
     *
     * Example:
     *
     * Tree:
     *                1
     *             2     3
     *          4     5
     *
     * Post-order : 4, 5, 2, 3, 1
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     */
    public static void postOrder1(TreeNode root){
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(root);

        while(!st1.isEmpty()){
            TreeNode node  = st1.pop();
            st2.push(node);

            if(node.left !=null){
                st1.push(node.left);
            }
            if(node.right !=null){
                st1.push(node.right);
            }
        }

        while(!st2.isEmpty()){
            System.out.print(st2.pop().val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        postOrder1(root);
    }
}
