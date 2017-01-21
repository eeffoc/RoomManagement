
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Christopher
 */
public class databaseConnect {

    String host;
    String uName;
    String uPass;
    Connection con;
    Statement stmt;
    ResultSet rs;

    /**
     * This class will handle all the database SQL queries and connections
     * 
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public databaseConnect() throws SQLException {

        host = "jdbc:mysql://localhost/bookingsystem";
        uName = "root";
        uPass = "";
        con = DriverManager.getConnection(host, uName, uPass);

    }

    /**
     * Gets all rooms on the database
     * 
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public void getRooms() throws SQLException{
        
        //Runs SQL statement on the database
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM room";
        rs = stmt.executeQuery(SQL);
        //This will access the table
        
    }
    
    /**
     * Gets all the bookings past todays date, where user ID = current user
     * 
     * @param ID takes ID for the SQL statement
     * @throws SQLException will identify an SQL error if/when one occurs 
     */
    public void searchBookings(int ID) throws SQLException{
        
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM booking WHERE date >= CURDATE() and userID = " + ID;
        rs = stmt.executeQuery(SQL);
        
    }
    
    /**
     * Gets all users from the user table
     * 
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public void getUsers() throws SQLException {

        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM user";
        rs = stmt.executeQuery(SQL);
        //This will access the table

        
    }

    /**
     * Finds the ID for a new user entry
     * 
     * @return the ID that where the user will be saved
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public int newUser() throws SQLException {

        getUsers();

        int ID = 1;

        try {
            rs.last();
            ID = rs.getInt("ID") + 1;
        } catch (SQLException ex) {
        }
        
        return ID;

    }

    /**
     *  Gets the current result set from the SQL query
     * 
     * @return returns the result set from a query
     */
    public ResultSet getRS() {

        return rs;

    }

    /**
     * Closes the current connection
     * 
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public void closeConnection() throws SQLException {

        stmt.close();
        rs.close();

    }

}
