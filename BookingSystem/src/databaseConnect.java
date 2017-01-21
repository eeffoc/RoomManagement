
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
    
    public void searchBookings() throws SQLException{
    
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL;
            SQL = String.format("SELECT * FROM room JOIN booking ON booking.roomID = room.id WHERE (room.projector = 0 AND room.capacity <= 21 AND (booking.date <> \"2016-11-16\" AND booking.time <> \"9:00:00\"))");
            //Need way to check if room us taken at time

            /*
                SELECT * FROM room
                JOIN bookings
                ON bookings.roomID = room.id	
                WHERE room.projector = 0
                AND room.capacity <= 20
                AND !(bookings.date = "2016-11-16" AND bookings.time = "10:00:00")
             */
            rs = stmt.executeQuery(SQL);
    }
    
   
    public void getAllBookings() throws SQLException{
        
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM booking";
        rs = stmt.executeQuery(SQL);
    }
    
    /**
     * Gets all the bookings past todays date, where user ID = current user
     * 
     * @param ID takes ID for the SQL statement
     * @throws SQLException will identify an SQL error if/when one occurs 
     */
    public void getMyBookings(String ID) throws SQLException{
        
        ID = "\"" + ID + "\"";
        
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM booking WHERE date >= CURDATE() and userID = " + ID;
        
        System.out.println(SQL);
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
