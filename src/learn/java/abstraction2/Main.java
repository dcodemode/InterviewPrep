package learn.java.abstraction2;

public class Main {

    public static void main(String[] args) {
        Bird bird = new Bird();

        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        animal.move();
//        flier.move();
//        tracked.move();

//        flier.takeOff();
//        flier.fly();
//        flier.land();
//        tracked.track();

        isFlight(flier);
        isFlight(new Jet());

        Trackable truck = new Truck();
        truck.track();
    }

    private static void isFlight(FlightEnabled flier){
        flier.takeOff();
        flier.fly();
        if(flier instanceof Trackable tracked){
            tracked.track();
        }
        flier.land();
    }
}
