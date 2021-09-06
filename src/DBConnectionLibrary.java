import java.sql.*;

public class DBConnectionLibrary {

    private Connection conn;

    public DBConnectionLibrary() {

        try {
            String dbUrl = "jdbc:sqlite:library.db";
            conn = DriverManager.getConnection(dbUrl);

            if (conn != null) {
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
                            "genre TEXT NOT NULL, " +
                            "availability TEXT NOT NULL " +
                            ")";

            statement.execute(sqlStatement);
            System.out.println("DB Books created");

        } catch (SQLException exception) {
            System.out.println("Database issues: " + exception.toString());
        }
    }

    public void getBooks(Books book) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM Books";

            ResultSet rs = statement.executeQuery(sqlStatement);

            System.out.println("Please see the List of the books in library :");

            while (rs.next()) {

                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setYear(rs.getInt("year"));
                book.setPublisher(rs.getString("publisher"));
                book.setLanguage(rs.getString("language"));
                book.setGenre(rs.getString("genre"));
                book.setAvailability(rs.getString("availability"));
                System.out.println(book.toString());
            }

        } catch (SQLException exception) {
            System.out.println("Error getting Books list: " + exception);
        }
    }

    public void createBook(Books book) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO books (" +
                    "id, title, author, year, publisher, language, genre, availability) " +
                    "VALUES ('" +
                    book.getId() + "'," +
                    "'" + book.getTitle() + "'," +
                    "'" + book.getAuthor() + "'," +
                    "'" + book.getYear() + "'," +
                    "'" + book.getPublisher() + "'," +
                    "'" + book.getLanguage() + "'," +
                    "'" + book.getGenre() + "'," +
                    "'" + book.getAvailability() + "'" +
                    ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error getting Books list: " + exception);
        }
    }

    public void removeBook(int id) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "DELETE FROM Books WHERE id ='" + id + "';";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error getting books list: " + exception);
        }
    }

    public void findBookByTitle(String title) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM Books WHERE title LIKE '%" + title + "%'";

            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                System.out.println(rs.getInt("id") +
                        " " + rs.getString("title") +
                        " " + rs.getString("author") +
                        " " + rs.getInt("year") +
                        " " + rs.getString("publisher") +
                        " " + rs.getString("language") +
                        " " + rs.getString("genre") +
                        " " + rs.getString("availability") + "");
            }

        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }

    public void findBookByAuthor(String author) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM Books WHERE author LIKE '%" + author + "%'";

            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                System.out.println(rs.getInt("id") +
                        " " + rs.getString("title") +
                        " " + rs.getString("author") +
                        " " + rs.getInt("year") +
                        " " + rs.getString("publisher") +
                        " " + rs.getString("language") +
                        " " + rs.getString("genre") +
                        " " + rs.getString("availability") + "");
            }

        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }

    public void findBookByGenre(String genre) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM Books WHERE genre LIKE '%" + genre + "%'";

            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                System.out.println(rs.getInt("id") +
                        " " + rs.getString("title") +
                        " " + rs.getString("author") +
                        " " + rs.getInt("year") +
                        " " + rs.getString("publisher") +
                        " " + rs.getString("language") +
                        " " + rs.getString("genre") +
                        " " + rs.getString("availability") + "");
            }

        } catch (SQLException exception) {
            System.out.println("Error getting list of books: " + exception);
        }
    }

    public void getBookList() {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM books ORDER by title ASC";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error getting Books list: " + exception);

        }
    }

    public void changeAvailability(String title, String availability) {

        PreparedStatement ps = null;
        conn = null;

        try {

            System.out.println("Which part of information do you want to update: ");

            Statement statement = conn.createStatement();
            String sqlStatement = "UPDATE Books " +
                    "SET availability = '" + availability + "'  WHERE title LIKE '%" + title + "%'; ";
            ps = conn.prepareStatement(sqlStatement);
            ps.setString(1, availability);
            ps.setString(2, title);
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Availability is updated");
            } else {
                System.out.println("Error Occurred");
            }

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error getting Books list: " + exception);
        }
    }
}








