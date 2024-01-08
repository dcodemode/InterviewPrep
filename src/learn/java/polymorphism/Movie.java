package learn.java.polymorphism;

public class Movie {

    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void watchMovie(){
        System.out.println(title + " is a " + this.getClass().getSimpleName() + " film");
    }

    public static Movie getMovie(String type, String title){
        if(type.equalsIgnoreCase("ACTION")){
            return new Action(title);
        }else if(type.equalsIgnoreCase("FANTASY")){
            return new Fantasy(title);
        }else{
            return  new Movie(title);
        }
    }
}
