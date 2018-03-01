package learn.ds;

import learn.nodes.SListNode;

import javax.swing.plaf.SliderUI;

public class LinkedList {

    SListNode head;

    /* Push adds node on front of the list*/
    public void push(int data) {
        SListNode new_node = new SListNode(data);
        new_node.next = head;
        head = new_node;

    }

    /* Pop removes first element in the linked list*/
    public void pop() {
        if (head == null) {
            System.out.println("\nNo Elements to pop ");
            return;
        }
        head = head.next;
    }

    /* Print elements of a linked list*/
    public void print() {
        SListNode node = head;
        while (node != null) {
            System.out.print(node.data + " --> ");
            node = node.next;
        }
        System.out.println("null");
    }

    /* Insert after a given node */
    public void insertAfter(SListNode prev, int new_data) {

        SListNode new_node = new SListNode(new_data);
        SListNode temp;

        if (null == prev) {
            System.out.println("Given node cant't be null");
            return;
        }
        new_node.next = prev.next;
        prev.next = new_node;
    }

    /* Add after last node */
    public void append(int new_data) {

        if (head == null) {
            head = new SListNode(new_data);
            return;
        }
        SListNode new_node = new SListNode(new_data);
        SListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new_node;
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

    /*Length of a linked list*/
    public int length(){
        SListNode node = head;
        int i=0;
        while(node!=null){
            i++;
            node = node.next;
        }
        return i;
    }

    /*Search an element in linked list iterative solution*/
    public int search(int data){
        SListNode temp = head;

        while(temp!=null && temp.data!= data){
            temp=temp.next;
        }

        if (temp==null){
            return -1;
        }
        return 1;

    }

    /*Search an element in linked list recursive solution*/
    public boolean searchRecursive(SListNode head, int data){
       if(head==null){
           return false;
       }
       if (head.data==data){
           return true;
       }
       return searchRecursive(head.next,data);
    }

    /* Swap nodes in a linked list without swapping data */
    public void swapNode(SListNode x, SListNode y) {

        //Search prev of node x
        SListNode currX = head;
        SListNode prevX = null;

        if (currX == null) return;
        while (currX != null && currX != x) {
            prevX = currX;
            currX = currX.next;
        }
        if (currX == null) return;

        //Search prev of node Y
        SListNode currY = head;
        SListNode prevY = null;

        if (currY == null) return;
        while (currY != null && currY != y) {
            prevY = currY;
            currY = currY.next;
        }
        if (currY == null) return;

        //If x is head
        if(prevX == null){
            SListNode temp = currX.next;
            currX.next = currY.next;
            currY.next = temp;

            prevY.next=currX;
            head=currY;
            return;
        }

        //If Y is head
        if(prevY == null){
            SListNode temp = currY.next;
            currY.next = currX.next;
            currX.next = temp;

            prevX.next=currY;
            head=currX;
            return;
        }

        //Swapping nodes
        SListNode temp = currX.next;
        currX.next = currY.next;
        currY.next= temp;

        prevX.next=currY;
        prevY.next=currX;

    }

    /* Write a function to get Nth node in a Linked List */
    public SListNode getNode(int position){
        SListNode node = head;
        int i=0;
        while(node!=null && i<position){
            i++;
            node=node.next;
        }
        return node;
    }

    /* Print middle element of a linked list, if even nodes print second then there would be two middle nodes,
     we need to print second middle element */
    public int getMiddleElement(){
       SListNode slow = head;
       SListNode fast = head;
       while(fast!=null && fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;
       }
       return slow.data;
    }

    /* Print middle element of a linked list, if even nodes print second then there would be two middle nodes,
    we need to print first middle element */
    public int getMiddleElement2(){
        SListNode slow = head;
        SListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }

    //Get middle element
    public int getMiddleElement3(){
        SListNode node=head;
        if(node == null) return 0;
        for(int i=0;i<length()/2;i++){
            node=node.next;
        }
        return node.data;
    }

    /*
      Print nth node from end of linked list
     */
    public int getNthFromLast(int position){
        SListNode node = head;
        int i= 1;
        while(node!=null && i<length()-position){
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

    /*
      Write a function that counts the number of times a given int occurs in a Linked List
     */
    public int dupCount(int num){
        int i=0;
        SListNode node = head;
        while(node!=null){
            if(node.data==num){
                i++;
            }
            node=node.next;
        }
        return i;
    }

     /*
      Write a function that counts the number of times a given int occurs in a Linked List using recursion
     */
     public int dupCount2(SListNode curr, int num){
         if (curr==null){
             return 0;
         }else if(curr.data==num){
             return 1 + dupCount2(curr.next,num);
         }else{
             return dupCount2(curr.next,num);
         }
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
        ll.append(10);
        ll.append(10);
        ll.append(10);

        ll.print();
        /*
        ll.push(5);
        ll.push(1);
        ll.insertAfter(a, 25);
        System.out.println("Length of linked list: " + ll.length());
        ll.deleteKey(15);
        ll.deleteNode(ll.head);
        ll.deleteAfterPosition(7);
        ll.print(ll.head);
        System.out.println(ll.searchRecursive(ll.head,10));
        ll.swapNode(a,d);
        ll.print(ll.head);
        System.out.println(ll.getNode(9));
        System.out.println(ll.getMiddleElement());
        System.out.println(ll.getMiddleElement2());
        System.out.println(ll.getMiddleElement3());
        System.out.println(ll.getNthFromLast(0));
        System.out.println(ll.getNthFromLast(1));
        System.out.println(ll.getNthFromLast2(1));
        */
        System.out.println(ll.dupCount2(ll.head,10));



    }

}
