package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 * Sat Aug 25 21:32:35 PDT 2018
 * @author Varma Penmetsa
 *
 * Construct Full Binary Tree from given preorder and postorder traversals
 *
 * Given two arrays that represent preorder and postorder traversals of a full binary tree, construct the binary tree.
 *
 * A Full Binary Tree is a binary tree where every node has either 0 or 2 children
 *
 * Following are examples of Full Trees.
 *
 *         1
 *       /   \
 *     2       3
 *   /  \     /  \
 *  4    5   6    7
 *
 *
 *        1
 *      /   \
 *    2      3
 *         /   \
 *        4     5
 *            /   \
 *           6    7
 *
 *
 *           1
 *         /   \
 *       2       3
 *     /  \     /  \
 *    4    5   6    7
 *  /  \
 * 8    9
 *
 * It is not possible to construct a general Binary Tree from preorder and postorder traversals. But if know that the Binary Tree is Full,
 * we can construct the tree without ambiguity. Let us understand this with the help of following example.
 *
 * Let us consider the two given arrays as pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7} and post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
 * In pre[], the leftmost element is root of tree. Since the tree is full and array size is more than 1. The value next to 1 in pre[],
 * must be left child of root. So we know 1 is root and 2 is left child. How to find the all nodes in left subtree? We know 2 is root of all nodes in left subtree. All nodes before 2 in post[] must be in left subtree. Now we know 1 is root, elements {8, 9, 4, 5, 2} are in left subtree, and the elements {6, 7, 3} are in right subtree.
 *
 *
 *                   1
 *                 /   \
 *                /      \
 *      {8, 9, 4, 5, 2}     {6, 7, 3}
 *
 * We recursively follow the above approach and get the following tree.
 *
 *           1
 *         /   \
 *       2       3
 *     /  \     /  \
 *    4    5   6    7
 *   / \
 *  8   9
 *
 * https://www.geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/ConstructFullTreeFromPreOrderPostOrder.java
 */
public class ConstructTreeGivenPreorderPostorder {

    private TreeNode constructTree(int[] preOrder, int[] postOrder, int start, int end, int index) {

        if (start > end) {
            return new TreeNode(preOrder[index]);
        }

        TreeNode node = new TreeNode(preOrder[index]);
        int i = 0;
        for (i = start; i <= end; i++) {
            if (preOrder[index + 1] == postOrder[i]) {
                break;
            }
        }
        node.left = constructTree(preOrder, postOrder, start, i - 1, index + 1);
        node.right = constructTree(preOrder, postOrder, i + 1, end - 1, index + i - start + 2);
        return node;
    }

    //Print inOrder traversal give root
    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);

    }

    public static void main(String[] args) {
        ConstructTreeGivenPreorderPostorder tree = new ConstructTreeGivenPreorderPostorder();
        int pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
        TreeNode node = tree.constructTree(pre, post, 0, pre.length - 2, 0);
        tree.inOrderTraversal(node);
    }

}
