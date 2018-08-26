package learn.ds.tree;

/**
 * Sat Aug 25 18:55:01 PDT 2018
 * @author Varma Penmetsa
 *
 * Input:
 *
 * Inorder sequence: D B E A F C
 * Preorder sequence: A B D E C F
 *
 * Output:
 *            A
 *          /   \
 *        /       \
 *       B         C
 *      / \        /
 *    /     \    /
 *   D       E  F
 *
 * https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 */
public class ConstructTreeGivenInorderPreorder {

    public class Node{
        char value;
        Node left, right;
        public Node(char value){
            left = null;
            right = null;
            this.value = value;
        }

    }

    int index = 0;

    /**
     * Using Recursion:
     *
     * In a Pre-order sequence, leftmost element is the root of the tree. So we know ‘A’ is root for given sequences.
     * By searching ‘A’ in In-order sequence, we can find out all elements on left side of ‘A’ are in left subtree and elements on
     * right are in right subtree. So we know below structure now.
     *
     *                  A
     *                /   \
     *              /       \
     *            D B E     F C
     *
     * We recursively follow above steps and get the following tree.
     *               A
     *             /   \
     *           /       \
     *          B         C
     *         / \        /
     *       /     \    /
     *      D       E  F
     *
     * Time Complexity  : O (n^2)
     * Space Complexity : O (n)
     *
     */
    public Node buildTree(char[] inOrder, char[] preOrder, int start, int end){
        if(start > end){
            return null;
        }
        //Since first element of preOrder is root, finding root in inOrder traversal
        int i;
        for(i = start ; i < end ; i++){
            if(preOrder[index] == inOrder[i]){
                break;
            }
        }
        Node node = new Node(preOrder[index]);
        index++;
        node.left = buildTree(inOrder, preOrder, start, i -1);
        node.right = buildTree(inOrder, preOrder, i+1, end);
        return node;
    }

    //Print inOrder traversal give root
    public void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);

    }

    public static void main(String[] args) {
        ConstructTreeGivenInorderPreorder tree = new ConstructTreeGivenInorderPreorder();
        char[] in = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char[] pre = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        Node ret = tree.buildTree(in,pre,0,in.length-1);
        tree.inOrderTraversal(ret);
    }

}


