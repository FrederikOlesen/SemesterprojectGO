package dataSource;

import domain.Booking;
import domain.Customers;
import java.sql.Connection;
import java.sql.Date;
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

    public boolean addNewBooking(ArrayList<Booking> bl, Connection conn) throws SQLException
    {
        ArrayList<Customers> cu = new ArrayList<Customers>();
        int rowsInserted = 0;
        int rowsInserted1 = 0; 
        String SQLString1 = "insert into customers values (?,?,?,?,?,?,?,?)";
        String SQLString = "insert into booking values (to_date(?,'yyyy-mm-dd'),to_date(?,'yyyy-mm-dd'),?,?,?)";
        PreparedStatement statement = null;
        PreparedStatement statement1 = null;
        statement = conn.prepareStatement(SQLString);
        statement1 = conn.prepareStatement(SQLString1);

        for (int i = 0; i < cu.size(); i++)
        {
            Customers c = cu.get(i);
            statement1.setString(1, c.getFirstName());
            statement1.setString(2, c.getLastName());
            statement1.setString(3, c.getCountry());
            statement1.setString(4, c.getEmail());
            statement1.setInt(5, c.getPhone());
            statement1.setString(6, c.getAddress());
            statement1.setInt(7, nextRes);
            statement1.setInt(8, c.getNumberofGuests());

//            statement1.setString(1, "bob");
//            statement1.setString(2, "palle");
//            statement1.setString(3, "pallestan");
//            statement1.setString(4, "palle@palle.dk");
//            statement1.setInt(5, 88888888);
//            statement1.setInt(6, nextRes);
//            statement1.setString(7, "Pallevej 32");
//            statement1.setInt(8, 1);
//
            rowsInserted1 += statement1.executeUpdate();
//
        }

        for (int j = 0; j < bl.size(); j++)
        {
            Booking b = bl.get(j);
//            statement.setString(1, b.getArrival());
//            statement.setString(2, b.getDeparture());
//            statement.setInt(3, nextRes);
//            statement.setInt(4, b.getRoomNumber());
//            statement.setInt(5, b.getPayment());
            statement.setString(1, "2014-05-10");
            statement.setString(2, "2014-05-10");
            statement.setInt(3, 10);
            statement.setInt(4, 1);
            statement.setInt(5, 1);
            rowsInserted += statement.executeUpdate();
        }
        if (testRun)
        {
            System.out.println("insertBooking(): " + (rowsInserted == cu.size() && rowsInserted == bl.size())); // for test
        }
        System.out.println("cu.size " + cu.size() + "bl.Size " + bl.size());
        return (rowsInserted1 == cu.size() && rowsInserted == bl.size());
    }

    public boolean updateBooking(ArrayList<Booking> bl, Connection conn) throws SQLException
    {
        int rowsUpdated = 0;
        String SQLString = "update booking "
                + "set arrival = ?, departure = ?"
                + "where reservationsnumber = ?";
        PreparedStatement statement = null;

        statement = conn.prepareStatement(SQLString);
        for (int i = 0; i < bl.size(); i++)
        {
            Booking b = bl.get(i);
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
        } catch (Exception e)
        {
            System.out.println("Fail in BookingMapper - getNextResNumber");
            System.out.println(e.getMessage());
        }
        System.out.println(nextRes);
        return nextRes;
    }
}
