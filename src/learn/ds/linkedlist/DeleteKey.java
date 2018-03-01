package learn.ds.linkedlist;

import learn.nodes.SListNode;

public class DeleteKey {

    SListNode head;

    public DeleteKey(SListNode head){
        this.head=head;
    }

    /* Given a ‘key’, delete the first occurrence of this key in linked list. */
    public void deleteKey(int new_data) {
        SListNode node = head;
        SListNode prevNode = null;

        if (node != null && node.data == new_data) {
            head = node.next;
            return;
        }

        while (node != null && node.data != new_data) {
            prevNode = node;
            node = node.next;
        }

        if (node == null) {
            System.out.println("Key not found.");
            return;
        }
        prevNode.next = node.next;
    }

    /* Deletes the node at the given node */
    public void deleteNode(SListNode node) {
        SListNode temp =head;
        SListNode prev = null;

        if(temp == node){
            head=temp.next;
            return;
        }
        while(temp != null && temp != node){
            prev = temp;
            temp=temp.next;
        }

        if (temp == null){
            System.out.println("Give node not found");
            return;
        }
        prev.next=temp.next;
    }

    /* Deletes the node at the given position */
    public void deleteAfterPosition(int position){
        SListNode node = head;
        SListNode prev = null;

        if (position==0){
            head = node.next;
            return;
        }

        int i=0;
        while(node!=null && i<=position-1){
            prev=node;
            node=node.next;
            i++;
        }

        if(node == null) return;
        prev.next=node.next;

    }


    public static void main(String args[]){
        LinkedList ll = new LinkedList();

        ll.head = new SListNode(10);
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

        DeleteKey del  = new DeleteKey(ll.head);

        ll.print();
        del.deleteKey(20);
        del.deleteNode(a);
        del.deleteAfterPosition(7);
        ll.print();
    }
}
