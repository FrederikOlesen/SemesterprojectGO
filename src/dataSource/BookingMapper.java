package dataSource;

import domain.Booking;
import domain.Customers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingMapper
{

    //====== Methods to save to DB =========================================================
    // Insert a list of new orders
    // returns true if all elements were inserted successfully
    static boolean testRun = false;
    private int nextRes = 0;
    private int nextCustomerID = 0;
    
    public boolean addNewBooking(ArrayList<Booking> bl, Connection conn) throws SQLException
    {
        
        int rowsInserted = 0;
        String SQLString = "insert into booking values (to_date(?,'yyyy-mm-dd'),to_date(?,'yyyy-mm-dd'),?,?,?)";
        PreparedStatement statement = null;
        statement = conn.prepareStatement(SQLString);
        //for (int i = 0; i <= bl.size(); i++)
        for (Booking b : bl)
        {
            statement.setString(1, b.getArrival());
            statement.setString(2, b.getDeparture());
            statement.setInt(3, nextRes);
            statement.setInt(4, b.getRoomNumber());
            statement.setInt(5, 1);
            rowsInserted += statement.executeUpdate();
        }
        if (testRun)
        {
            System.out.println("insertBooking(): " + (rowsInserted == bl.size())); // for test
        }
        System.out.println("bl.Size: " + bl.size());
        return (rowsInserted == bl.size());
    }

    public boolean addNewCustomer(ArrayList<Customers> cu, Connection conn) throws SQLException
    {
        System.out.println("TEST!!!!!!!!!!!!!!");
        int rowsInserted = 0;
        String SQLString = "insert into customer values (?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        statement = conn.prepareStatement(SQLString);
        for (int i = 0; i < cu.size(); i++)
        {
            Customers c = cu.get(i);
            statement.setString(1, c.getFirstName());
            statement.setString(2, c.getLastName());
            statement.setString(3, c.getCountry());
            statement.setString(4, c.getEmail());
            statement.setInt(5, c.getPhone());
            statement.setString(6, c.getAddress());
            statement.setInt(7, nextRes);
            statement.setInt(8, c.getNumberofGuests());
            rowsInserted += statement.executeUpdate();
        }

        if (testRun)
        {
            System.out.println("insertBooking(): " + (rowsInserted == cu.size())); // for test
        }
        System.out.println("cu.size " + cu.size());
        return (rowsInserted == cu.size());
    }

    public boolean updateBooking(ArrayList<Booking> bl, Connection conn) throws SQLException
    {
        int rowsUpdated = 0;
        String SQLString = "update booking "
                + "set arrival = ?, departure = ?"
                + "where reservationsnumber = ?";
        PreparedStatement statement = null;

        statement = conn.prepareStatement(SQLString);
        for (Booking b : bl)
        {
            statement.setString(1, b.getArrival());
            statement.setString(2, b.getDeparture());
            int tupleUpdated = statement.executeUpdate();
            if (tupleUpdated == 1)
            {
            }
            rowsUpdated += tupleUpdated;
        }
        if (testRun)
        {
            System.out.println("updateOrders: " + (rowsUpdated == bl.size())); // for test
        }
        return (rowsUpdated == bl.size());    // false if any conflict in version number             
    }

    public int getNextResNumber(Connection conn)
    {
        nextRes = 0;
        String SQLString = "select BOOKING_RESNUMBER_SEQ.NEXTVAL " + "from DUAL";
        PreparedStatement statement = null;
        try
        {
            statement = conn.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                nextRes = rs.getInt(1);
            }
        } catch (SQLException e)
        {
            System.out.println("Fail in BookingMapper - getNextResNumber");
            System.out.println(e.getMessage());
        }
        System.out.println(nextRes);
        return nextRes;
    }
    
     public int getNextCustomerID(Connection conn)
    {
        nextCustomerID = 0;
        String SQLString = "select CUSTOMER_CUSTOMERID_SEQ.NEXTVAL " + "from DUAL";
        PreparedStatement statement = null;
        try
        {
            statement = conn.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                nextCustomerID = rs.getInt(1);
            }
        } catch (SQLException e)
        {
            System.out.println("Fail in BookingMapper - getNextCustomerID");
            System.out.println(e.getMessage());
        }
        System.out.println(nextCustomerID);
        return nextCustomerID;
    }
}
