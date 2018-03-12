package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;
import learn.ds.util.HelperLinkedList;
import learn.ds.util.LinkedList;
import learn.ds.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 *
 * Given a linked list and two integers M and N. Traverse the linked list such that you retain M nodes then delete next N nodes,
 * continue the same till end of the linked list.
 *
 * https://www.geeksforgeeks.org/delete-n-nodes-after-m-nodes-of-a-linked-list/
 *
 */
public class DeleteNafterM2 {

    public static SListNode delete(SListNode head, int n, int m){
        SListNode curr = head;
        int i = 0;
        while(curr!=null || i < m){
            i++;
            curr = curr.next;
        }
        curr.next = delete(curr.next,n,m);

        return null;
    }

    public static void main(String[] args) {
        LinkedList ll = new RandLinkedListGenetator().create(7);
        ll.display();

        HelperLinkedList.display(delete(ll.head, 2, 2));

    }
}
