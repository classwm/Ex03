package ex03_02.database;

import ex03_02.account.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseTool {

    public static String DATABASE_FILE_PATH = "jdbc:sqlite:src/ex03_02/database/accounts.sqlite";

    public static String ACCOUNTS_TABLE = "accounts";
    public static String FIRST_NAME_COLUMN = "firstName";
    public static String LAST_NAME_COLUMN = "lastName";
    public static String CAPITAL_COLUMN = "capital";
    
    public static Connection connection;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            // IT'S WRONG, BUT LEAVE IT
        }
    }

    private static void openConnection() {
        try {
            connection = DriverManager.getConnection(DATABASE_FILE_PATH);
        } catch (SQLException ex) {
            // IT'S WRONG, BUT LEAVE IT
        }
    }

    private static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            // IT'S WRONG, BUT LEAVE IT
        }
    }

    public static Account[] getAccounts() throws SQLException {
        ArrayList<Account> accountList = new ArrayList<Account>();

        openConnection();

        PreparedStatement prepExam = connection.prepareStatement("select " +
                FIRST_NAME_COLUMN + ", " + LAST_NAME_COLUMN + ", " + CAPITAL_COLUMN +
                " from " + ACCOUNTS_TABLE + ";");
        ResultSet rs = prepExam.executeQuery();
        if (rs.next()) {
            String firstName = rs.getString(FIRST_NAME_COLUMN);
            String lastName = rs.getString(LAST_NAME_COLUMN);
            float capital = rs.getFloat(CAPITAL_COLUMN);
            
            System.out.println(firstName + ";" + lastName + ";" + capital);
        }
        rs.close();

        closeConnection();

        return accountList.toArray(new Account[]{});
    }
    
    public static void main(String[] args) throws SQLException {
        getAccounts();
    }
}
