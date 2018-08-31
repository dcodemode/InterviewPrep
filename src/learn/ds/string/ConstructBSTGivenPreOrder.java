package learn.ds.string;

import learn.ds.nodes.TreeNode;

/**
 * 8/30/18
 * @author varpen01
 *
 * Given preorder traversal of a binary search tree, construct the BST.
 *
 * For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be root of following tree.
 *
 *        10
 *      /   \
 *    5     40
 *   /  \      \
 *  1    7      50
 *
 * https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
 */

public class ConstructBSTGivenPreOrder {



    /**
     * Algorithm:
     *
     * In {10, 5, 1, 7, 40, 50}, 10 is the first element, so we make it root. Now we look for the first element greater than 10, we find 40.
     * So we know the structure of BST is as following.
     *
     *              10
     *            /    \
     *           /      \
     *   {5, 1, 7}       {40, 50}
     *
     * Time Complexity: O(n^2)
     */

    int index = 0;

    public TreeNode constructTree(int[] array, int start, int end){
        if(start > end){
            return null;
        }

        TreeNode node = new TreeNode(array[index]);

        //Find left sub-tree and right sub-tree
        int i =0;
        for(i = start+1 ; i < end ; i++ ){
            if(array[index] < array[i]){
                break;
            }
        }
        index +=1;
        node.left = constructTree(array,start+1, i -1);
        node.right = constructTree(array, i, end);

        return node;
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
        int[] preOrder = {10, 5, 1, 7, 40, 50};

        ConstructBSTGivenPreOrder bst = new ConstructBSTGivenPreOrder();
        TreeNode root = bst.constructTree(preOrder,0,preOrder.length-1);
        inOrderTraversal(root);

    }

}
