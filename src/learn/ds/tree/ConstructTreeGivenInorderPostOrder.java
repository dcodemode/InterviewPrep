package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 *Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Accepted
 *
 *https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructTreeGivenInorderPostOrder {
    int index;

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * For hints refer to
     * https://github.com/dvpenmetsa/InterviewPrep/blob/master/src/learn/ds/tree/ConstructTreeGivenInorderPreorder.java
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = inorder.length-1;
        return helper(inorder, postorder, 0, inorder.length-1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int start, int end){
        if(start > end){
            return null;
        }
        int i;
        for(i = start ; i < end; i++){
            if(postorder[index] == inorder[i]){
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[index--]);
        root.right = helper(inorder, postorder, i+1, end);
        root.left = helper(inorder, postorder, start, i-1);
        return root;
    }

}
