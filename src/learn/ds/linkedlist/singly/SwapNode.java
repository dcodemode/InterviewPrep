package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.LinkedList;
import learn.util.RandLinkedListGenetator;

/**
 *
 * Swap nodes in a linked list without swapping data
 *
 * Given a linked list and two keys in it, swap nodes for two given keys. Nodes should be swapped by changing links. Swapping data of nodes may be expensive in many situations when data contains many fields.
 *
 * It may be assumed that all keys in linked list are distinct.
 *
 * Examples:
 *
 * Input:  10->15->12->13->20->14,  x = 12, y = 20
 * Output: 10->15->20->13->12->14
 *
 * Input:  10->15->12->13->20->14,  x = 10, y = 20
 * Output: 20->15->12->13->10->14
 *
 * Input:  10->15->12->13->20->14,  x = 12, y = 13
 * Output: 10->15->13->12->20->14
 *
 * https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
 * @author Varma Penmetsa
 */
public class SwapNode {

    LinkedList ll;

    public SwapNode(LinkedList ll){
        this.ll=ll;
    }

    public void swap(ListNode x, ListNode y) {

        //Search prev of node x
        ListNode currX = ll.head;
        ListNode prevX = null;

        if (currX == null) return;
        while (currX != null && currX != x) {
            prevX = currX;
            currX = currX.next;
        }
        if (currX == null) return;

        //Search prev of node Y
        ListNode currY = ll.head;
        ListNode prevY = null;

        if (currY == null) return;
        while (currY != null && currY != y) {
            prevY = currY;
            currY = currY.next;
        }
        if (currY == null) return;

        //If x is head
        if(prevX == null){
            ListNode temp = currX.next;
            currX.next = currY.next;
            currY.next = temp;

            prevY.next=currX;
            ll.head=currY;
            return;
        }

        //If Y is head
        if(prevY == null){
            ListNode temp = currY.next;
            currY.next = currX.next;
            currX.next = temp;

            prevX.next=currY;
            ll.head=currX;
            return;
        }

        //Swapping nodes
        ListNode temp = currX.next;
        currX.next = currY.next;
        currY.next= temp;

        prevX.next=currY;
        prevY.next=currX;

    }

    public static void main(String args[]){
        LinkedList ll = new RandLinkedListGenetator().create(7);
        ll.display();

        SwapNode sn = new SwapNode(ll);
        sn.swap(ll.head,ll.getNode(3));
        ll.display();

    }
}
