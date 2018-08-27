package learn.ds.tree;

import learn.ds.nodes.TreeNode;

import java.util.Stack;

/**
 * 8/27/2018
 * @author varpen01
 *
 * Check for Children Sum Property in a Binary Tree
 * Given a binary tree, write a function that returns true if the tree satisfies below property.
 *
 * For every node, data value must be equal to sum of data values in left and right children. Consider data value as 0 for NULL children.
 * Below tree is an example
 *                   10
 *                  /  \
 *                8     2
 *               / |   /
 *             3   5  2
 */
public class CheckFromChildSumProperty {

    /**
     * Algorithm:
     * Using level order traversal, go to each and every node check sum of both left and right children.
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     *
     */
    public static boolean checkSum(TreeNode node){
        Stack<TreeNode> s = new Stack<>();
        s.push(node);

        while(!s.isEmpty()){
            TreeNode temp = s.pop();
            int sum = temp.data;
            int lSum = 0, rSum = 0;

            if(temp.right!=null){
                s.push(temp.right);
                rSum = temp.right.data;
            }

            if(temp.left!=null){
                s.push(temp.left);
                lSum = temp.left.data;
            }
            //Check if leaf, ignore them.
            if(lSum==0 && rSum==0){
                continue;
            }
            //Check sum
            if (sum != lSum + rSum) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(2);
        System.out.println(checkSum(root));
    }

}
