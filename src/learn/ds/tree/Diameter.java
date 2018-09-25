package learn.ds.tree;

import learn.ds.nodes.TreeNode;

/**
 * @author Varma Penmetsa
 */
public class Diameter {

    int max = 0;

    public int getDiameter(TreeNode root){
        getHeight(root);
        return max;
    }

    public int getHeight(TreeNode node){

        if(node == null){
            return 0;
        }

        int left = getHeight(node.left);
        int right= getHeight(node.right);

        max = Math.max(left + right, max);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Diameter d = new Diameter();
        System.out.println(d.getDiameter(root));
    }
}
