package learn.ds.nodes;


public class TreeNode {

    /*
      Basic Tree Node
     */
    public TreeNode left, right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}
