package dataSource;

import domain.Booking;
import domain.Customer;
import domain.Rooms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingMapper {

    // Variables used in class
    static boolean testRun = false;
    private int nextRes;
    private int nextCustomerID;
    // Objects used in class
    Customer c;
    Booking b;
    Rooms r;

    // Method for writing booking to database. Returns 1 / true 
    public boolean addNewBooking(ArrayList<Booking> bl, Connection conn) throws SQLException {
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
            statement.setInt(6, b.getCustomerID());
            statement.setInt(7, b.getNumberOfGuests());

            rowsInserted += statement.executeUpdate();
        }
        if (testRun) {
            System.out.println("insertBooking(): " + (rowsInserted == bl.size())); // for test
        }
        return (rowsInserted == bl.size());
    }

    // Method for writing customer to database. Returns 1 / true
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

    // Method to get next reservation number from database
    // Sequencer on database counts up for each request
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

    public Booking findResNumber(int resNo, Connection conn) {
        Booking b = null;
        String SQLString = // find Reservationsnumber
                "select to_char(arrival, 'yyyy-mm-dd'), to_char(departure, 'yyyy-mm-dd'),"
                + " reservationsnumber, roomnumber, paid, customerID, numberOfGuests from booking "
                + "where reservationsnumber = ?";

        PreparedStatement statement = null;

        try {
            //=== get Customer
            statement = conn.prepareStatement(SQLString);
            statement.setInt(1, resNo);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                b = new Booking(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7));

            }
        } catch (Exception e) {
            System.out.println("Fail in BookingMapper - findResNo");
            System.out.println(e.getMessage());
        }
        if (testRun) {
            System.out.println("Retrieved resNo: ");
        }
        return b;
    }

// Method to get next Customer ID from database
// sequencer on database counts up for each request
    public int getNextCustomerID(Connection conn) {
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

    // Method to get data on customers with lname starting with ? 
    public ArrayList getCustomer(String lname, Connection conn) {
        ArrayList customerList = new ArrayList();
        Customer c = null;
        String SQLString = // get Customer
                "select * "
                + "from customer "
                + "where lname like ?";

        PreparedStatement statement = null;

        try {
            //=== get Customer
            statement = conn.prepareStatement(SQLString);
            statement.setString(1, lname + "%");
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
                customerList.add(c);
            }
        } catch (Exception e) {
            System.out.println("Fail in BookingMapper - getCustomer");
            System.out.println(e.getMessage());
        }
        if (testRun) {
            System.out.println("Retrieved Customer: ");
        }
        return customerList;
    }

    public boolean updateBooking(ArrayList<Booking> bl, Connection conn) throws SQLException {
        int rowsUpdated = 0;
        String SQLString = "update booking "
                + "set arrival = TO_DATE(?,'YYYY-MM-DD'), "
                + "departure = TO_DATE(?,'YYYY-MM-DD'), numberofguests = ? "
                + "where reservationsnumber = ?";
        PreparedStatement statement = null;

        statement = conn.prepareStatement(SQLString);
        for (int i = 0; i < bl.size(); i++) {
            Booking b = bl.get(i);
            statement.setString(1, b.getArrival());
            statement.setString(2, b.getDeparture());
            statement.setInt(3, b.getNumberOfGuests());
            statement.setInt(4, b.getResNumber());
            rowsUpdated = statement.executeUpdate();

        }
        if (testRun) {
            System.out.println("updateOrders: " + (rowsUpdated == bl.size())); // for test
        }
        return (rowsUpdated == bl.size());    // false if any conflict in version number             
    }

    // Method to get data on bookings between 2 dates. 
    public ArrayList getBookingList(String arrival, String departure, Connection conn) {
        ArrayList bookingList = new ArrayList();
        Booking b = null;
        String SQLString = // get Booking
                "select to_char(arrival, 'yyyy-mm-dd'), to_char(departure, 'yyyy-mm-dd'), reservationsnumber, roomnumber, paid, customerID, numberOfGuests from booking where arrival between to_date(?,'yyyy-mm-dd') and to_date(?,'yyyy-mm-dd')";
//                "select * from booking where arrival between to_char(sysdate, 'yyyy-mm-dd') and to_char(sysdate, 'yyyy-mm-dd');"
        PreparedStatement statement = null;

        try {
            //=== get Customer
            statement = conn.prepareStatement(SQLString);
            statement.setString(1, arrival);
            statement.setString(2, departure);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                b = new Booking(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7));
                bookingList.add(b);
            }
        } catch (Exception e) {
            System.out.println("Fail in BookingMapper - getBookingList");
            System.out.println(e.getMessage());
        }
        if (testRun) {
            System.out.println("Retrieved BookingList: ");
        }
        return bookingList;
    }

    public ArrayList getCustomerID(String customerID, Connection conn) {
        ArrayList customerList = new ArrayList();
        Customer c = null;
        String SQLString = // get Customer
                "select * "
                + "from customer "
                + "where customerID like ?";

        PreparedStatement statement = null;

        try {
            //=== get Customer
            statement = conn.prepareStatement(SQLString);
            statement.setString(1, customerID + "%");
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
                customerList.add(c);
            }
        } catch (Exception e) {
            System.out.println("Fail in BookingMapper - getCustomer");
            System.out.println(e.getMessage());
        }
        if (testRun) {
            System.out.println("Retrieved CustomerID: ");
        }
        return customerList;
    }

    public ArrayList getRoomsList(String arrival, String departure, Connection conn) {
        ArrayList roomsList = new ArrayList();
        Rooms r = null;
        String SQLString = // get Booking
                "select roomnumber,roomtypeid from rooms where roomnumber not in"
                + " (select roomnumber from booking where arrival "
                + "<= to_date(?,'yyyy-mm-dd') and departure"
                + " >= to_date(?,'yyyy-mm-dd'))";

        PreparedStatement statement = null;

        try {
            //=== get Customer
            statement = conn.prepareStatement(SQLString);
            statement.setString(1, arrival);
            statement.setString(2, departure);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                r = new Rooms(
                        rs.getString(1),
                        rs.getString(2));
                roomsList.add(r);
            }
        } catch (Exception e) {
            System.out.println("Fail in BookingMapper - getRoomsList");
            System.out.println(e.getMessage());
        }
        if (testRun) {
            System.out.println("Retrieved RoomsList: ");
        }
        return roomsList;
    }

    boolean deleteBooking(ArrayList<Booking> deleteBooking, Connection conn) {
        String SQLString = "delete from booking where reservationsnumber = ?";

        PreparedStatement statement = null;
        int noOfRowsDeleteInBooking = 0;

        try {
            statement = conn.prepareCall(SQLString);

            statement.setInt(1, deleteBooking.get(0).getResNumber());

            noOfRowsDeleteInBooking = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in BookingMapper - deleteBooking");
            System.out.println(e.getMessage());
        }
        return noOfRowsDeleteInBooking == 1;

    }
}
