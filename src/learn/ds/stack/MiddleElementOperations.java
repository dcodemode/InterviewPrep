package learn.ds.stack;

import learn.ds.nodes.ListNode;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/stack-data-structure/
 */
public class MiddleElementOperations {

    public class Node{
        Node prev,next;
        String data;
        Node(String data){
            this.data = data;
            prev = next = null;
        }
    }

    public Node head;
    public Node mid;
    int count = 0;

    public void push(String data) {
        if (head == null) {
            head = new Node(data);
            mid = head;
            count++;
            return;
        }
        Node new_node = new Node(data);
        new_node.next = head;
        head.prev = new_node;
        head = new_node;
        if(count%2!=0){
            mid = mid.prev;
        }
        count++;
    }

    public void pop(){
        if (head == null) {
            System.out.println("Stack Underflow");
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        if (--count % 2 == 0) {
            mid = mid.next;
        }
    }

    public String getMiddleElement(){
        return mid.data;
    }

    public void display(Node node){
        Node last = null;
        System.out.println("Forward Traversal");
        while(node!=null){
            System.out.print(node.data + " ");
            last = node;
            node=node.next;
        }
        System.out.println();
        System.out.println("Reverse Traversal");
        while(last!=null){
            System.out.print(last.data + " ");
            last=last.prev;
        }

    }

    public static void main(String[] args) {
        MiddleElementOperations mo = new MiddleElementOperations();

        mo.push("K");
        mo.push("C");
        mo.push("A");
        mo.push("T");
        mo.push("S");

        mo.pop();
        mo.pop();
        mo.pop();

        mo.display(mo.head);
        System.out.println("\nMiddle element is : " +mo.getMiddleElement());

    }
}
