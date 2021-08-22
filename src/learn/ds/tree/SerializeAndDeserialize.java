package learn.ds.tree;


import learn.ds.nodes.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Serialize and Deserialize a Binary Tree
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
 *
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree
 */

public class SerializeAndDeserialize {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param root
     * @return
     */
    public String serialize(TreeNode root){
        if(root == null){
            return "Null";
        }
        return root.data + "," + serialize(root.left) + "," + serialize(root.right);
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param data
     * @return
     */
    public TreeNode deserialize(String data){
        Deque<String> queue = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }

    public TreeNode helper(Deque<String> queue){
        String str = queue.poll();
        if(str.equals("Null") ){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}
