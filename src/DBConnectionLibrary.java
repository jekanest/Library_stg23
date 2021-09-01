import java.sql.*;
import java.util.ArrayList;

public class DBConnectionLibrary {

    private Connection conn;

        public DBConnectionLibrary() {
            try {
                String dbUrl = "jdbc:sqlite:library.db";
                conn = DriverManager.getConnection(dbUrl);

//                if( conn != null ) {
//                    DatabaseMetaData databaseMetadata = (DatabaseMetaData) conn.getMetaData();
//                    System.out.println("Connected to " + databaseMetadata.getDatabaseProductName() + " " + databaseMetadata.getDatabaseProductVersion());

                Statement statement = conn.createStatement();
                String sqlStatement =
                        "CREATE TABLE IF NOT EXISTS Books" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "title TEXT NOT NULL, " +
                                "author TEXT NOT NULL, " +
                                "year INTEGER NOT NULL, " +
                                "publisher TEXT NOT NULL, " +
                                "language TEXT NOT NULL, " +
                                "genreId INTEGER NOT NULL, " +
                                "availability INTEGER NOT NULL) ";

                statement.execute(sqlStatement);
                System.out.println("DB created");

            } catch (SQLException exception) {
                System.out.println("Database issues: " + exception.toString());
            }

        }

    public ArrayList<Books> getBooks() {

        ArrayList<Books> bookList = new ArrayList<Books>();

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM Books";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while ( rs.next() ) {

                // Create new Hero object
                Books book = new Books();
                Books.setId( rs.getInt("id") );
                Books.setTitle( rs.getString("title"));
                Books.setAuthor( rs.getString("author"));
                Books.setYear( rs.getInt("year"));
                Books.setPublisher( rs.getString("publisher"));
                Books.setLanguage( rs.getString("language"));
                Books.setGenreId( rs.getInt("genreId"));
                Books.setAvailabilityId( rs.getInt("availability"));
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
                    "id, title, author, year, publisher, language, genreId, availability) " +
                    "VALUES (" +
                    "'" + Books.getId() + "'," +
                    "'" + Books.getTitle() + "'," +
                    "'" + Books.getAuthor() + "'," +
                    "'" + Books.getYear() + "'," +
                    "'" + Books.getPublisher() + "'," +
                    "'" + Books.getLanguage() + "'," +
                    "'" + Books.getGenreId() + "'," +
                    Books.getAvailabilityId()  +
                    ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error getting Books list: " + exception);
        }

        String sqlStatement =
                "CREATE TABLE IF NOT EXISTS Books" +
                        " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "title TEXT NOT NULL, " +
                        "author TEXT NOT NULL, " +
                        "year INTEGER NOT NULL, " +
                        "publisher TEXT NOT NULL, " +
                        "language TEXT NOT NULL, " +
                        "genreId INTEGER NOT NULL, " +
                        "availability INTEGER NOT NULL) ";

        Statement statement = conn.createStatement();
        statement.execute(sqlStatement);
        System.out.println("DB created");
    }
}
