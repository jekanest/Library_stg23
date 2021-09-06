import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Books {

    private static DBConnectionLibrary library;

    private int Id, year;
    private String title, author, language, publisher, genre, availability;

    public Books() {
    }

    public Books(int id, int year, String title, String author, String language, String publisher, String genre, String availability) {
        this.Id = id;
        this.year = year;
        this.title = title;
        this.author = author;
        this.language = language;
        this.publisher = publisher;
        this.genre = genre;
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Books{" +
                "Id=" + Id +
                ", year=" + year +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", language='" + language + '\'' +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }

    public static DBConnectionLibrary getLibrary() {
        return library;
    }

    public static void setLibrary(DBConnectionLibrary library) {
        Books.library = library;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}





