package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 * Sun Aug 26 14:01:26 PDT 2018
 * @author Varma Penmetsa
 *
 *
 * Construct Special Binary Tree from given Inorder traversal
 * Given Inorder Traversal of a Special Binary Tree in which key of every node is greater than keys in left and right children, construct the Binary Tree and return root.
 *
 * Examples:
 *
 * Input: inorder[] = {5, 10, 40, 30, 28}
 * Output: root of following tree
 *          40
 *        /   \
 *       10     30
 *      /         \
 *     5          28
 *
 * Input: inorder[] = {1, 5, 10, 40, 30,
 *                     15, 28, 20}
 * Output: root of following tree
 *           40
 *         /   \
 *        10     30
 *       /         \
 *      5          28
 *     /          /  \
 *    1         15    20
 * https://www.geeksforgeeks.org/construct-binary-tree-from-inorder-traversal/
 */
public class ConstructSpecialBinaryTreeGivenInorderTraversal {

    public TreeNode buildTree(int[] inOrder, int start, int end){
        if(start > end){
            return null;
        }

        int index = findMax(inOrder, start, end);
        TreeNode node = new TreeNode(inOrder[index]);
        node.left = buildTree(inOrder,start, index-1);
        node.right = buildTree(inOrder,index+1,end);
        return node;
    }

    public int findMax(int[] array, int start, int end){
        int maxVal = array[start];
        int maxIndex = start;

        for(int i = start+1; i < end; i++){
            if(array[i] > maxVal){
                maxVal = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    //Print inOrder traversal give root
    public static void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);

    }

    public static void main(String[] args) {
        ConstructSpecialBinaryTreeGivenInorderTraversal t = new ConstructSpecialBinaryTreeGivenInorderTraversal();
        int inorder[] = new int[]{5, 10, 40, 30, 28};
        TreeNode node = t.buildTree(inorder,0,inorder.length-1);
        inOrderTraversal(node);
    }
}
