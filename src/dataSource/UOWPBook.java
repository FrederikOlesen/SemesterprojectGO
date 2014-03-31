package dataSource;

import domain.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class UOWPBook {

    private final ArrayList<Booking> modifiedBooking;
    private final ArrayList<Booking> deleteBooking;
    private final ArrayList<Booking> newBooking;
    private final ArrayList<Customer> modifiedCustomers;
    private final ArrayList<Customer> deleteCustomers;
    private final ArrayList<Customer> newCustomers;

    // private ArrayList<Customers> newCustomers;
    public UOWPBook() {
        newBooking = new ArrayList<>(); // will never exceed 1 element
        modifiedBooking = new ArrayList<>(); // will never exceed 1 element
        deleteBooking = new ArrayList<>();
        newCustomers = new ArrayList<>();
        deleteCustomers = new ArrayList<>();
        modifiedCustomers = new ArrayList<>();

    }
    //====== Methods to register changes ==========================

    public void registerNewBooking(Booking b) {
        if (!newBooking.contains(b) && // if not allready registered in any list
                !modifiedBooking.contains(b)) {
            newBooking.add(b);
        }
    }

    public void registerDirtyBooking(Booking b) {
        if (!newBooking.contains(b) && // if not allready registered in any list
                !modifiedBooking.contains(b)) {
            modifiedBooking.add(b);
        }
    }

    public void registerNewCustomers(Customer c) {
        if (!newCustomers.contains(c) && // if not allready registered in any list
                !modifiedCustomers.contains(c)) {
            newCustomers.add(c);
        }
    }

    public void registerDirtyCustomers(Customer c) {
        if (!newCustomers.contains(c) && // if not allready registered in any list
                !modifiedCustomers.contains(c)) {
            modifiedCustomers.add(c);
        }
    }

    //====== Method to save changes to DB ===============================
    public boolean commit(Connection conn) throws SQLException {
        boolean status = true;
        try {
            //=== system transaction - start
            conn.setAutoCommit(false);
            BookingMapper bm = new BookingMapper();
            status = status && bm.addNewBooking(newBooking, conn);
//            status = status && bm.updateBooking(modifiedBooking, conn);
//            status = status && bm.deleteBooking(deleteBooking, conn);
            if (!status) {

                throw new Exception("Business Transaction aborted");
            }
            //=== system transaction - end with success
            conn.commit();
        } catch (Exception e) {
            System.out.println("fail in UnitOfWork - commit()");
            System.err.println(e);
            //=== system transaction - end with roll back
            conn.rollback();
            status = false;// rettelse
        }
        return status;
    }

    public boolean commitCustomers(Connection conn) throws SQLException {
        boolean status = true;
        try {
            //=== system transaction - start
            conn.setAutoCommit(false);
            BookingMapper bm = new BookingMapper();
            System.out.println("CommitCustomer");
            status = status && bm.addNewCustomer(newCustomers, conn);
//            status = status && bm.updateBooking(modifiedBooking, conn);
//            status = status && bm.deleteBooking(deleteBooking, conn);
            if (!status) {
                throw new Exception("Business Transaction aborted");
            }
            //=== system transaction - end with success
            conn.commit();
        } catch (Exception e) {
            System.out.println("fail in UnitOfWork - commit()");
            System.err.println(e);
            //=== system transaction - end with roll back
            conn.rollback();
            status = false;// rettelse
        }
        return status;
    }

//    ====== Methods to read from DB ===================================================
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

    public void registerDeletedBooking(Booking b) {
        if (!newBooking.contains(b) && // if not allready registered in any list
                !deleteBooking.contains(b)) {
            modifiedBooking.add(b);
        }
    }
}
