package learn.java.abstraction;

public class Fish extends Animal{

    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if(speed.equals("slow")){
            System.out.println(type + " lazily swimming");
        }else{
            System.out.println(type + " darting frantically");
        }
    }

    @Override
    public void makeNoise() {
        if(type.equals("Goldfish")){
            System.out.println("Swish ");
        }else{
            System.out.println("Splash ");
        }
    }
}
