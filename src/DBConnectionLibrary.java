import java.sql.*;
import java.util.ArrayList;

public class DBConnectionLibrary {

    private Connection conn;

    public DBConnectionLibrary() {

        try {
            String dbUrl = "jdbc:sqlite:library.db";
            conn = DriverManager.getConnection(dbUrl);

            if( conn != null ) {
                DatabaseMetaData databaseMetadata = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Connected to " + databaseMetadata.getDatabaseProductName() + " " + databaseMetadata.getDatabaseProductVersion());
            }

            Statement statement = conn.createStatement();
            String sqlStatement =
                    "CREATE TABLE IF NOT EXISTS Books" +
                            " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "title TEXT NOT NULL, " +
                            "author TEXT NOT NULL, " +
                            "year INTEGER NOT NULL, " +
                            "publisher TEXT NOT NULL, " +
                            "language TEXT NOT NULL, " +
                            "genreId TEXT NOT NULL, " +
                            "availability INTEGER NOT NULL) ";
//                            "FOREIGN KEY(Genre_id) REFERENCES Genre(id))";

            statement.execute(sqlStatement);
            System.out.println("DB Books created");

            sqlStatement =
                    "CREATE TABLE IF NOT EXISTS Genre" +
                            " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "genre TEXT NOT NULL) ";

            statement.execute(sqlStatement);
            System.out.println("DB Genre created");

            sqlStatement =
                    "CREATE TABLE IF NOT EXISTS books_genres" +
                            " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "bookId INTEGER NOT NULL, " +
                            "genreId INTEGER NOT NULL) ";

            statement.execute(sqlStatement);
            System.out.println("DB books_genres created");

        } catch (SQLException exception) {
            System.out.println("Database issues: " + exception.toString());
        }

    } public ArrayList<Books> getBooks() {

        ArrayList<Books> bookList = new ArrayList<Books>();

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM Books";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while ( rs.next() ) {

                // Create new Hero object
                Books book = new Books();
                book.setId( rs.getInt("id") );
                book.setTitle( rs.getString("title"));
                book.setAuthor( rs.getString("author"));
                book.setYear( rs.getInt("year"));
                book.setPublisher( rs.getString("publisher"));
                book.setLanguage( rs.getString("language"));
                book.setGenreId (rs.getInt("genre"));
                book.setAvailabilityId( rs.getInt("availability"));
                System.out.println(book.toString());
            }

        } catch (SQLException exception) {
            System.out.println("Error getting Books list: " + exception);
        }

        return bookList;
    }

    public void createBook( Books book ) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO books (" +
                    "id, title, author, year, publisher, language, genre, availability) " +
                    "VALUES (" +
                    "'" + book.getId() + "'," +
                    "'" + book.getTitle() + "'," +
                    "'" + book.getAuthor() + "'," +
                    "'" + book.getYear() + "'," +
                    "'" + book.getPublisher() + "'," +
                    "'" + book.getLanguage() + "'," +
                    "'" + book.getGenreId() + "'," +
                    book.getAvailabilityId()  +
                    ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error getting Books list: " + exception);
        }


    }
}