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
    private int nextRes;
    private int nextCustomerID;
    Customers c;
    Booking b;

    public boolean addNewBooking(ArrayList<Booking> bl, Connection conn) throws SQLException
    {
        System.out.println("Entered addNewBooking");
        int rowsInserted = 0;
        String SQLString = "insert into booking values (to_date(?,'yyyy-mm-dd'),to_date(?,'yyyy-mm-dd'),?,?,?,?,?)";
        PreparedStatement statement = null;
        statement = conn.prepareStatement(SQLString);
        for (int i = 0; i < bl.size(); i++)
        {
            b = bl.get(i);
            statement.setString(1, b.getArrival());
            statement.setString(2, b.getDeparture());
            statement.setInt(3, nextRes);
            System.out.println("BM nextRes " + b.getResNumber());

            System.out.println("TEST");
            statement.setInt(4, b.getRoomNumber());

            System.out.println("TEST12312");
            statement.setInt(5, 1);

            statement.setInt(6, nextCustomerID);
            statement.setInt(7, b.getNumberOfGuests());
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
        System.out.println("Entered AddNewCustomer ");
        int rowsInserted = 0;
        String SQLString = "insert into customer values (?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        statement = conn.prepareStatement(SQLString);
        for (int i = 0; i < cu.size(); i++)
        {
            c = cu.get(i);
            statement.setInt(1, c.getCustomerID());
            statement.setString(2, c.getFirstName());
            statement.setString(3, c.getLastName());
            statement.setString(4, c.getCountry());
            statement.setString(5, c.getEmail());
            statement.setInt(6, c.getPhone());
            statement.setString(7, c.getAddress());
            rowsInserted += statement.executeUpdate();
        }

        if (testRun)
        {
            System.out.println("insertBooking(): " + (rowsInserted == cu.size())); // for test
        }
        System.out.println("cu.size " + cu.size());

        return (rowsInserted == cu.size());

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
        System.out.println("nextRes from sequence "+nextRes);
        return nextRes;
    }

    public int getNextCustomerID(Connection conn)
    {
        nextCustomerID = 0;
        String SQLString = "select SEQ_CUSTOMERID.NEXTVAL " + "from DUAL";
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
        return nextCustomerID;
    }
}
