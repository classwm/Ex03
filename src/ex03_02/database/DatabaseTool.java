package ex03_02.database;

import ex03_02.account.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;

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

        PreparedStatement prepExam = connection.prepareStatement("select "
                + FIRST_NAME_COLUMN + ", " + LAST_NAME_COLUMN + ", " + CAPITAL_COLUMN
                + " from " + ACCOUNTS_TABLE + ";");
        ResultSet rs = prepExam.executeQuery();

        String accountName = "Konto z pliku"; // prypisanie wartości do accountName, aktualnie nie zachowywanego w pliku SQLite
        while (rs.next()) { // if zmienione na while
            String firstName = rs.getString(FIRST_NAME_COLUMN);
            String lastName = rs.getString(LAST_NAME_COLUMN);
            float capital = rs.getFloat(CAPITAL_COLUMN);
            accountList.add(new fileAccount(accountName, firstName, lastName, capital)); // przypisanie odczytanych z pliku wartości do konta dodanego do listy
            // System.out.println(firstName + " " + lastName + ": " + capital);
        }

        rs.close();

        closeConnection();

        return accountList.toArray(new Account[]{});
    } // getAccounts

    /**
     * Zachowanie kont do pliku SQLite, w aktualnym formacie pliku (bez pola
     * accountName).
     *
     * @param listOfAccounts lista kont do zachowania
     * @throws SQLException
     */
    public static void saveAccounts(Set<Account> listOfAccounts) throws SQLException {

        String firstName;
        String lastName;
        float capital;
        String saveAccount;

        openConnection();

        for (Account acc : listOfAccounts) {
            if (!acc.getAccountName().equals("Konto z pliku")) { // sprawdzenie, czy konto zostało odczytane z pliku

                firstName = acc.getFirstName();
                lastName = acc.getLastName();
                capital = acc.getCapital();

                saveAccount = ("insert into " + ACCOUNTS_TABLE + " ('"
                        + FIRST_NAME_COLUMN + "', '" + LAST_NAME_COLUMN + "', '" + CAPITAL_COLUMN
                        + "')" + " values ('" + firstName + "', '" + lastName + "', " + capital + ")" + ";");

                Statement insertAccount = connection.createStatement();
                try {
                    insertAccount.executeUpdate(saveAccount);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                insertAccount.close();
            }
        }
        closeConnection();
    } // saveAccounts

    public static void main(String[] args) throws SQLException {
        getAccounts();
    }
} // DatabaseTool