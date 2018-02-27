package learn.nodes;

public class SListNode {
    /*
      Basic singly linked list node
     */

    public SListNode next;
    public Integer data;

    public SListNode(Integer data){
        this.data=data;
        this.next=null;
    }
}
