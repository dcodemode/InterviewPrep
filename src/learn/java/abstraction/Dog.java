package learn.java.abstraction;

public class Dog extends Mammal{

    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void shredHair() {
        System.out.println(type + " shreds hair in Spring");
    }

    @Override
    public void move(String speed) {
        if(speed.equals("slow")){
            System.out.println(type + " walking");
        }else{
            System.out.println(type + " running");
        }
    }

    @Override
    public void makeNoise() {
        if(type.equals("Wolf")){
            System.out.println("Howling! ");
        }else{
            System.out.println("Woof! ");
        }
    }
}
