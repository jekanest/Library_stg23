import java.util.Scanner;
import java.sql.*;

public class LibraryStg23Main {

    private static DBConnectionLibrary library;



    private String readString()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void main(String[] args) {

        library = new DBConnectionLibrary();
        //conn = DriverManager.getConnection(dbUrl);
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
                  /*  Scanner sc= new Scanner(System.in);
                    String answer = sc.next();
                    while()
                    {
                        System.out.println();
                        answer = sc.next();
                    }*/

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
                    newBook.setTitle(scanner.nextLine());

                    System.out.println("Enter book's author");
                    newBook.setAuthor(scanner.next());
                    newBook.setAuthor(scanner.nextLine());
                    System.out.println("Enter book's year");
                    newBook.setYear(scanner.nextInt());
                   // {if ("2021".matches("((19|20)\\d\\d|2021)")) {
                       // newBook.setYear(scanner.nextInt());

                   // } else {
                       // System.out.println("Valid input is not a valid year");
                 //   }}
                      boolean flag = false;
                    String yearPattern = "((19|20)\\d\\d|2021)";
                    do {

                        // System.out.print("Input a year [4 digits]: ");
                        String input = scanner.next();

                        if (!input.matches(yearPattern)) {
                            System.out.println("Invalid data!");
                        }else {
                            System.out.println("All is ok");
                        }
                        flag = input.matches(yearPattern);
                    } while (!flag);
                    System.out.println("Valid data");


                    System.out.println("Enter book's publisher");
                    newBook.setPublisher(scanner.next());
                newBook.setPublisher(scanner.nextLine());
                    System.out.println("Enter book's language");
                    newBook.setLanguage(scanner.next());
                    System.out.println("Enter book's genreId");
                    newBook.setGenreId(scanner.nextInt());
                    System.out.println("Enter book's availability");
                    newBook.setAvailabilityId(scanner.nextInt());

                    library.createBook(newBook);

                    // Add new book to database
//                addNewBook(scanner, BookList);
                    break;
                case 6:
              /*      Statement statement = conn.createStatement();
                   sqlStatement = "DELETE FROM books" +
                            " WHERE id = 0";
                    statement.execute(sqlStatement);
                    break*/
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