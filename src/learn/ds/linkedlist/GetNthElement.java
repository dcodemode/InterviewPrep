package learn.ds.linkedlist;

/**
 * @author Varma Penmetsa
 */

import learn.ds.nodes.SListNode;

public class GetNthElement {

    LinkedList ll;

    public GetNthElement(LinkedList ll){
        this.ll=ll;
    }

    /*
     Print nth node from end of linked list
    */
    public int getNthFromLast(int position){
        SListNode node = ll.head;
        int i= 1;
        while(node!=null && i<ll.length(ll.head)-position){
            i++;
            node=node.next;
        }
        return node.data;
    }

    /*
      Print nth node from end of linked list two pointer approach
     */
    public int getNthFromLast2(int position){
        if (ll.head==null) return 0;
        SListNode slow = ll.head;
        SListNode fast = ll.head;
        for(int i=0;i<position;i++){
            fast=fast.next;
        }
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow.data;
    }

    public static void main(String args[]) {
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

        ll.display();

        GetNthElement gn = new GetNthElement(ll);

        System.out.println(gn.getNthFromLast(0));
        System.out.println(gn.getNthFromLast(1));
        System.out.println(gn.getNthFromLast2(2));

    }
}
