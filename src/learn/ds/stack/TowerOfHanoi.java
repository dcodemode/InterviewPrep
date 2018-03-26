package learn.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Varma Penmetsa
 * <p>
 * https://www.geeksforgeeks.org/iterative-tower-of-hanoi/
 */
public class TowerOfHanoi {

    //Recursive Approach
    public static void moveTower(int rings, char fromTower, char toTower, char auxTower) {
        if (rings == 1) {
            System.out.println("Move disk 1 from rod " + fromTower + " to rod " + toTower);
            return;
        }
        moveTower(rings - 1, fromTower, auxTower, toTower);
        System.out.println("Move disk " + rings + " from rod " + fromTower + " to rod " + toTower);
        moveTower(rings - 1, auxTower, toTower, fromTower);
    }

    //Iterative Approach using stacks
    public static Deque<Integer> moveTower2(int num_of_disks, Deque<Integer> fromTower, Deque<Integer> toTower, Deque<Integer> auxTower) {

        char s = 'S', d = 'D', a = 'A';

        // If number of disks is even, then interchange
        // destination pole and auxiliary pole
        if (num_of_disks % 2 == 0) {
            char temp = d;
            d = a;
            a = temp;
        }
        int totalMoves = (int) (Math.pow(2, num_of_disks) - 1);

        for (int i = num_of_disks; i >= 1; i--) {
            fromTower.push(i);
        }

        for (int i = 1; i <= totalMoves; i++) {
            if (i % 3 == 1) {
                moveDisksBetweenTwoPoles(fromTower, toTower, s, d);
            } else if (i % 3 == 2) {
                moveDisksBetweenTwoPoles(fromTower, auxTower, s, a);
            } else if (i % 3 == 0) {
                moveDisksBetweenTwoPoles(auxTower, toTower, a, d);
            }
        }
        return toTower;
    }

    public static void moveDisksBetweenTwoPoles(Deque<Integer> src, Deque<Integer> dest, char s, char d) {
        int pole1TopDisk = src.pop();
        int pole2TopDisk = dest.pop();

        // When pole 1 is empty
        if (pole1TopDisk == Integer.MIN_VALUE) {
            src.push(pole2TopDisk);
            moveDisk(d, s, pole2TopDisk);
        }
        // When pole2 pole is empty
        else if (pole2TopDisk == Integer.MIN_VALUE) {
            dest.push(pole1TopDisk);
            moveDisk(s, d, pole1TopDisk);
        }
        // When top disk of pole1 > top disk of pole2
        else if (pole1TopDisk > pole2TopDisk) {
            src.push(pole1TopDisk);
            src.push(pole2TopDisk);
            moveDisk(d, s, pole2TopDisk);
        }
        // When top disk of pole1 < top disk of pole2
        else {
            dest.push(pole2TopDisk);
            moveDisk(s, d, pole1TopDisk);
        }
    }

    static void moveDisk(char fromPeg, char toPeg, int disk) {
        System.out.println("Move the disk " + disk + " from " + fromPeg + " to " + toPeg);
    }

    public static void main(String[] args) {
        moveTower(6,'1','2','3');

//        Deque<Integer> fromTower = new ArrayDeque<>();
//        Deque<Integer> toTower = new ArrayDeque<>();
//        Deque<Integer> auxTower = new ArrayDeque<>();
//
//        moveTower2(3, fromTower, toTower, auxTower);
//
//        for (int ele : toTower) {
//            System.out.println(ele);
//        }
    }

}
