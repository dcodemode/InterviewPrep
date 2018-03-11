package learn.ds.linkedlist;

/**
 * @author Varma Penmetsa
 *
 * Given a linked list where every node represents a linked list and contains two pointers of its type:
 *   (i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
 *   (ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).
 * All linked lists are sorted. See the following example
 *
 *   Input:
 *             5 -> 10 -> 19 -> 28
 *             |    |     |     |
 *             V    V     V     V
 *             7    20    22    35
 *             |          |     |
 *             V          V     V
 *             8          50    40
 *             |                |
 *             V                V
 *             30               45
 *
 * Write a function flatten() to flatten the lists into a single linked list. The flattened linked list should also be sorted.
 * For example, for the above input list.
 *
 *   Output:
 *             5->7->8->10->19->20->22->28->30->35->40->45->50.
 *
 * https://www.geeksforgeeks.org/flattening-a-linked-list/
 *
 */

public class FlattenLinkedList {

    Node head;

    public class Node {

        public Node right, down;
        public int data;

        public Node(int data) {
            this.data = data;
            right = null;
            down = null;
        }
    }

    public Node push(Node head_ref, int data) {
        Node new_node = new Node(data);
        new_node.down = head_ref;
        head_ref = new_node;
        return head_ref;
    }

    //Using merge sort technique
    public Node flatten(Node root){
         if(root==null || root.right==null){
             return root;
         }
        root.right = flatten(root.right);
        root = merge(root,root.right);
        return root;
    }

    public Node merge(Node a, Node b){
        Node ret = null;

        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        if (a.data < b.data) {
            ret = a;
            ret.down = merge(a.down, b);
        } else {
            ret = b;
            ret.down = merge(a, b.down);
        }
        return ret;
    }

    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " --> ");
            temp = temp.down;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        FlattenLinkedList L = new FlattenLinkedList();

        /* Let us create the following linked list
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
        */

        L.head = L.push(L.head, 30);
        L.head = L.push(L.head, 8);
        L.head = L.push(L.head, 7);
        L.head = L.push(L.head, 5);

        L.head.right = L.push(L.head.right, 20);
        L.head.right = L.push(L.head.right, 10);

        L.head.right.right = L.push(L.head.right.right, 50);
        L.head.right.right = L.push(L.head.right.right, 22);
        L.head.right.right = L.push(L.head.right.right, 19);

        L.head.right.right.right = L.push(L.head.right.right.right, 45);
        L.head.right.right.right = L.push(L.head.right.right.right, 40);
        L.head.right.right.right = L.push(L.head.right.right.right, 35);
        L.head.right.right.right = L.push(L.head.right.right.right, 28);

        L.flatten(L.head);
        L.printList();

    }
}
