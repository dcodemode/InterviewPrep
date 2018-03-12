package learn.ds.linkedlist.singly;

import learn.ds.nodes.SListNode;
import learn.ds.util.LinkedList;

import java.util.HashSet;

public class DetectLoop {

    LinkedList ll;

    public DetectLoop(LinkedList ll){
        this.ll=ll;
    }

    /* Given a linked list, check if the the linked list has loop or not (Hashing Approach) */
    public boolean checkLoop(){
        if (ll.head==null) return false;
        HashSet<SListNode> set = new HashSet<SListNode>();
        SListNode node = ll.head;
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
        SListNode slow = ll.head,fast = ll.head;
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
        LinkedList ll = new LinkedList(new SListNode(10));

        SListNode a = new SListNode(20);
        SListNode b = new SListNode(30);
        SListNode c = new SListNode(40);
        SListNode d = new SListNode(50);
        SListNode e = new SListNode(60);
        SListNode f = new SListNode(70);

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
