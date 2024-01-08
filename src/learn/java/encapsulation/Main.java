package learn.java.encapsulation;

public class Main {

    public static void main(String[] args) {
        Player tim = new Player("Tim", 99,"Sword");
        System.out.println("Initial health is " + tim.healthRemaining());

        tim.loseHealth(100);
    }
}
