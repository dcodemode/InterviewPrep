package learn.java.abstraction;

public abstract class Mammal extends Animal{

    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    public abstract void shredHair();
}
