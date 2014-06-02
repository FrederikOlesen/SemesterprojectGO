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
    private final ArrayList<Customer> newCustomers;
    private final ArrayList<SportsBooking> newSPBooking;

    // Constructor
    public UOWPBook() {
        newBooking = new ArrayList<>();
        modifiedBooking = new ArrayList<>();
        deleteBooking = new ArrayList<>();
        newCustomers = new ArrayList<>();
        modifiedCustomers = new ArrayList<>();
        newSPBooking = new ArrayList<>();
    }

    // Register booking method, keeps track of new bookings
    public void registerNewBooking(Booking b) {
        if (!newBooking.contains(b)
                && !modifiedBooking.contains(b)) {
            newBooking.add(b);
        }
    }

    // Register dirty booking method, keeps track of modefied bookings
    public void registerDirtyBooking(Booking b) {
        if (!newBooking.contains(b)
                && !modifiedBooking.contains(b)) {
            modifiedBooking.add(b);
        }
    }

    // Register customer method, keeps track of new customers
    public void registerNewCustomers(Customer c) {
        if (!newCustomers.contains(c)
                && !modifiedCustomers.contains(c)) {
            newCustomers.add(c);
        }
    }

    // Register dirty customer method, keeps track of modified customers
    public void registerDirtyCustomers(Customer c) {
        if (!newCustomers.contains(c)
                && !modifiedCustomers.contains(c)) {
            modifiedCustomers.add(c);
        }
    }

    public void registerNewSPBooking(SportsBooking b) {
        if (!newSPBooking.contains(b)
                && !newSPBooking.contains(b)) {
            newSPBooking.add(b);
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
            status = false;
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
            status = false;
        }
        return status;
    }

    public boolean commitSportsBooking(Connection conn) throws SQLException {
        boolean status = true;
        try {
            // Start of system transaction
            conn.setAutoCommit(false);
            BookingMapper bm = new BookingMapper();
            status = status && bm.addNewSportsBooking(newSPBooking, conn);

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

    // Method to delete a booking
    void registerDeleteBooking(Booking b) {
        if (!newBooking.contains(b)
                && !modifiedBooking.contains(b)
                && !deleteBooking.contains(b)) {
            deleteBooking.add(b);
        }
    }

    //Method to get the list of rooms. 
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

    //List to find a booking from the reservationnumber
    public Booking findResNo(int resNo, Connection con) {

        Booking r = null;
        try {
            r = new BookingMapper().findResNumber(resNo, con);
        } catch (Exception e) {
            System.out.println("fail in UnitOfWork - findResNo");
            System.err.println(e);
        }
        return r;

    }
}
