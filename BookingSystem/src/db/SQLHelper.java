package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static org.apache.commons.dbutils.DbUtils.*;

/**
 * 
 * @author Christopher, Markus
 */
public class SQLHelper {

    private final static String DB_URL = "jdbc:mysql://213.104.129.95:3306/roomBooking";
    private final static String DB_USERNAME = "root";
    private final static String DB_PASSWORD = "root";
    Connection conn;
    Statement stmt;
    ResultSet rs;

    /**
     * This class will handle all the database SQL queries between the database and the system,
     * holding how to connect onto the database
     * 
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public SQLHelper(){

    }

    public String[] authoriseLoginCredentials(String enteredUsername, String enteredPassword){
        //Please God forgive me for handling password as plain text
        //This isn't my choice but how the db is currently set up
        //TODO: Fix me ASAP
        
        String[] usernameAccess = new String[2];
        //pos 0 = access level ("edit_authorisation")
        //pos 1 = username ("ID")
        
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            
            if(enteredUsername.equals("") || enteredPassword.equals("")) { 
                usernameAccess[0] = "error";
            } else {
                String sql="SELECT ID,password,edit_authorisation FROM user where ID=? and password=?";
                PreparedStatement ps=conn.prepareStatement(sql);
                
                ps.setString(1,enteredUsername);
                ps.setString(2,enteredPassword);
                
                rs = ps.executeQuery();
                if(rs.next()){
                    usernameAccess[0] = rs.getString("edit_authorisation");
                    usernameAccess[1] = rs.getString("ID");
                } else {
                    usernameAccess[0] = "error";
                }
            }
        } catch (SQLException e){

        } finally {
            closeQuietly(conn, stmt, rs);
        }
        return usernameAccess;
    }
    
    /**
     * Gets all rooms on the database from table room, and stores them as a resultset
     * 
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public void getRooms(){
        
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            
            //Runs SQL statement on the database
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM room";
            rs = stmt.executeQuery(SQL);
            //This will access the table
        } catch (SQLException e){

        } finally {
            closeQuietly(conn, stmt, rs);
        }
    }
    
    /**
     * gets all bookings which match the entered fields into the bookings form
     * 
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public void searchBookings(){
    
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
        } catch (SQLException e){

        } finally {
            closeQuietly(conn, stmt, rs);
        }
            
    }
    
   /**
    * Will select all bookings from table booking, and store this as a resultset
    * 
    * @throws SQLException will identify an SQL error if/when one occurs
    */
    public void getAllBookings(){
        
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM booking";
            rs = stmt.executeQuery(SQL);
        } catch (SQLException e){

        } finally {
            closeQuietly(conn, stmt, rs);
        }
    }
    
    /**
     * Gets all the bookings past todays date, where user ID = current user, and 
     * stores this as a result set
     * 
     * @param ID takes ID for the SQL statement
     * @throws SQLException will identify an SQL error if/when one occurs 
     */
    public void getMyBookings(String ID) throws SQLException{
        
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            
            ID = "\"" + ID + "\"";
        
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM booking WHERE date >= CURDATE() and userID = " + ID;
        
            rs = stmt.executeQuery(SQL);
        } catch (SQLException e){

        } finally {
            closeQuietly(conn, stmt, rs);
        } 
    }
    
    /**
     * Gets all users from the user table and stores this as a result set
     * 
     * @throws SQLException will identify an SQL error if/when one occurs
     */
    public void getUsers() throws SQLException {

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM user";
        rs = stmt.executeQuery(SQL);
        //This will access the table
        } catch (SQLException e){

        } finally {
            closeQuietly(conn, stmt, rs);
        }
    }
    
    /**
     * Checks if username is unique
     * 
     * @param enteredUsername holds the unique username of the user
     * @return returns true if username is unique
     */
    public boolean usernameUnique(String enteredUsername) {

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String sql = "SELECT * FROM user where ID = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,enteredUsername);

            rs = ps.executeQuery();

            return !rs.next();

        } catch (SQLException e) {

        } finally {
            closeQuietly(conn, stmt, rs);
        }
        return false;
    }
   
    public void addNewUserToDB(String[] userData) throws SQLException{
        //userData values
        //pos 0 = First Name
        //pos 1 = Last Name
        //pos 2 = Username (unique)
        //pos 3 = Password
        //pos 4 = Authorisation Level
        
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query = "INSERT into user (ID, first_name, second_name, password, edit_authorisation)" 
                    + " values (?, ?, ?, ?, ?)"; 

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString (1, userData[0]);
            ps.setString (2, userData[1]);
            ps.setString (3, userData[2]);
            ps.setString (4, userData[3]);
            ps.setString (5, userData[4]); 

            ps.execute();

        } catch (SQLException e) {

        } finally {
            closeQuietly(conn, stmt, rs);
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
