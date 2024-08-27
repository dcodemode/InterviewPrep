package learn.algo.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Book{
    public String title;
    public String author;
    public boolean available;

    public Book(String title, String author, boolean available){
        this.title = title;
        this.author = author;
        this.available = available;
    }
}

interface Library{
    public List<Book> getBooks();
    public void borrowBook(String user, Book book);
    public void returnBook(String user, Book book);
}

public class LibraryManagementSystem implements Library {
    private int size;
    private Map<String, Integer> map = new HashMap<>();
    private List<Book> books = new ArrayList<>();

    public LibraryManagementSystem(int size) {
        this.size = size;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void borrowBook(String user, Book book) {
        int userCount = map.getOrDefault(user, 0);
        if (userCount < this.size) {
            if (book.available) {
                map.put(user, userCount + 1);
                book.available = false;
                System.out.println(user + " borrowed " +book.title);
            } else {
                System.out.println(user + " can't borrow " + book.title + ", since it is already borrowed");
            }
        } else {
            System.out.println(user + " can't borrow " + book.title + ". User limit hit");
        }
    }

    public void returnBook(String user, Book book) {
        if(!book.available){
            System.out.println(user + " returned " + book.title);
            map.put(user, map.getOrDefault(user, 1) - 1);
            book.available = true;
        }else{
            System.out.println(user + " can't return " + book.title + ", since he doesn't have it");
        }
    }

    public List<Book> getBooks(){
        return books;
    }

    public static void main(String[] args) {

        LibraryManagementSystem lms = new LibraryManagementSystem(3);
        Book book1 = new Book("Mickey Mouse", "Disney", true);
        lms.addBook(book1);

        Book book2 = new Book("Pluto", "Disney", true);
        lms.addBook(book2);

        Book book3 = new Book("Ironman", "Marvel", true);
        lms.addBook(book3);

        Book book4 = new Book("Antman", "Marvel", true);
        lms.addBook(book4);

        Book book5 = new Book("Avengers", "Marvel", true);
        lms.addBook(book5);

        Book book6 = new Book("Minnie Mouse", "Disney", true);
        lms.addBook(book6);

        lms.borrowBook("Dhanu", book6);
        lms.borrowBook("Swetha", book6);
        lms.borrowBook("Dhanu", book5);
        lms.borrowBook("Dhanu", book4);
        lms.borrowBook("Dhanu", book3);
        lms.returnBook("Dhanu", book6);
        lms.borrowBook("Dhanu", book3);
    }
}
