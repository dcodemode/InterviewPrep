package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 * 8/27/18
 * @author varpen01
 *
 * Check if removing an edge can divide a Binary Tree in two halves
 *
 * Given a Binary Tree, find if there exist edge whose removal creates two trees of equal size.
 *
 * Examples:
 *
 * Input : root of following tree
 *            5
 *          /   \
 *        1      6
 *       /      /  \
 *      3      7    4
 * Output : true
 * Removing edge 5-6 creates two trees of equal size
 *
 *
 * Input : root of following tree
 *            5
 *          /   \
 *        1      6
 *             /  \
 *            7    4
 *          /  \    \
 *         3    2    8
 * Output : false
 * There is no edge whose removal creates two trees
 * of equal size.
 *
 *
 * https://www.geeksforgeeks.org/check-if-removing-an-edge-can-divide-a-binary-tree-in-two-halves/
 */
public class CheckRemovingEdgeCreatesBinaryTreeInTwoHalfs {

    //Size if a binary tree
    public static int size(TreeNode node){
        if(node == null){
            return 0;
        }
        return size(node.left) + size(node.right) + 1;
    }

    /**
     * Algorithm:
     * First count number of nodes in whole tree. Let count of all nodes be n. Now traverse tree and for every node,
     * find size of subtree rooted with this node. Let the subtree size be s. If n-s is equal to s, then return true, else false.
     *
     * Time Complexity  : O(n ^ 2)
     * Space Complexity : O(n)
     */
    public static boolean checkTree(TreeNode node, int full){
        if(node == null){
            return false;
        }

        int left = size(node.left);
        int right = size(node.right);

        if((full - left == left) || (full - right == right)){
            return true;
        }

        boolean isTrue = checkTree(node.left, full);
        if(isTrue){
            return true;
        }
        return checkTree(node.right, full);

    }

    /**
     * We can find the solution in O(n) time. The idea is to traverse tree in bottom up manner and while traversing keep updating size and keep checking
     * if there is a node that follows the required property.
     */
    public static void checkTree1(TreeNode node){
      //TO-DO
    }

    public static void checkTreeRec(TreeNode node, int s, Boolean isTrue){
       //TO-DO
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(4);

        System.out.println(checkTree(root,size(root)));
    }


}
