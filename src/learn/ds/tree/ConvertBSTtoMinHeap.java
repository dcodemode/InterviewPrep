package learn.ds.tree;

/**
 * Thu Aug 30 18:28:46 PDT 2018
 * @author Varma Penmetsa
 *
 *
 * Given a binary search tree which is also a complete binary tree. The problem is to convert the given BST into a Min Heap with the
 * condition that all the values in the left subtree of a node should be less than all the values in the right subtree of the node.
 * This condition is applied on all the nodes in the so converted Min Heap.
 *
 * Examples:
 *
 * Input :          4
 *                /   \
 *               2     6
 *             /  \   /  \
 *            1   3  5    7
 *
 * Output :        1
 *               /   \
 *              2     5
 *            /  \   /  \
 *           3   4  6    7
 *
 * The given BST has been transformed into a Min Heap. All the nodes in the Min Heap satisfies the given condition, that is, values in
 * the left subtree of a node should be less than the values in the right subtree of the node.
 *
 * https://www.geeksforgeeks.org/convert-bst-min-heap/
 */
public class ConvertBSTtoMinHeap {

    /**
     *
     * Algorithm:
     * 1. Create an array arr[] of size n, where n is the number of nodes in the given BST.
     * 2. Perform the inorder traversal of the BST and copy the node values in the arr[] in sorted order.
     * 3. Now perform the preorder traversal of the tree.
     * 4. While traversing the root during the preorder traversal, one by one copy the values from the array arr[] to the nodes.
     *
     *
     */


}
