package learn.ds.tree;

import learn.ds.nodes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/reverse-level-order-traversal/
 */
public class ReverseLevelOrder {

    public static void reverse(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode current  =  q.poll();
            if(current.right != null){
                q.offer(current.right);
            }
            if(current.left != null){
                q.offer(current.left);
            }
            s.push(current);
        }

        while(!s.isEmpty()){
            System.out.print(s.pop().data + " ");
        }

        System.out.println();

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        reverse(root);
    }
}
