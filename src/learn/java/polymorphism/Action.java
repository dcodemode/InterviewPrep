package learn.java.polymorphism;

public class Action extends Movie{

    public Action(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.println("..Good Fights \n" +
                "..Loud music");

    }
}
