package learn.ds.queue;

import java.util.HashMap;
import java.util.Map;

/**
 * 9/8/18
 * @author Varma Penmetsa
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: getValue and setKeyValue.
 *
 * getValue(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * setKeyValue(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Ref: Cracking the code interview: Moderate 16.25, Page 185
 */
public class LRU {

    public class Node {
        Node prev, next;
        int key;
        String val;

        public Node(int k, String v) {
            this.key = k;
            this.val = v;
            prev = next = null;
        }
    }

    Node head;
    Node tail;

    private Map<Integer, Node> map  =  new HashMap<>();
    private int size;

    public LRU(int size){
        this.size = size;
    }

    /* Get Value from key and mark it as most recently used */
    public String getValue(int key){
        Node item = map.get(key);
        if(item == null){
            return null;
        }
        /* If item is not head, move the item front of list to mark as Most recently used. */
        if(item != head) {
            removeFromLinkedList(item);
            insertAtFrontOfLinkedList(item);
        }

        return item.val;
    }

    /* Remove Node from a Linked List */
    public void removeFromLinkedList(Node node){
        if(node == null){
            return;
        }

        //If node is head, make next node as head
        if(node == head){
            head = head.next;
        }

        //If node is tail, make previous node as tail
        if(node == tail){
            tail = tail.prev;
        }

        if(node.prev != null){
            node.prev.next = node.next;
        }
        if(node.next != null){
            node.next.prev = node.prev;
        }
    }

    /* Insert Node at front of linked list */
    public void insertAtFrontOfLinkedList(Node node){
        if(node == null){
            return;
        }

        if(head == null){
            head = node;
            tail = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    /* Remove key/value pair from cache, deleting from hash table and linked list. */
    public boolean removeKey(int key){
        Node item = map.get(key);
        removeFromLinkedList(item);
        map.remove(key);
        return true;
    }

    /* Put key,value pair in cache. Remove old values for keys if necessary. Insert pairs in linked-list and hash-table */
    public void setKeyValue(int key, String value){
        /* Remove key if already there */
        removeKey(key);

        /* If full remove recently used item. */
        if(map.size() >= size && tail != null){
            removeKey(tail.key);
        }

        /* Insert new node. */
        Node node  = new Node(key,value);
        insertAtFrontOfLinkedList(node);
        map.put(key,node);
    }

    /* Print Doubly Linked List */
    public static void display(Node node){
        System.out.print("Null <---> ");
        while(node!=null){
            System.out.print(node.val+ " <---> ");
            node = node.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        LRU cache = new LRU(5);

        cache.setKeyValue(1,"Book");
        cache.setKeyValue(2,"Dress");
        cache.setKeyValue(3,"Shoe");
        cache.setKeyValue(4,"Sock");
        cache.setKeyValue(5,"Pencils");
        cache.setKeyValue(6,"Pens");

        System.out.println("Value is : "+cache.getValue(2));

        display(cache.head);

    }

}
