package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 * 8/28/2018
 * @author varpen01
 *
 * Check if there is a root to leaf path with given sequence
 *
 * Given a binary tree and an array, the task is to find if the given array sequence is present as a root to
 * leaf path in given tree
 *
 *               5
 *             /   \
 *           2      3
 *         /   \
 *       1      4
 *            /  \
 *          6     8
 *
 * Example:
 * Input : arr[] = {2, 4, 8} for above tree
 * Output: "Path does not Exist"
 *
 * Input :  arr[] = {5, 2, 4, 9} & above tree
 * Output: "Path Exist"
 *
 * https://www.geeksforgeeks.org/check-root-leaf-path-given-sequence/
 */
public class CheckIfRootToLeafPathWithGivenSequence {

    // Space complexity: O(n)
    public static boolean checkGivenSeq(TreeNode node, int[] array, int index){
        if(node == null){
            return true;
        }
        //Check if data is not matching || if index is greater than array
        if(index > array.length-1 || array[index] != node.data)
            return false;

        return checkGivenSeq(node.left, array,index+1) || checkGivenSeq(node.right, array,index+1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(8);

        int arr[] = {5, 2, 4, 8};
        System.out.println(checkGivenSeq(root,arr, 0));
    }
}
