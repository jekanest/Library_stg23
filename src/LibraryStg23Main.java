import java.util.Scanner;
import java.sql.*;

public class LibraryStg23Main {

    private static DBConnectionLibrary library;

    public static void main(String[] args) {

        library = new DBConnectionLibrary();
//    }
//
//    // MENU
//    static private void showMenu(String[] bookList) {
        int menuEntry;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Welcome!");
            System.out.println("Please select what to do:");
            System.out.println("1 - Please enter Title");
            System.out.println("2 - Please enter Author");
            System.out.println("3 - Please enter Genre");
            System.out.println("4 - Show the list of all books ");
            System.out.println("5 - Add new Book");
            System.out.println("6 - Remove a book");
            System.out.println("7 - Change availability status");
            System.out.println("8 - Show Top-3 book");
            System.out.println("9 - Show last added book");
            System.out.println("0 - EXIT MENU");

            menuEntry = scanner.nextInt();

            switch (menuEntry) {
                case 1:
                    // retrieve from Database instead
                   // library.getTitle();
                    break;
                case 2:
                    // retrieve from Database instead
//                library.getAuthor();
                 //   System.out.println();
                    break;

                case 3:
                    // retrieve from Database instead
//                library.getGenre();
                    break;
                case 4:
//                      showListOfBooks(heroList);
//                library.getBookList();
                    break;
                case 5:

                    Books newBook = new Books();
                    System.out.println("Enter book's title");
                    newBook.setTitle(scanner.next());
                    System.out.println("Enter book's author");
                    newBook.setAuthor(scanner.next());
                    System.out.println("Enter book's year");
                    newBook.setYear(scanner.nextInt());
                    System.out.println("Enter book's publisher");
                    newBook.setPublisher(scanner.next());
                    System.out.println("Enter book's language");
                    newBook.setLanguage(scanner.next());
                    System.out.println("Enter book's genre");
                    newBook.setGenreId(scanner.nextInt());
                    System.out.println("Enter book's availability");
                    newBook.setAvailabilityId(scanner.nextInt());

                    library.createBook(newBook);

                    // Add new book to database
//                addNewBook(scanner, BookList);
                    break;
                case 6:
                    // Remove book to database
//                removeBook(scanner, BookList);
                    break;
                case 7:
                    // Change availability status
//                changeStatusBook(scanner, BookList);
                    break;
                case 8:
//                top3Book(scanner, BookList);
                    break;
                case 9:
//                lastAddedBook(scanner, BookList);
                    break;
                case 0:
                    System.out.println("EXIT MENU!");
                    break;
                default:
                    System.out.println("MENU item does not exist");
            }

        } while (menuEntry != 0);
    }
}