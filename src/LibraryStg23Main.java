import java.util.Scanner;
import java.sql.*;

public class LibraryStg23Main {
    private static DBConnectionLibrary library;

    public static void main(String[] args) {

        library = new DBConnectionLibrary();

        String[] BooksList = {};
        showMenu(BooksList);

    }

    static private void showMenu( String[] BooksList) {

        int menuEntry;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Welcome!");
            System.out.println("Please select what to do:");// OK
            System.out.println("1 - Search book by Title");//OK
            System.out.println("2 - Search book by Author");//OK
            System.out.println("3 - Search book by Genre");// vai vajag?
            System.out.println("4 - Show the list of all books in the library"); //OK
            System.out.println("5 - Add new Book"); // OK
            System.out.println("6 - Remove a book"); // OK
            System.out.println("7 - Change availability status");//ok
            System.out.println("0 - EXIT MENU"); //OK

            Books book = new Books();
            menuEntry = scanner.nextInt();
            scanner.nextLine();

            switch (menuEntry){
                case 1:
                    System.out.println("Please enter book's title");
                    book.setTitle(scanner.next());

                    library.findBookByTitle(book.getTitle());
                    break;
                case 2:
                    System.out.println("Please enter an author name");
                    book.setAuthor(scanner.next());

                    library.findBookByAuthor(book.getAuthor());
                    break;
                case 3:
                    System.out.println("Please enter a genre");
                    book.setGenre(scanner.next());

                    library.findBookByGenre(book.getGenre());
                    break;
                case 4:
                    Books allBooks = new Books();

                    library.getBooks(allBooks);
                    break;
                case 5:
                    Books newBook = new Books();
                    System.out.println("Enter book's Id");
                    newBook.setId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter book's title");
                    newBook.setTitle(scanner.nextLine());
                    System.out.println("Enter book's author");
                    newBook.setAuthor(scanner.nextLine());
                    System.out.println("Enter book's year");

                    boolean flag = false;
                    String yearPattern = "((19|20)\\d\\d|2021)";
                    do {
                        String input = scanner.nextLine();
                        flag = input.matches(yearPattern);
                        if (!flag) {
                            System.out.println("Invalid data!");
                        }else {
                            newBook.setYear(Integer.parseInt(input));
                        }
                    } while (!flag);
                    System.out.println("Enter book's publisher");
                    newBook.setPublisher(scanner.nextLine());
                    System.out.println("Enter book's language");
                    newBook.setLanguage(scanner.nextLine());
                    System.out.println("Enter book's genreId");
                    newBook.setGenre(scanner.nextLine());
                    System.out.println("Enter book's availability");
                    newBook.setAvailability(scanner.nextLine());

                    library.createBook(newBook);
                    System.out.println("Book is added successfully");
                    break;
                case 6:
                    System.out.println("Please enter book's Id to remove");
                    library.removeBook(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Book is removed successfully");
                    break;
                case 7:
                    System.out.println("Please enter book's title to change availability status");
                    String title = scanner.nextLine();
                    System.out.println("Please enter availability status");
                    String state = scanner.nextLine();

                    library.changeAvailability(title, state);

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
