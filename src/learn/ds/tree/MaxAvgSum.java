package learn.ds.tree;

import learn.ds.nodes.TreeNode;
import learn.util.TreeUtil;

/**
 * Given the root of a binary tree, return the maximum average value of a subtree of that tree. Answers within 10-5 of the actual answer will be accepted.
 *
 * A subtree of a tree is any node of that tree plus all its descendants.
 *
 * The average value of a tree is the sum of its values, divided by the number of nodes.
 *
 *
 *
 * Example 1:
 *                   5
 *                 /   \
 *                6     1
 *
 * Input: root = [5,6,1]
 * Output: 6.00000
 * Explanation:
 * For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
 * For the node with value = 6 we have an average of 6 / 1 = 6.
 * For the node with value = 1 we have an average of 1 / 1 = 1.
 * So the answer is 6 which is the maximum.
 * Example 2:
 *
 * Input: root = [0,null,1]
 * Output: 1.00000
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 105
 *
 * https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3959/
 */

public class MaxAvgSum {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param root
     * @return
     */
    public double maximumAverageSubtree(TreeNode root) {
        return helper(root)[2];
    }

    private double[] helper(TreeNode root){
        //1st count, 2nd sum, 3rd avg
        if(root == null){
            return new double[]{0,0,0};
        }
        double[] l = helper(root.left);
        double[] r = helper(root.right);

        double count = 1 + l[0] + r[0];
        double sum = root.val + l[1] + r[1];
        double max_child = Math.max(l[2], r[2]);

        return new double[]{count, sum , Math.max(max_child, sum/count)};

    }


    public static void main(String[] args) {

        String tree = "2,null,1,null,null";
        TreeNode root = TreeUtil.buildTree(tree);

        MaxAvgSum maxSum = new MaxAvgSum();

        System.out.println(maxSum.maximumAverageSubtree(root));
    }
}
