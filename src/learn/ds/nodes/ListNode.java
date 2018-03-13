package learn.ds.nodes;

public class ListNode {

    /*
      Basic singly linked list node
     */
    public ListNode next,prev;
    public int data;

    public ListNode(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
