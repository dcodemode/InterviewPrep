package learn.ds.tree;

import learn.ds.nodes.ListNode;
import learn.ds.nodes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Sun Aug 26 10:03:16 PDT 2018
 * @author Varma Penmetsa
 *
 * Given Linked List Representation of Complete Binary Tree, construct the Binary tree.
 * A complete binary tree can be represented in an array in the following approach.
 *
 * https://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/
 */
public class ConstructCompleteBinaryTreeFromLinkedList {

    /**
     * Algorithm:
     * 1. Create an empty queue.
     * 2. Make the first node of the list as root, and enqueue it to the queue.
     * 3. Until we reach the end of the list, do the following.
     *          a. Dequeue one node from the queue. This is the current parent.
     *          b. Add left node and right node to the queue
     *          c. add these nodes to left and right of parent node.
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     */

    public static TreeNode buildTreeFromLL(ListNode head) {
        Queue<TreeNode> q = new LinkedList<>();

        if (head == null) {
            return null;
        }

        TreeNode node = new TreeNode(head.data);
        q.add(node);

        head = head.next;

        while (head != null) {
            TreeNode parent = q.poll();

            TreeNode leftChild = null, rightChild = null;
            //Build Left child
            leftChild = new TreeNode(head.data);
            q.add(leftChild);
            head = head.next;

            //Build right child
            if (head != null) {
                rightChild = new TreeNode(head.data);
                q.add(rightChild);
                head = head.next;
            }
            parent.left = leftChild;
            parent.right = rightChild;

        }
        return node;
    }

    //Print inOrder traversal give root
    public static void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);

    }

    public static void main(String[] args) {

        learn.util.LinkedList ll = new learn.util.LinkedList();
        ll.push(36);
        ll.push(30);
        ll.push(25);
        ll.push(15);
        ll.push(12);
        ll.push(10);

        TreeNode node = buildTreeFromLL(ll.head);
        inOrderTraversal(node);

    }


}
