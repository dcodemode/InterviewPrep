package learn.ds.linkedlist.singly;

import learn.ds.nodes.SListNode;
import learn.ds.util.HelperLinkedList;
import learn.ds.util.LinkedList;
import learn.ds.util.RandLinkedListGenetator;

public class MergeSortIterative {

    public static SListNode mergeSort(SListNode first){
        if(first==null || first.next == null){
            return first;
        }

        SListNode mid = getMiddle(first);
        SListNode second = mid.next;
        mid.next = null;

        //TODo

        return null;

    }


    public static SListNode getMiddle(SListNode head){
        if(head==null) return head;
        SListNode slow = head;
        SListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static void main(String args[]) {
        LinkedList ll = new RandLinkedListGenetator().create(7);
        ll.display();

        HelperLinkedList.display(mergeSort(ll.head));

    }
}

