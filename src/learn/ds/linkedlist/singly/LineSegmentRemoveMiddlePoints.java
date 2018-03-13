package learn.ds.linkedlist.singly;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/given-linked-list-line-segments-remove-middle-points/
 */
public class LineSegmentRemoveMiddlePoints {

    public Node head;

    public class Node {
        int x, y;
        Node next;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            next = null;
        }

    }

    public void push(int x, int y){
        Node new_node = new Node(x,y);
        new_node.next = head;
        head = new_node;
    }

    public Node removeMiddleNodes(Node head) {
        Node curr = head;

        while (curr != null && curr.next != null && curr.next.next != null) {
            if (curr.y == curr.next.y && curr.next.y == curr.next.next.y
                    || curr.x == curr.next.x && curr.next.x == curr.next.next.x) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public void printlist(){
        Node h = head;
        while(h!=null){
            System.out.print( "(" + h.x +", "+ h.y +") --> ");
            h=h.next;
        }
        System.out.println(" null ");
    }

    public void printlist(Node head){
        Node h = head;
        while(h!=null){
            System.out.print( "(" + h.x +", "+ h.y +") --> ");
            h=h.next;
        }
        System.out.println(" null ");
    }

    public static void main(String args[]){

        LineSegmentRemoveMiddlePoints llist  = new LineSegmentRemoveMiddlePoints();

        llist.push(12,3);
        llist.push(10,3);
        llist.push(6,3);
        llist.push(4,3);
        llist.push(2,3);

        llist.printlist();

        llist.printlist(llist.removeMiddleNodes(llist.head));

    }
}
