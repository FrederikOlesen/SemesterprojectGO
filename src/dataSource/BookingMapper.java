
package dataSource;

import domain.Booking;
import domain.Customers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingMapper {
     //====== Methods to save to DB =========================================================
    // Insert a list of new orders
    // returns true if all elements were inserted successfully
    
    static boolean testRun = false;
    private int nextRes = 0;
    
    public boolean addNewBooking(ArrayList<Customers> cu, ArrayList<Booking> bl, Connection conn) throws SQLException {
        int rowsInserted = 0;
        String SQLString = "insert into customers values (?,?,?,?,?,?,?,?)";
        String SQLString1 = "insert into booking values (?,?,?,?,?)";
        PreparedStatement statement = null;
        PreparedStatement statement1 = null;
        statement = conn.prepareStatement(SQLString);
        statement1 = conn.prepareStatement(SQLString1);

        for (int i = 0; i < cu.size(); i++) {
            Customers c = cu.get(i);
            statement.setString(1, c.getFirstName());
            statement.setString(2, c.getLastName());
            statement.setString(3, c.getCountry());
            statement.setString(4, c.getEmail());
            statement.setInt(5, c.getPhone());
            statement.setInt(6, nextRes);
            statement.setString(7, c.getAddress());
            statement.setInt(8, c.getNumberofGuests());
            
            
            rowsInserted += statement.executeUpdate();
        }
        
         for (int j = 0; j < bl.size(); j++)
         {
             Booking b = bl.get(j);
             statement1.setDate(1, b.getArrival());
             statement1.setDate(2, b.getDeparture());
             statement1.setInt(3, b.getResNumber());
             statement1.setInt(4, b.getRoomNumber());
             statement1.setInt(5, b.getPayment());
             
             rowsInserted += statement1.executeUpdate();
         }
        if (testRun) {
            System.out.println("insertBooking(): " + (rowsInserted == cu.size() && rowsInserted == bl.size())); // for test
        }
        return (rowsInserted == cu.size() && rowsInserted == bl.size());
    }
    
    public boolean updateBooking(ArrayList<Booking> bl, Connection conn) throws SQLException {
        int rowsUpdated = 0;
        String SQLString = "update booking "
                + "set arrival = ?, departure = ?"
                + "where reservationsnumber = ?";
        PreparedStatement statement = null;

        statement = conn.prepareStatement(SQLString);
        for (int i = 0; i < bl.size(); i++) {
            Booking b = bl.get(i);
            statement.setDate(1, b.getArrival());
            statement.setDate(2, b.getDeparture());
            int tupleUpdated = statement.executeUpdate();
            if (tupleUpdated == 1) {
            }
            rowsUpdated += tupleUpdated;
        }
        if (testRun) {
            System.out.println("updateOrders: " + (rowsUpdated == bl.size())); // for test
        }
        return (rowsUpdated == bl.size());    // false if any conflict in version number             
    }
    
    
    public int getNextResNumber(Connection conn) {
        nextRes = 0;
        String SQLString = "select BOOKING_RESNUMBER_SEQ.NEXTVAL " + "from DUAL";
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                nextRes = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Fail in BookingMapper - getNextResNumber");
            System.out.println(e.getMessage());
        }
        System.out.println(nextRes);
        return nextRes;
    }
}