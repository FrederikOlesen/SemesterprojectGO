package dataSource;

import domain.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class UOWPBook {

    // ArrayLists used to keep track of business transactions
    private final ArrayList<Booking> modifiedBooking;
    private final ArrayList<Booking> deleteBooking;
    private final ArrayList<Booking> newBooking;
    private final ArrayList<Customer> modifiedCustomers;
    private final ArrayList<Customer> deleteCustomers;
    private final ArrayList<Customer> newCustomers;

    // Constructor
    public UOWPBook() {
        newBooking = new ArrayList<>(); // will never exceed 1 element
        modifiedBooking = new ArrayList<>(); // will never exceed 1 element
        deleteBooking = new ArrayList<>();
        newCustomers = new ArrayList<>();
        deleteCustomers = new ArrayList<>();
        modifiedCustomers = new ArrayList<>();

    }

    // Register booking method, keeps track of new bookings
    public void registerNewBooking(Booking b) {
        if (!newBooking.contains(b) && // if not allready registered in any list
                !modifiedBooking.contains(b)) {
            newBooking.add(b);
        }
    }

    // Register dirty booking method, keeps track of modefied bookings
    public void registerDirtyBooking(Booking b) {
        if (!newBooking.contains(b) && // if not allready registered in any list
                !modifiedBooking.contains(b)) {
            modifiedBooking.add(b);
        }
    }

    // Register customer method, keeps track of new customers
    public void registerNewCustomers(Customer c) {
        if (!newCustomers.contains(c) && // if not allready registered in any list
                !modifiedCustomers.contains(c)) {
            newCustomers.add(c);
        }
    }

// Register dirty customer method, keeps track of modified customers
    public void registerDirtyCustomers(Customer c) {
        if (!newCustomers.contains(c) && // if not allready registered in any list
                !modifiedCustomers.contains(c)) {
            modifiedCustomers.add(c);
        }
    }

    // Method to save changes to database
    public boolean commit(Connection conn) throws SQLException {
        boolean status = true;
        try {
// Start of system transaction
            conn.setAutoCommit(false);
            BookingMapper bm = new BookingMapper();
            status = status && bm.addNewBooking(newBooking, conn);
            status = status && bm.updateBooking(modifiedBooking, conn);
            status = status && bm.deleteBooking(deleteBooking, conn);
            if (!status) {

                throw new Exception("Business Transaction aborted");
            }
            // System transaction ends with success
            conn.commit();
        } catch (Exception e) {
            System.out.println("fail in UnitOfWork - commit()");
            System.err.println(e);
            // System transaction fails, rollsback
            conn.rollback();
            status = false;// rettelse
        }
        return status;
    }

    // Method to save changes to database
    public boolean commitCustomers(Connection conn) throws SQLException {
        boolean status = true;
        try {
            // Start of system transaction
            conn.setAutoCommit(false);
            BookingMapper bm = new BookingMapper();
            System.out.println("CommitCustomer");
            status = status && bm.addNewCustomer(newCustomers, conn);

            if (!status) {
                throw new Exception("Business Transaction aborted");
            }
            // System transaction ends with success
            conn.commit();
        } catch (Exception e) {
            System.out.println("fail in UnitOfWork - commit()");
            System.err.println(e);
            // System transaction fails, rollsback
            conn.rollback();
            status = false;// rettelse
        }
        return status;
    }

// Method to read from database
    public ArrayList getCustomers(String lname, Connection con) {
        ArrayList c = null;;
        try {
            c = new BookingMapper().getCustomer(lname, con);
        } catch (Exception e) {
            System.out.println("fail in UnitOfWork - getOrder()");
            System.err.println(e);
        }
        return c;

    }

    // Method to read from database
    public ArrayList getBookingList(String arrival, String departure, Connection con) {
        ArrayList b = null;
        try {
            b = new BookingMapper().getBookingList(arrival, departure, con);
        } catch (Exception e) {
            System.out.println("fail in UnitOfWork - getBookingList");
            System.err.println(e);
        }
        return b;

    }

    void registerDeleteBooking(Booking b) {
        if (!newBooking.contains(b) && // if not allready registered in any list
                !modifiedBooking.contains(b)
                && !deleteBooking.contains(b)) {
            deleteBooking.add(b);
        }
    }

    public ArrayList getRoomsList(String arrival, String departure, Connection con) {
        ArrayList r = null;
        try {
            r = new BookingMapper().getRoomsList(arrival, departure, con);
        } catch (Exception e) {
            System.out.println("fail in UnitOfWork - getRoomsList");
            System.err.println(e);
        }
        return r;

    }

    public Booking findResNo(int resNo, Connection con) {

        Booking r = null;
        try {
            r = new BookingMapper().findResNumber(resNo, con);
        } catch (Exception e) {
            System.out.println("fail in UnitOfWork - getRoomsList");
            System.err.println(e);
        }
        return r;

    }
}
