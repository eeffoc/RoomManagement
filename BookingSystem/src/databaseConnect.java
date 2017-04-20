
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

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
     * This class will handle all the database SQL queries between the database
     * and the system, holding how to connect onto the database
     * 
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public databaseConnect() throws SQLException {
            
        
        host = "jdbc:mysql://213.104.129.95:3306/roomBooking";
        //192.168.0.35/
        //213.104.129.95:3306
        uName = "TLL";
        //pi
        //root
        uPass = "triggered";
        //raspberry
        //AppleBees1121@@@
        
        con = DriverManager.getConnection(host, uName, uPass);
    }

    /**
     * Gets all rooms on the database from table room, and stores them as a resultset
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
     * gets all bookings which match the entered fields into the bookings form
     * 
     * @param capacity minimum room size
     * @param projector is a projector required
     * @param time time room is needed
     * @param date date room is needed
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public void searchBookings(int capacity, boolean projector, String time, String date) throws SQLException{
    
        boolean boolProjector = projector;
        int roomCap = capacity;
        String bookTime = "\"" + time + "\"";
        String bookDate =  "\"" + date + "\"";
        
        
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL;
            SQL = String.format("SELECT * FROM room JOIN booking ON booking.roomID = room.id WHERE (room.projector = " + boolProjector + " AND room.capacity >= " + roomCap + " AND (booking.date <> " + bookDate + " AND booking.time <> " + bookTime + "))");
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
    
    /**
     *
     * @param bookID holds bookingID which is current being searched for
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public void getSpecificBooking(int bookID) throws SQLException{
        
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM booking where ID = " + bookID;
        rs = stmt.executeQuery(SQL);

    }
    
   /**
    * Will select all bookings from table booking, and store this as a resultset
    * 
    * @throws SQLException will identify an SQL error if/when one occurs
    */
    public void getAllBookings() throws SQLException{
        
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM booking";
        rs = stmt.executeQuery(SQL);
    }
    
    /**
     * Gets all the bookings past todays date, where user ID = current user, and 
     * stores this as a result set
     * 
     * @param ID takes ID for the SQL statement
     * @throws SQLException will identify an SQL error if/when one occurs 
     */
    public void getMyBookings(String ID) throws SQLException{
        
        ID = "\"" + ID + "\"";
        
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM booking join room on booking.roomID = room.id WHERE date >= CURDATE() and userID = " + ID;
        
        rs = stmt.executeQuery(SQL);
        
    }
    
    /**
     * Gets all users from the user table and stores this as a result set
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
     * takes a user ID, converting it to a SQL string format, which is then used
     * in a query to ensure that it is unique
     * 
     * @param ID holds the unique ID of the user
     * @return returns if the ID is unique
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public boolean validateUser(String ID) throws SQLException{
        
        ID = "\"" + ID + "\"";
        
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM user where id = " + ID;
        rs = stmt.executeQuery(SQL);
        
        int count = 0;
        
        while (rs.next()){
            
            count +=1;
            
        }
        
        if (count == 0){
            return true;
        }
        else{
            return false;
        }
    }
   
    /**
     *  Gets the current resultset stored on the class
     * 
     * @return returns the result set from a query
     */
    public ResultSet getRS() {

        return rs;

    }

    /**
     * Closes the current connection to the database
     * 
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public void closeConnection() throws SQLException {

        stmt.close();
        rs.close();

    }

}
