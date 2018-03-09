package learn.ds.util;

import java.util.Random;

public class RandLinkedListGenetator {

    Random rand = new Random();

    /*
      Code to generate random linked list
     */
    public LinkedList create(int size){
        LinkedList ll = new LinkedList();
        int i=0;
        while(i<size){
            ll.append(rand.nextInt(99));
            i++;
        }
        return ll;
    }

    public static void main(String args[]){
        LinkedList ll = new RandLinkedListGenetator().create(5);
        ll.display();
    }

}
