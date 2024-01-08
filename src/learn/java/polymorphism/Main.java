package learn.java.polymorphism;

public class Main {

    public static void main(String[] args) {
//        Movie movie = new Movie("Generic");
//        movie.watchMovie();
//
//        Movie saalar = new Action("Saalar");
//        saalar.watchMovie();
//
//        Movie baahubali = new Fantasy("Baahubali");
//        baahubali.watchMovie();

        Movie saalar = Movie.getMovie("Action", "Saalar");
        saalar.watchMovie();

        Movie baahubali = Movie.getMovie("Fantasy", "Baahubali");
        baahubali.watchMovie();

    }
}
