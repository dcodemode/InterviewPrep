package learn.ds.tree;


import learn.ds.nodes.TreeNode;
import learn.util.TreeUtil;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Example 1:
 *                      3
 *                    /   \
 *                  9      20
 *                        /  \
 *                       15   7
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 * Example 2:
 *
 *                       1
 *                      / \
 *                    2    2
 *                   / \
 *                  3   3
 *                 / \
 *                4   4
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 * Example 3:
 *
 * Input: root = []
 * Output: true
 *
 * Constraints:
 *
 *    The number of nodes in the tree is in the range [0, 5000].
 *    -104 <= Node.val <= 104
 *
 *
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class CheckTreeBalanceBinaryTree {

    public boolean isBalanced(TreeNode root){

        if(root == null){
            return true;
        }

        if (Math.abs(height(root.left) - height(root.right)) > 1){
            return false;
        }else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }


    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + height(root.left) + height(root.right);
    }

    public static void main(String[] args) {
        CheckTreeBalanceBinaryTree cb = new CheckTreeBalanceBinaryTree();
        TreeNode root =TreeUtil.buildTree("3,9,null,null,20,15,null,null,7,null,null");

        System.out.println(cb.isBalanced(root));
    }

}
