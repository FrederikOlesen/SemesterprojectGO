package dataSource;

import domain.Booking;
import domain.Customer;
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
    private int nextRes;
    private int nextCustomerID;
    Customer c;
    Booking b;

    public boolean addNewBooking(ArrayList<Booking> bl, Connection conn) throws SQLException {
        System.out.println("In addNewBooking");
        int rowsInserted = 0;
        String SQLString = "insert into booking values (to_date(?,'yyyy-mm-dd'),to_date(?,'yyyy-mm-dd'),?,?,?,?,?)";
        PreparedStatement statement = null;
        statement = conn.prepareStatement(SQLString);
        for (int i = 0; i < bl.size(); i++) {
            b = bl.get(i);
            statement.setString(1, b.getArrival());
            statement.setString(2, b.getDeparture());
            statement.setInt(3, b.getResNumber());
            statement.setInt(4, b.getRoomNumber());
            statement.setInt(5, 1);
            statement.setInt(6, nextCustomerID);
            statement.setInt(7, b.getNumberOfGuests());

            rowsInserted += statement.executeUpdate();
        }
        if (testRun) {
            System.out.println("insertBooking(): " + (rowsInserted == bl.size())); // for test
        }
        return (rowsInserted == bl.size());
    }

    public boolean addNewCustomer(ArrayList<Customer> cu, Connection conn) throws SQLException {
        int rowsInserted = 0;
        String SQLString = "insert into customer values (?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        statement = conn.prepareStatement(SQLString);
        for (int i = 0; i < cu.size(); i++) {
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

        if (testRun) {
            System.out.println("insertBooking(): " + (rowsInserted == cu.size())); // for test
        }

        return (rowsInserted == cu.size());

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
        } catch (SQLException e) {
            System.out.println("Fail in BookingMapper - getNextResNumber");
            System.out.println(e.getMessage());
        }
        return nextRes;
    }

    public int getNextCustomerID(Connection conn) {
        System.out.println("Enter getNextCustomerID in BM");
        nextCustomerID = 0;
        String SQLString = "select SEQ_CUSTOMERID.NEXTVAL " + "from DUAL";
        PreparedStatement statement = null;
        try {

            statement = conn.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                nextCustomerID = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Fail in BookingMapper - getNextCustomerID");
            System.out.println(e.getMessage());
        }
        return nextCustomerID;

    }

    public Customer getCustomer(String lname, Connection conn) {
        Customer c = null;
        String SQLString1 = // get order
                "select * "
                + "from customer "
                + "where lname like '?%'";

        PreparedStatement statement = null;

        try {
            //=== get order
            statement = conn.prepareStatement(SQLString1);
            statement.setString(1, c.getLastName());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                c = new Customer(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println("Fail in BookingMapper - getOrder");
            System.out.println(e.getMessage());
        }
        if (testRun) {
            System.out.println("Retrieved Order: " + c);
        }
        return c;
    }
}
