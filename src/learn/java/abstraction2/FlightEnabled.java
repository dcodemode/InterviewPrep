package learn.java.abstraction2;

public interface FlightEnabled {

    // Any variable in interface is public static final by default, basically a constant
    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    // Any method declared in interface is public abstract by default.
    void takeOff();

    void land();

    void fly();

    /**
     * Default method to allow an interface method to provide an implementation used as default in the
     * event that a concrete class doesn't provide an implementation for that method.
     */
    default FlightStages transition(FlightStages stage){
        System.out.println("transition not implemented on " + getClass().getName());
        return  null;
    }
}
