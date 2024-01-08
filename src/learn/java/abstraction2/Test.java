package learn.java.abstraction2;

public class Test {

    public static void main(String[] args) {
        isFlight(new Jet());
    }

    private static void isFlight(FlightEnabled flier){
        flier.takeOff();
        flier.transition(FlightStages.LAUNCH);
        flier.fly();
        if(flier instanceof Trackable tracked){
            tracked.track();
        }
        flier.land();
    }
}
