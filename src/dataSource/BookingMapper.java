
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
    private int tmp = 0;
    
    public boolean addNewBooking(ArrayList<Customers> cu, Connection conn) throws SQLException {
        int rowsInserted = 0;
        String SQLString = "insert into customers values (?,?,?,?,?,?,?,?)";
        String SQLString1 = "insert into booking values (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        PreparedStatement statement1 = null;
        statement = conn.prepareStatement(SQLString);
        statement = conn.prepareStatement(SQLString1);

        for (int i = 0; i < cu.size(); i++) {
            Customers c = cu.get(i);
            statement.setString(1, c.getFirstName());
            statement.setString(2, c.getLastName());
            statement.setString(3, c.getCountry());
            statement.setString(4, c.getEmail());
            statement.setInt(5, c.getPhone());
            statement.setInt(6, c.getReservationNumber() + 1);
            statement.setString(7, c.getAddress());
            statement.setInt(8, c.getNumberofGuests());
            
            
            rowsInserted += statement.executeUpdate();
            rowsInserted += statement1.executeUpdate();
        }
        if (testRun) {
            System.out.println("insertOrders(): " + (rowsInserted == cu.size())); // for test
        }
        return (rowsInserted == cu.size());
    }
    
    public int getNextResNumber(Connection conn) {
        int nextRes = 0;
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