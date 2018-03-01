package learn.ds.linkedlist;

import learn.nodes.SListNode;

public class GetNthElement {

    SListNode head;

    LinkedList ll;

    public GetNthElement(SListNode head){
        this.head=head;
    }

    /*
     Print nth node from end of linked list
    */
    public int getNthFromLast(int position){
        SListNode node = head;
        int i= 1;
        while(node!=null && i<ll.length(head)-position){
            i++;
            node=node.next;
        }
        return node.data;
    }

    /*
      Print nth node from end of linked list two pointer approach
     */
    public int getNthFromLast2(int position){
        if (head==null) return 0;
        SListNode slow = head;
        SListNode fast = head;
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
        LinkedList ll = new LinkedList();
        SListNode a = new SListNode(20);
        SListNode b = new SListNode(30);
        SListNode c = new SListNode(40);
        SListNode d = new SListNode(50);
        SListNode e = new SListNode(60);
        SListNode f = new SListNode(70);
        ll.head = new SListNode(10);

        ll.head.next = a;
        ll.head.next.next = b;
        ll.head.next.next.next = c;
        ll.head.next.next.next.next = d;
        ll.head.next.next.next.next.next = e;
        ll.head.next.next.next.next.next.next = f;

        ll.print();

        GetNthElement gn = new GetNthElement(ll.head);

        System.out.println(gn.getNthFromLast(0));
        System.out.println(gn.getNthFromLast(1));
        System.out.println(gn.getNthFromLast2(2));

    }
}
