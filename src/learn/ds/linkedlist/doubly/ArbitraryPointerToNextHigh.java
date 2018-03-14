package learn.ds.linkedlist.doubly;
/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/point-to-next-higher-value-node-in-a-linked-list-with-an-arbitrary-pointer/
 */
public class ArbitraryPointerToNextHigh {

    /*
       1) Traverse input list and copy next pointer to arbit pointer for every node.
       2) Do Merge Sort for the linked list formed by arbit pointers.
     */

    public Node head;

    public ArbitraryPointerToNextHigh(int data){
        head = new Node(data);
    }

    public class Node{
        Node next,arb;
        int data;

        public Node(int data){
            this.data = data;
            next = arb = null;
        }
    }

    public void push(int data){
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    public void display(){
        Node curr = head;
        while(curr!=null){
            int arbVal = (curr.arb == null) ? -1 : curr.arb.data;
            System.out.println("Node :"+curr.data+"  Arb: "+ arbVal );
            curr = curr.next;
        }
    }

    public void display(Node head){
        Node curr = head;
        while(curr!=null){
            int arbVal = (curr.arb == null) ? -1 : curr.arb.data;
            System.out.println("Node :"+curr.data+"  Arb: "+ arbVal );
            curr = curr.next;
        }
    }

    public Node setArb(Node head){
        if (head==null){
            return head;
        }
        //Copy next to arb
        Node curr = head;
        while(curr!=null){
            curr.arb = curr.next;
            curr = curr.next;
        }
        merge_sort(head);
        return head;
    }

    public Node merge_sort(Node head){
        if (head==null || head.arb == null){
            return head;
        }

        Node mid = getMiddle(head);
        Node secList = mid.arb;
        mid.arb = null;

        Node left =  merge_sort(head);
        Node right =  merge_sort(secList);

        return merge(left,right);
    }

    public Node getMiddle(Node head){
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;

        while(fast.arb!=null && fast.arb.arb!=null){
            slow = slow.arb;
            fast = fast.arb.arb;
        }

        return slow;
    }

    public Node merge(Node a, Node b) {
        Node res = null;

        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }
        if (a.data < b.data) {
            res = a;
            res.arb = merge(a.arb, b);
        } else {
            res = b;
            res.arb = merge(a, b.arb);
        }
        return res;
    }

    public static void main(String[] args){
        ArbitraryPointerToNextHigh list = new ArbitraryPointerToNextHigh(3);
        list.push(2);
        list.push(10);
        list.push(5);

        list.display();
        System.out.println();
        list.display(list.setArb(list.head));
    }
}
