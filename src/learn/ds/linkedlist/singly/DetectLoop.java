package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.LinkedList;

import java.util.HashSet;

public class DetectLoop {

    LinkedList ll;

    public DetectLoop(LinkedList ll){
        this.ll=ll;
    }

    /* Given a linked list, check if the the linked list has loop or not (Hashing Approach) */
    public boolean checkLoop(){
        if (ll.head==null) return false;
        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode node = ll.head;
        while(node!=null){
            if(set.contains(node)){
                return true;
            }
            set.add(node);
            node=node.next;
        }
      return false;
    }

    /* Detect loop in a linked list, Floyd’s Cycle-Finding Algorithm */
    public boolean checkLoop2(){
        if (ll.head==null) return false;
        ListNode slow = ll.head,fast = ll.head;
        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]){
        LinkedList ll = new LinkedList(new ListNode(10));

        ListNode a = new ListNode(20);
        ListNode b = new ListNode(30);
        ListNode c = new ListNode(40);
        ListNode d = new ListNode(50);
        ListNode e = new ListNode(60);
        ListNode f = new ListNode(70);

        ll.head.next = a;
        ll.head.next.next = b;
        ll.head.next.next.next = c;
        ll.head.next.next.next.next = d;
        ll.head.next.next.next.next.next = e;
        ll.head.next.next.next.next.next.next = f;
        f.next=ll.head;

        DetectLoop dl = new DetectLoop(ll);
        System.out.println(dl.checkLoop());
        System.out.println(dl.checkLoop2());
    }
}
