package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.HelperLinkedList;
import learn.util.LinkedList;
import learn.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 *
 *
 * https://www.geeksforgeeks.org/merge-a-linked-list-into-another-linked-list-at-alternate-positions/
 */
public class MergeTwoListsAlternatively {

    public static ListNode merge2List(ListNode a, ListNode b) {
        ListNode res = new ListNode(-1);
        ListNode retH = res;

        while(a!=null || b!=null){
            if(a!=null){
                res.next = a;
                res = res.next;
                a = a.next;
            }
            if(b!=null){
                res.next = b;
                res = res.next;
                b = b.next;
            }
        }

        return retH.next;
    }

    public static void main(String[] args){
        LinkedList l1 = new RandLinkedListGenetator().create(4);
        LinkedList l2 = new RandLinkedListGenetator().create(4);

        l1.display();
        l2.display();

        HelperLinkedList.display(merge2List(l1.head,l2.head));
    }
}
