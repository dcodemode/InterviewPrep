package learn.ds.queue;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Varma Penmetsa
 */
public class LRU {

    public class Node {
        Node prev, next;
        int val;

        public Node(int val) {
            this.val = val;
            prev = next = null;
        }
    }

    Node head;
    Node end;

    private Map<Integer, Node> map  =  new HashMap<>();
    private int size;

    public LRU(int size){
        this.size = size;
    }

    public void set(int val){

        if(head == null){
            head = new Node(val);
            end = head;
            map.put(val,head);
            return;
        }

        //Size check
        if(map.size() >= size){
            delete(end);
        }

        if(map.containsKey(val)){
            delete(map.get(val));
        }

        Node new_node = new Node(val);
        new_node.next = head;
        head.prev = new_node;
        head = new_node;
        map.put(val,new_node);
    }

    public void delete(Node node){
        if(node == null){
            return;
        }

        if(node.prev == null){
            head  = node.next;
            head.prev = null;
        }else if(node.next == null){
            node.prev.next = null;
            end = node.prev;
        }else {
            node.next.prev = node.prev;
            node.prev.next = node.next;

        }
    }

    public static void display(Node node){
        Node last = null;
        System.out.println("Traversing forward");
        while(node!=null){
            System.out.print(node.val+ " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversing reverse");
        while(last!=null){
            System.out.print(last.val +" ");
            last = last.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        LRU l =  new LRU(4);

        l.set(1);
        l.set(2);
        l.set(3);
        l.set(1);
        l.set(4);
        l.set(5);

        display(l.head);

    }

}
