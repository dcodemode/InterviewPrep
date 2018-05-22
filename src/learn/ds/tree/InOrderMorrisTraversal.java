package learn.ds.tree;


/**
 * @author Varma
 *
 * Inorder Tree Traversal without recursion and without stack.
 *
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 *
 */

public class InOrderMorrisTraversal {

    /*
     * 1. Initialize current as root
     * 2. While current is not NULL
     * If current does not have left child
     *   a) Print current’s data
     *   b) Go to the right, i.e., current = current->right
     * Else
     *   a) Make current as right child of the rightmost node in current's left subtree
     *   b) Go to this left child, i.e., current = current->left
     */

}
