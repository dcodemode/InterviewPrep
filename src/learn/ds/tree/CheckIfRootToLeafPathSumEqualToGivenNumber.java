package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 * 8/28/18
 * @author varpen01
 *
 * Root to leaf path sum equal to a given number
 *
 * Given a binary tree and a number, return true if the tree has a root-to-leaf path such that adding up all
 * the values along the path equals the given number. Return false if no such path can be found.
 *
 *                10
 *             /     \
 *           8        2
 *         /   \     /
 *       3      5   2
 *
 *
 * For example, in the above tree root to leaf paths exist with following sums.
 *
 * 21 –> 10 – 8 – 3
 * 23 –> 10 – 8 – 5
 * 14 –> 10 – 2 – 2
 * https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
 */
public class CheckIfRootToLeafPathSumEqualToGivenNumber {

    public static boolean checkIfPathExists(TreeNode node, int sum){
        if(node == null){
            return false;
        }
        //Leaf check
        if(node.left == null && node.right == null){
            if(node.data == sum){
                return true;
            }
        }
        sum = sum - node.data;
        return checkIfPathExists(node.left,sum) || checkIfPathExists(node.right,sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);

        System.out.println(checkIfPathExists(root,14));
    }

}
