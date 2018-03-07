package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;
import learn.ds.util.LinkedList;

public class MergeSortedLinkedLists {

    /* This method takes heads of two linked list and merge two sorted linked lists using dummy node approach */
    public static SListNode sortedMerge(SListNode l1,SListNode l2){
        //Creating a dummy node
        SListNode dummy = new SListNode(0);
        SListNode head = dummy;

        while(l1!= null && l2!=null){
          if(l1.data <= l2.data){
              dummy.next=l1;
              l1=l1.next;
          }else if(l1.data > l2.data){
              dummy.next = l2;
              l2=l2.next;
          }
          dummy=dummy.next;
        }

        if(l1!=null){
            dummy.next=l1;
        }

        if(l2!=null){
            dummy.next=l2;
        }

        return head.next;
    }

    /* Merge sorted linked list with out dummy node */
    public static SListNode sortedMerge2(SListNode l1, SListNode l2){
        SListNode head=null;
        SListNode ret;

        if(l1==null && l2==null){
            return head;
        }else if(l1==null && l2!=null){
            return l2;
        }else if(l1!=null && l2==null){
            return l1;
        }

        if(l1.data <= l2.data){
            head=l1;
            l1=l1.next;
        }else if(l1.data > l2.data){
            head = l2;
            l2=l2.next;
        }

        ret = head;

        while(l1!=null && l2!=null){
            if(l1.data<=l2.data){
                head.next=l1;
                l1=l1.next;
            }else if(l1.data>l2.data){
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }

        if(l1!=null){
            head.next=l1;
        }

        if(l2!=null){
            head.next=l2;
        }

        return ret;
    }

    /* Merge sorted linked list using recursion*/
    public static SListNode sortedMerge3(SListNode l1, SListNode l2){
        SListNode temp = null;

        if(l1==null && l2==null){
            return temp;
        }else if(l1!=null && l2==null){
            return l1;
        }else if(l1==null && l2!=null){
            return l2;
        }

        if (l1.data<l2.data){
            temp = l1;
            l1=l1.next;
        }else if(l1.data>l2.data){
            temp = l2;
            l2=l2.next;
        }
        temp.next = sortedMerge3(l1,l2);
        return temp;
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
        list2.append(120);
        list2.append(140);

        list1.display();
        list2.display();

        list1.display2(sortedMerge(list1.head,null));
        list1.display2(sortedMerge2(null,list2.head));
        list1.display2(sortedMerge3(list1.head,list2.head));

    }
}
