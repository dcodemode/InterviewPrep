package learn.java;

/**
 * @author Varma Penmetsa
 */
public class Bird extends Animal {

    String name = "Parrot";

    @Override
    public void getName(){
        System.out.println(name);
    }

    public static void show() {
        System.out.println("Bird::show() called");
    }

    public static void main(String[] args) {

        Animal animal = new Bird();
        /* Variables are never overrides, so animal.name gives "Ostrich" */
        System.out.println(animal.name);

        /* getName method is overridden in bird class, so we get "Parrot" */
        animal.getName();

        /* Static methods can't also be overridden, so we get "Animal::show() called" */
        animal.show();


    }
}
