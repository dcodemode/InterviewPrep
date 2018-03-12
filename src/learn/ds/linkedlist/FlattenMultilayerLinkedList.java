package learn.ds.linkedlist;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/flatten-a-linked-list-with-next-and-child-pointers/
 */
public class FlattenMultilayerLinkedList {

    Node head;

    public class Node {
        int data;
        Node next, child;

        public Node(int data) {
            this.data = data;
            next = null;
            child = null;
        }
    }

    public static void main(String[] args){
        FlattenMultilayerLinkedList ll = new FlattenMultilayerLinkedList();
        /* Let us create the following linked list
            10 -> 5 ->  12 ->  7 -> 11
            |     |      |     |
            V     V      V     V
            4 ->  20 -> 13    17 -> 6
                  |      |     |
                  V      V     V
                  2  -> 16     9 -> 8
                         |     |
                         V     V
                         3    19 -> 15
        */

    }
}
