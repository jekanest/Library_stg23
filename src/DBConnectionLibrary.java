import java.sql.*;

public class DBConnectionLibrary {

        public DBConnectionLibrary() {
            try {
                String dbUrl = "jdbc:sqlite:library.db";
                Connection conn = DriverManager.getConnection(dbUrl);

            } catch (SQLException exception) {
                System.out.println("Database issues: " + exception.toString());
            }


        }
}
