package learn.ds.linkedlist.doubly;

import learn.ds.nodes.ListNode;

public class DoublyLinkedList {

    public ListNode head;

    public DoublyLinkedList(){

    }

    public DoublyLinkedList(int data){
        ListNode new_node = new ListNode(data);
        this.head = new_node;
    }

    public void push(int data){
        ListNode new_node = new ListNode(data);
        new_node.next  = head;
        if(head!=null){
            head.prev = new_node;
        }
        head = new_node;
    }

    public void pop(){
        if(head == null){
            return;
        }
        head = head.next;
        if(head!=null){
            head.prev = null;
        }
    }

    public void insertAfter(int data, int new_data) {
        ListNode curr = head;
        while (curr != null && curr.data != data) {
            curr = curr.next;
        }
        if (curr == null) {
            return;
        }
        ListNode new_node = new ListNode(new_data);

        new_node.next = curr.next;
        curr.next = new_node;
        new_node.prev = curr;

        if (new_node.next != null) {
            new_node.next.prev = new_node;
        }
    }

    public void display(ListNode node){
        ListNode last = null;
        System.out.println("Traversing forward");
        while(node!=null){
            System.out.print(node.data+ " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversing reverse");
        while(last!=null){
            System.out.print(last.data +" ");
            last = last.prev;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(50);

        dll.push(40);
        dll.push(30);
        dll.push(20);
        dll.push(10);

        dll.pop();
        dll.insertAfter(30,35);
        dll.display(dll.head);

    }


}
