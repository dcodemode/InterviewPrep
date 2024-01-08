package learn.java.abstraction2;

public class Truck implements Trackable{
    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() +"'s location recorded");
    }
}
