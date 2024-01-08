package learn.java.polymorphism;

public class Fantasy extends  Movie{

    public Fantasy(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.println("..Beautiful visuals \n" +
                "..Nice music");
    }
}
