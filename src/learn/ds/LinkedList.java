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

    /* Pop removes first element in the linked list*/
    public void pop(){
        if(head == null){
            System.out.println("\nNo Elements to pop ");
            return;
        }
        head = head.next;
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
        ll.pop();

        System.out.print("\n");
        ll.print(ll.head);
    }

}
