package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 * 8/27/18
 * @author varpen01
 *
 * Given a binary tree, you need to check whether sum of all covered elements is equal to sum of all uncovered elements or not.
 *
 * In a binary tree, a node is called Uncovered if it appears either on left boundary or right boundary. Rest of the nodes are called covered.
 *
 *                       9
 *                     /  |
 *                   4     17
 *                 /  |     |
 *               3    6     22
 *                   / |    /
 *                  5   7  20
 *
 *
 * In above binary tree,
 * Covered node:     6, 5, 7
 * Uncovered node:   9, 4, 3, 17, 22, 20
 *
 * The output for this tree should be false as
 * sum of covered and uncovered node is not same
 *
 * https://www.geeksforgeeks.org/check-sum-covered-uncovered-nodes-binary-tree/
 */
public class CheckSumOfCoveredUncoveredNodesOfBinaryTree {

    //Get total sum of tree recursively
    public static int sum(TreeNode node){
        if(node == null){
            return 0;
        }
        return sum(node.left) + node.val + sum(node.right);
    }

    /**
     * Algorithm:
     * 1. Start from root, go to left and keep going until left child is available,  if not go to right child and again follow same procedure until you reach a leaf node.
     * 2. After step 1 sum of left boundary will be stored, now for right part again do the same procedure but now keep going to right until right child is available,
     * if not then go to left child and follow same procedure until you reach a leaf node.
     * 3. Check if this true : totalTreeSum - sumUncovered == sumUncovered
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     */
    public static boolean getUncoveredSum(TreeNode node){
        if(node == null){
            return true;
        }
        int leftSum = 0;
        int rightSum = 0;
        int sumUncovered = 0;

        //Find sum of left uncovered nodes
        TreeNode current = node;
        while(current!=null){
            leftSum += current.val;
            if(current.left!=null){
                current = current.left;
            }else {
                current = current.right;
            }
        }

        //Find right uncovered nodes
        current = node;
        if(current.right!=null){
            current = current.right;
        }
        while(current!=null){
            rightSum += current.val;
            if(current.right!=null){
                current = current.right;
            }else {
                current = current.left;
            }
        }
        //Total sum of uncovered nodes of tree is
        sumUncovered = leftSum + rightSum;

        //Toltal sum of covered nodes:
        int totalTreeSum = sum(node);

        return totalTreeSum - sumUncovered == sumUncovered;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(17);
        root.right.right = new TreeNode(22);
        root.right.right.left = new TreeNode(20);

        System.out.println(getUncoveredSum(root));
    }
}
