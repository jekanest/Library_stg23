import java.util.Scanner;

public class LibraryStg23Main {

    public static void main(String[] args) {

        }static private void showMenu( String[] bookList) {

            // MENU
            int menuEntry;

            Scanner scanner = new Scanner(System.in);

            do {

                System.out.println("Welcome!");
                System.out.println("Please select what to do:");
                System.out.println("1 - Please enter Title");
                System.out.println("2 - Please enter Author");
                System.out.println("3 - Please enter Genre");
                System.out.println("4 - Show the list of all books ");
                System.out.println("5 - 5ook");
                System.out.println("6 - Remove a book");
                System.out.println("7 - Change availability status");
                System.out.println("8 - Show Top-3 book");
                System.out.println("9 - Show last added book");
                System.out.println("0 - EXIT MENU");

                menuEntry = scanner.nextInt();

                switch (menuEntry) {
                    case 1:
                        // retrieve from Database instead
                        libraryDb.getTitle();
                        break;
                    case 2:
                        // retrieve from Database instead
                        libraryDb.getAuthor();
                        break;
                    case 3:
                        // retrieve from Database instead
                        libraryDb.getGenre();
                        break;
                    case 4:
//                      showListOfBooks(heroList);
                        libraryDb.getBookList();
                        break;
                    case 5:
                        // Add new book to database
                        addNewBook(scanner, BookList);
                        break;
                    case 6:
                        // Remove book to database
                        removeBook(scanner, BookList);
                        break;
                    case 7:
                        // Change availability status
                        changeStatusBook(scanner, BookList);
                        break;
                    case 8:
                        top3Book(scanner, BookList);
                        break;
                    case 9:
                        lastAddedBook(scanner, BookList);
                        break;
                    default:
                        System.out.println("menu item does not exist");
                }

            } while (menuEntry != 0);
        }
    }
