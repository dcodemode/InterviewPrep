package learn.ds.tree;

import learn.ds.nodes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Sun Aug 26 10:55:21 PDT 2018
 * @author Varma Penmetsa
 *
 * Construct a complete binary tree from given array in level order fashion
 *
 * Given an array of elements, our task is to construct a complete binary tree from this array in level order fashion. That is, elements from left in the array will be filled in the tree level wise starting from level 0.
 *
 * Examples:
 *
 * Input  :  arr[] = {1, 2, 3, 4, 5, 6}
 * Output : Root of the following tree
 *                   1
 *                  / \
 *                 2   3
 *                / \ /
 *               4  5 6
 *
 *
 * Input: arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6}
 * Output: Root of the following tree
 *                    1
 *                   / \
 *                  2   3
 *                 / \ / \
 *                4  5 6  6
 *               / \ /
 *              6  6 6
 *
 * https://www.geeksforgeeks.org/construct-complete-binary-tree-given-array/
 */
public class ConstructTreeGivenArray {

    /**
     * Iterative Method:
     *  Similar to linked list method.
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     */

    public static TreeNode buildTree(int[] array){
        Queue<TreeNode> q = new LinkedList<>();

        if(array.length == 0){
            return  null;
        }

        TreeNode node  = new TreeNode(array[0]);
        q.offer(node);
        for(int i = 1; i < array.length ; i =i+2){
            TreeNode parent = q.poll();

            TreeNode leftChild = new TreeNode(array[i]);
            q.offer(leftChild);
            parent.left = leftChild;

            if(i+1 < array.length){
                TreeNode rightChild = new TreeNode(array[i+1]);
                q.offer(rightChild);
                parent.right = rightChild;
            }
        }
        return node;
    }

    /**
     * Recursive solution
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     */
    public static TreeNode buildTree2(int[] array, int i){
        if(i >= array.length){
            return null;
        }
        TreeNode node  = new TreeNode(array[i]);
        node.left = buildTree2(array,2*i + 1);
        node.right = buildTree2(array,2*i + 2);
        return node;
    }


    //Print inOrder traversal give root
    public static void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6,9 };
        TreeNode node = buildTree2(arr,0);
        inOrderTraversal(node);

    }
}
