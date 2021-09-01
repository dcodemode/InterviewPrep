package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 * Mon Aug 27 19:14:51 PDT 2018
 * @author Varma Penmetsa
 *
 * Check if a binary tree is subtree of another binary tree
 *
 * Given two binary trees, check if the first tree is subtree of the second one. A subtree of a tree T is a tree S consisting of a
 * node in T and all of its descendants in T.
 *
 * The subtree corresponding to the root node is the entire tree; the subtree corresponding to any other node is called a proper subtree.
 *
 * For example, in the following case, Tree1 is a subtree of Tree2.
 *
 *
 *         Tree 2
 *           10
 *         /    \
 *       4       6
 *        \
 *         30
 *
 *
 *            Tree 1
 *               26
 *             /   \
 *           10     3
 *         /    \     \
 *       4       6      3
 *        \
 *         30
 *
 * https://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
 *
 */
public class CheckBinaryTreeIsSubtreeOfAnotherBinaryTree {

    //Check is two trees are identical
    public static boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        if (a.val != b.val)
            return false;
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }

    /**
     * Algorithm:
     *  Traverse the tree T in preorder fashion. For every visited node in the traversal, see if the subtree rooted with this node
     *  is identical to S.
     *
     * Time Complexity : O(n^2)
     *
     */
    public static boolean isSubtree(TreeNode t, TreeNode s){
        if (t == null)
            return false;
        if (isSame(s, t))
            return true;
        return isSubtree(t.left, s) || isSubtree(t.right, s);
    }

    /**
     * The above solution can also be done in O(n), using this approach
     *
     * 1) Find inorder and preorder traversals of T, store them in two auxiliary arrays inT[] and preT[].
     *
     * 2) Find inorder and preorder traversals of S, store them in two auxiliary arrays inS[] and preS[].
     *
     * 3) If inS[] is a subarray of inT[] and preS[] is a subarray preT[], then S is a subtree of T. Else not.
     */

}
