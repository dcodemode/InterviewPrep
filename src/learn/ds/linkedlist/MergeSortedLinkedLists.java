package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;

public class MergeSortedLinkedLists {

    /* Merge two soted linked lists */
    public SListNode sortedMerge(LinkedList a,LinkedList b){
        int lenA = a.length();
        int lenB = b.length();

        if(a.head == null && b.head == null){
            return null;
        }else if(a.head == null && b.head!=null ){
            return b.head;
        }else{
            return a.head;
        }


    }

    public static void main(String args[]) {
        LinkedList list1 = new LinkedList(new SListNode(10));
        list1.append(30);
        list1.append(50);
        list1.append(70);
        list1.append(90);
        list1.append(110);
        list1.append(130);

        LinkedList list2 = new LinkedList(new SListNode(0));
        list2.append(20);
        list2.append(40);
        list2.append(60);
        list2.append(80);
        list2.append(100);
        list2.append(140);

        list1.display();
        list2.display();
    }
}
