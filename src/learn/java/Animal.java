package learn.java;

/**
 * @author Varma Penmetsa
 */
public class Animal {

    String name = "Ostrich";

    public void getName(){
        System.out.println(name);
    }

    public static void show() {
        System.out.println("Animal::show() called");
    }

}
