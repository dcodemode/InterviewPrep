package learn.ds.nodes;


public class TreeNode {

    /*
      Basic Tree Node
     */
    public TreeNode left, right;
    public int data;

    public TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}
