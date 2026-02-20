import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    private static final String DB_URL = "jdbc:ucanaccess://C:/VUE_Exhibition/VUE_Exhibition.accdb;newDatabaseVersion=V2010";

    public static void main(String[] args) {
        String createTableSql = "CREATE TABLE Participants ("
                + "RegistrationID TEXT(50), "
                + "StudentName TEXT(100), "
                + "Faculty TEXT(100), "
                + "ProjectTitle TEXT(150), "
                + "ContactNumber TEXT(30), "
                + "EmailAddress TEXT(100))";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("UCanAccess driver not found. Add UCanAccess JARs to project libraries.");
            return;
        }

        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            if (!tableExists(connection, "Participants")) {
                try (Statement statement = connection.createStatement()) {
                    statement.execute(createTableSql);
                }
                System.out.println("Database and Participants table created successfully.");
            } else {
                System.out.println("Database exists. Participants table already available.");
            }
        } catch (SQLException ex) {
            System.out.println("Database setup error: " + ex.getMessage());
        }
    }

    private static boolean tableExists(Connection connection, String tableName) throws SQLException {
        return connection.getMetaData().getTables(null, null, tableName, null).next();
    }
}