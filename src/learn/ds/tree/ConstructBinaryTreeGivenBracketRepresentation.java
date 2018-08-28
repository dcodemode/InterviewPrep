package learn.ds.tree;

import java.util.Stack;

/**
 * Sun Aug 26 14:24:31 PDT 2018
 * @author Varma Penmetsa
 *
 * Construct a binary tree from a string consisting of parenthesis and integers. The whole input represents a binary tree. It contains
 * an integer followed by zero, one or two pairs of parenthesis. The integer represents the root’s value and a pair of parenthesis
 * contains a child binary tree with the same structure. Always start to construct the left child node of the parent first if it exists.
 *
 * Examples:
 *
 * Input : "1(2)(3)"
 * Output : 1 2 3
 * Explanation :
 *            1
 *           / \
 *          2   3
 * Explanation:
 * first pair of parenthesis contains left subtree and second one contains the right subtree. Preorder of above tree is "1 2 3".
 *
 * Input : "4(2(3)(1))(6(5))"
 * Output : 4 2 3 1 6 5
 * Explanation :
 *            4
 *          /   \
 *         2     6
 *        / \   /
 *       3   1 5
 *
 * https://www.geeksforgeeks.org/construct-binary-tree-string-bracket-representation/
 */
public class ConstructBinaryTreeGivenBracketRepresentation {

//To - Do

    class Node{
        Node left, right;
        int data;

        public Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    public Node buildTree(char[] array, int start, int end){
        if(start > end){
            return null;
        }
        Node node  = new Node(array[start] - '0');
        int index = findIndex(array, start, end);
        node.left = buildTree(array,start+2, index-1);
        node.right = buildTree(array, index+2, end-1);
        return node;
    }

    public int findIndex(char[] array, int start, int end){
        if(start > end){
            return -1;
        }
        Stack<Character> s = new Stack<>();
        int i;
        for(i = start ; i < end ; i++){
            if(array[i] =='('){
                s.push(')');
            }else if(array[i] ==')'){
                s.pop();
                if(s.isEmpty()){
                    return i;
                }
            }
        }
        return -1;
    }

    //Print inOrder traversal give root
    public static void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);

    }

    public static void main(String[] args) {
        ConstructBinaryTreeGivenBracketRepresentation t = new ConstructBinaryTreeGivenBracketRepresentation();
        String st = "4(2(3)(1))(6(5))";
        Node node = t.buildTree(st.toCharArray(),0, st.length()-1);
        inOrderTraversal(node);
//        String s = "4(2(3)(1))(6(5))";
//        System.out.println(findIndex(s.toCharArray(),0, s.length()));

    }
}
