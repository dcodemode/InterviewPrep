package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;
import learn.ds.util.LinkedList;
import learn.ds.util.RandLinkedListGenetator;

public class CountDuplicateElements {

    LinkedList ll;

    public CountDuplicateElements(LinkedList ll){
        this.ll=ll;
    }

    /*
      Write a function that counts the number of times a given int occurs in a Linked List
     */
    public int dupCount(int num){
        int i=0;
        SListNode node = ll.head;
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
        LinkedList ll = new RandLinkedListGenetator().create(10);
        ll.append(10);
        ll.append(10);
        ll.display();

        CountDuplicateElements cd = new CountDuplicateElements(ll);
        System.out.println(cd.dupCount(10));
        System.out.println(cd.dupCount2(ll.head,10));

    }


}
