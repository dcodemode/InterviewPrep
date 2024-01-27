package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/*
 * 426. Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
 * 
 * You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list.
 * For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
 * 
 * We want to do the transformation in place. After the transformation, the left pointer of the tree node should point 
 * to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.
 * 
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

public class ConvertBinarySearchTreeToDoubelyLinkedList {


    private TreeNode head;
    private TreeNode tail;
    
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return root;

        head = tail = null;
        helper(root);

        tail.right = head;
        head.left = tail;

        return head;
    }

    private void helper(TreeNode node) {
        if (node == null) return;
        helper(node.left);
        if(tail != null){
            tail.right = node;
            node.left = tail;
        }else{
            head = node;
        }
        tail = node;
        helper(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        DFS.inOrder(root);

        ConvertBinarySearchTreeToDoubelyLinkedList sol = new ConvertBinarySearchTreeToDoubelyLinkedList();
        sol.treeToDoublyList(root);

        DFS.inOrder(root);

    }

}
