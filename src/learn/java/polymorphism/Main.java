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

        // Introduced in Java 10, Type inference is used in var keyword in which it detects automatically
        // the datatype of a variable based on the surrounding context
        var kgf = Movie.getMovie("Action", "KGF");
        kgf.watchMovie();

    }
}
