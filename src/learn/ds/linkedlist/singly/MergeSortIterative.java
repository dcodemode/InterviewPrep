package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.HelperLinkedList;
import learn.util.LinkedList;
import learn.util.RandLinkedListGenetator;

public class MergeSortIterative {

    public static ListNode mergeSort(ListNode first){
        if(first==null || first.next == null){
            return first;
        }

        ListNode mid = getMiddle(first);
        ListNode second = mid.next;
        mid.next = null;

        //TODo

        return null;

    }


    public static ListNode getMiddle(ListNode head){
        if(head==null) return head;
        ListNode slow = head;
        ListNode fast = head;
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

