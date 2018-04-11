package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.LinkedList;
import learn.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/find-length-of-a-linked-list-iterative-and-recursive/
 */
public class LengthOfLinkedList {

    //Recursive
    public static int length(ListNode head){
        if(head == null){
            return 0;
        }
        return 1 + length(head.next);
    }

    public static void main(String[] args) {
        LinkedList ll = new RandLinkedListGenetator().create(15);
        System.out.println("Length: " + length(ll.head));
    }
}
