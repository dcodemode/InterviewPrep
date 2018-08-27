package learn.ds.tree;

import learn.ds.nodes.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 8/27/18
 * @author Varma Penmetsa
 *
 * Check if two nodes are cousins in a Binary Tree
 *
 * Given the binary Tree and the two nodes say ‘a’ and ‘b’, determine whether the two nodes are cousins of each other or not.
 *
 * Two nodes are cousins of each other if they are at same level and have different parents.
 *
 * Example
 *
 *      6
 *    /   \
 *   3     5
 *  / \   / \
 * 7   8 1   3
 *
 * Say two node be 7 and 1, result is TRUE.
 * Say two nodes are 3 and 5, result is FALSE.
 * Say two nodes are 7 and 5, result is FALSE.
 *
 * https://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
 */
public class CheckTwoNodeAreCousins {

    //Find if give nodes are on same level. Solution is similar to print level order line by line
    public static boolean sameLevel(TreeNode node, TreeNode a, TreeNode b){
        if(node == null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){

            int size = q.size();
            Set<TreeNode> set = new HashSet<>();

            while(size > 0){
                TreeNode current = q.poll();

                //Check if a, b are present in the same level
                set.add(current);
                if(set.contains(a) && set.contains(b))
                    return true;

                if(current.left!=null)
                    q.offer(current.left);

                if(current.right != null)
                    q.offer(current.right);

                size--;
            }
        }
        return false;
    }

    //Find level of tree recursively.
    public static int levelOfTree(TreeNode root, TreeNode node, int level){
        if(root == null){
            return 0;
        }

        if(root == node){
            return  level;
        }

        int val = levelOfTree(root.left, node, level+1);
        if(val!=0){
            return val;
        }
        return levelOfTree(root.right, node, level+1);
    }

    //Find if two nodes are siblings
    public static TreeNode getParent(TreeNode node, TreeNode a){
        if(node == null){
            return node;
        }

        if(node.left == a || node.right == a){
            return node;
        }
        TreeNode ret =getParent(node.left, a);
        if(ret!=null){
            return ret;
        }
        return getParent(node.right, a);
    }

    /**
     * Algorithm
     * 1. Find Level of both nodes
     * 2. Find parents of both nodes
     * 2. Compare both and see it that satisfies properties.
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     */

    public static boolean cousinCheck(TreeNode root, TreeNode a, TreeNode b){
        if(root == null){
            return true;
        }

        // Check level and parent of A
        int aLevel = levelOfTree(root,a,0);
        TreeNode aParent = getParent(root,a);

        //Check level & Parent of B
        int bLevel = levelOfTree(root,b,0);
        TreeNode bParent = getParent(root,b);

        return (aParent != bParent) && aLevel == bLevel;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);

//        System.out.println(sameLevel(root,root.left.left,root.right.left));
//        System.out.println(getParent(root,root.right.left).data);
        System.out.println(cousinCheck(root,root.left.left,root.left.right));
        System.out.println(cousinCheck(root,root.left.left,root.right.right));
    }

}
