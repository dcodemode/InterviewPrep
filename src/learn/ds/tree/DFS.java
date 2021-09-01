package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 * @author Varma
 *
 * Deepth First Traversals
 *
 * 1. In-order   (Left, Root, Right)
 * 2. Pre-order  (Root, Left, Right)
 * 3. Post-order (Left, Right, Root)
 *
 * Example:
 *
 * Tree:
 *               1
 *            2     3
 *         4     5
 *
 *  In-order   : 4, 2, 5, 1, 3
 *  Pre-order  : 1, 2, 4, 5, 3
 *  Post-order : 4, 5, 2, 3, 1
 *
 */
public class DFS {

    /**
     * Time Complexity  : O(n)
     * Space Complexity : O(h) , h is the height of binary tree
     */
    public static void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    /**
     * Time Complexity  : O(n)
     * Space Complexity : O(h) , h is the height of binary tree
     */
    public static void preOrder(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * Time Complexity  : O(n)
     * Space Complexity : O(h) , h is the height of binary tree
     */
    public static void postOrder(TreeNode node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Depth First Search Tree Traversal : ");
        System.out.println("In-order traversal");
        inOrder(root);
        System.out.println();
        System.out.println("Pre-order traversal");
        preOrder(root);
        System.out.println();
        System.out.println("Post-order traversal");
        postOrder(root);
    }
}
