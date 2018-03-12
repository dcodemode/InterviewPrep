package learn.ds.linkedlist.singly;

import java.util.*;

/**
 * @author Varma Penmetsa
 *
 *  Input:
 *       10 -> 5 ->  12 ->  7 -> 11
 *       |                  |
 *       V                  V
 *       4 ->  20 -> 13    17 -> 6
 *       |      |     |
 *       V      V     V
 *       2  -> 16     9 -> 8
 *       |     |
 *       V     V
 *       3    19 -> 15
 *  Output:
 *      10 5 12 7 11 4 20 13 17 6 2 16 9 8 3 19 15
 *
 * https://www.geeksforgeeks.org/flatten-a-linked-list-with-next-and-child-pointers/
 */
public class FlattenMultilayerLinkedList {

    /*
     * All methods except Flatten are taken from geeksforgeeks
     */

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

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }

    Node createList(int arr[], int n) {
        Node node = null;
        Node p = null;

        int i;
        for (i = 0; i < n; ++i) {
            if (node == null) {
                node = p = new Node(arr[i]);
            } else {
                p.next = new Node(arr[i]);
                p = p.next;
            }
            p.next = p.child = null;
        }
        return node;
    }

    public Node createList() {
        int arr1[] = new int[]{10, 5, 12, 7, 11};
        int arr2[] = new int[]{4, 20, 13};
        int arr3[] = new int[]{17, 6};
        int arr4[] = new int[]{9, 8};
        int arr5[] = new int[]{19, 15};
        int arr6[] = new int[]{2};
        int arr7[] = new int[]{16};
        int arr8[] = new int[]{3};

        /* create 8 linked lists */
        Node head1 = createList(arr1, arr1.length);
        Node head2 = createList(arr2, arr2.length);
        Node head3 = createList(arr3, arr3.length);
        Node head4 = createList(arr4, arr4.length);
        Node head5 = createList(arr5, arr5.length);
        Node head6 = createList(arr6, arr6.length);
        Node head7 = createList(arr7, arr7.length);
        Node head8 = createList(arr8, arr8.length);

        /* modify child pointers to create the list shown above */
        head1.child = head2;
        head1.next.next.next.child = head3;
        head3.child = head4;
        head4.child = head5;
        head2.next.child = head6;
        head2.next.next.child = head7;
        head7.child = head8;

        /* Return head pointer of first linked list.  Note that all nodes are
         reachable from head1 */
        return head1;
    }

    public Node Flatten(Node node){
        Queue<Node> q = new LinkedList<>();

        Node res = new Node(-1);
        Node resH = res;

        while(node!=null){
            if(node.child!=null){
                q.add(node.child);
            }
            res.next = node;
            res = res.next;
            node = node.next;
        }

        while (!q.isEmpty()){
            Node temp = q.poll();
            while(temp!=null){
                if(temp.child!=null){
                    q.add(temp.child);
                }
                res.next = temp;
                res = res.next;
                temp = temp.next;
            }
        }

        return  resH.next;
    }

    public static void main(String[] args){
        FlattenMultilayerLinkedList ll = new FlattenMultilayerLinkedList();
        /* Let us create the following linked list
            10 -> 5 ->  12 ->  7 -> 11
            |                  |
            V                  V
            4 ->  20 -> 13    17 -> 6
                  |      |     |
                  V      V     V
                  2  -> 16     9 -> 8
                         |     |
                         V     V
                         3    19 -> 15
        */
        Node head = ll.createList();
        ll.printList(ll.Flatten(head));
    }
}
