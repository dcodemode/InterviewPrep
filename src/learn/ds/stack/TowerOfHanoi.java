package learn.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Varma Penmetsa
 *
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

    public static void main(String[] args) {
        moveTower(2,'1','2','3');
    }

}
