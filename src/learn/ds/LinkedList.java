package learn.ds;

import learn.nodes.SListNode;

public class LinkedList {

    SListNode head;

    /* Push adds node on front of the list*/
    public void push(int data){
        SListNode new_node = new SListNode(data);
        new_node.next=head;
        head=new_node;

    }

    public void print(SListNode head){
        while(head != null){
            System.out.print(head.data+ " ");
            head=head.next;
        }
    }

    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.head= new SListNode(10);
        ll.push(20);
        ll.push(30);

        ll.print(ll.head);
    }

}
