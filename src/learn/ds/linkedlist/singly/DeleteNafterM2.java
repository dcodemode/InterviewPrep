package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.HelperLinkedList;
import learn.util.LinkedList;
import learn.util.RandLinkedListGenetator;

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

    public static ListNode delete(ListNode head, int n, int m){
        if(head==null){
            return head;
        }
        int i = 0;
        ListNode curr = head;
        ListNode prev;

        while(curr.next!=null && i<m-1){
            i++;
            curr = curr.next;
        }

        if (curr.next==null){
            return curr;
        }

        prev = curr;

        i =0;
        while(curr.next!=null && i<n){
            i++;
            curr = curr.next;
        }

        prev.next = delete(curr.next, n, m);

        return head;

    }

    public static void main(String[] args) {
        LinkedList ll = new RandLinkedListGenetator().create(5);
        ll.display();

        HelperLinkedList.display(delete(ll.head, 2, 2));

    }
}
