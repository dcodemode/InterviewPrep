package learn.ds.tree;

import learn.ds.nodes.TreeNode;


/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class DeleteNodeBST {

    public int predecessor(TreeNode root){
        TreeNode node = root.left;
        while(node.right != null){
            node = node.right;
        }
        return node.data;
    }

    public int successor(TreeNode root){
        TreeNode node = root.right;
        while(node.left != null){
            node = node.left;
        }
        return node.data;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null){
            return null;
        }

        if(key > root.data){
            root.right = deleteNode(root.right, key);
        } else if(key < root.data){
            root.left = deleteNode(root.left, key);
        }else{
            if(root.left == null && root.right == null){
                root = null;
            }else if(root.right != null){
                root.data = successor(root);
                root.right = deleteNode(root.right, root.data);

            }else{
                root.data = predecessor(root);
                root.left = deleteNode(root.left, root.data);
            }
        }
        return root;
    }
}
