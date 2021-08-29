package learn.util;

import learn.ds.nodes.TreeNode;

import java.util.*;

public class TreeUtil {

    //De-serialize a tree if preorder traversal is give

    public static TreeNode buildTree(String preOrder){
        Deque<String> queue = new ArrayDeque<>(Arrays.asList(preOrder.split(",")));
        return helper(queue);

    }
    public static TreeNode helper(Deque<String> queue){
        String str = queue.poll();
        if(str.equals("null") ){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }

}
