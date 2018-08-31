package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 * 8/28/18
 * @author varpen01
 *
 * Find the distance between two keys in a binary tree, no parent pointers are given. Distance between two nodes
 * is the minimum number of edges to be traversed to reach one node from other.
 *
 *            1
 *          /   \
 *        2      3
 *       / |    / \
 *     4   5   6   7
 *              \
 *               8
 * Examples:
 *   Dist(4,5) = 2
 *   Dist(4,6) = 4
 *   Dist(3,4) = 3
 *   Dist(2,4) = 1
 *   Dist(8,5) = 5
 *
 * https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
 */
public class DistanceBetweenTwoNodeInBinaryTree {

    //Find LCA if give nodes
    public static TreeNode LCA(TreeNode node, TreeNode n1, TreeNode n2) {
        if (node == null) {
            return null;
        }
        if (node == n1 || node == n2) {
            return node;
        }
        TreeNode left = LCA(node.left, n1, n2);
        TreeNode right = LCA(node.right, n1, n2);

        if (left != null && right != null) {
            return node;
        }
        return (left != null) ? left : right;
    }

    //Distance from root to node
    public static int getDepth(TreeNode node, TreeNode n1, int index){
        if(node == null ){
            return -1;
        }
        if(node == n1){
            return index;
        }
        int d = getDepth(node.left, n1, index + 1);
        if (d == -1) {
            return getDepth(node.right, n1, index + 1);
        }
        return d;
    }

    /**
     * Algorithm
     *   We first find LCA of two nodes. Then we find distance from LCA to two nodes.
     *
     * Time Complexity: O(n)
     *
     */
    public static int distanceBetweenNodes(TreeNode node, TreeNode n1, TreeNode n2){
        if(node == null){
            return 0;
        }
        //Find LCA
        TreeNode lca = LCA(node,n1,n2);

        //Find distance from lca to n1
        int l1 = getDepth(lca,n1,0);

        //Find distance from lca to n2
        int l2 = getDepth(lca, n2, 0);

        return l1+l2;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        System.out.println("Dist(4,5) = \""+distanceBetweenNodes(root, root.left.left, root.left.right) + "\"");
        System.out.println("Dist(2,4) = \""+distanceBetweenNodes(root, root.left,root.left.left ) + "\"");
        System.out.println("Dist(4,8) = \""+distanceBetweenNodes(root, root.left.left,root.right.left.right ) + "\"");
    }



}
