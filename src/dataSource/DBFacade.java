/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.*;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author frederikolesen
 */
public class DBFacade {

    // objects used in class
    private UOWPBook uowb;
    private UOWPBook uowc;
    private UOWPBook uows;
    private Connection con;
    // Variables used in class
    private int nextResNr;
    private int nextCustomerID;
    BookingMapper bm;

    // Singleton
    private static DBFacade instance;

    public DBFacade() {
        con = new DBConnector().getConnection();  // The connection will be released upon program 
    }

    public static DBFacade getInstance() {
        if (instance == null) {
            instance = new DBFacade();
        }
        return instance;
    }

    // Singleton end
    // Method to get next reservation number from database
    public int getNextResnr() {

        nextResNr = new BookingMapper().getNextResNumber(con);
        return nextResNr;
    }

// Method to get next customer ID from database
    public int getNextCustomerID() {
        nextCustomerID = new BookingMapper().getNextCustomerID(con);
        return nextCustomerID;
    }

    // Methods to register changes
    public void registerNewBooking(Booking b) {
        if (uowb != null) {
            uowb.registerNewBooking(b);
        }
    }

    public void registerDirtyBooking(Booking b) {
        if (uowb != null) {
            uowb.registerDirtyBooking(b);
        }
    }

    public void registerNewCustomer(Customer c) {
        if (uowc != null) {
            uowc.registerNewCustomers(c);
        }
    }

    public void registerDirtyCustomer(Customer c) {
        if (uowc != null) {
            uowc.registerDirtyCustomers(c);
        }
    }

    // Methods to handle business transactions
    public void startNewBusinessTransactionBook() {
        uowb = new UOWPBook();
    }

    public void startNewBusinessTransactionCus() {
        uowc = new UOWPBook();
    }

    public void StartNewSPBookingTransaction() {
        uows = new UOWPBook();
    }

    public void registerNewSPBooking(SportsBooking b) {
        if (uows != null) {
            uows.registerNewSPBooking(b);
        }
    }

    // Methods to save transactions to database
    public boolean commitBusinessTransactionBooking() {
        boolean status = false;
        if (uowb != null) {
            try {
                status = uowb.commit(con);
            } catch (Exception e) {
                System.out.println("Fail in DBFacade - commitBusinessTransaction");
                System.err.println(e);
            }
            uowb = null;
        }
        return status;
    }

    public boolean commitBusinessTransactionSportsBooking() {
        boolean status = false;
        if (uows != null) {
            try {
                status = uows.commitSportsBooking(con);
            } catch (Exception e) {
                System.out.println("Fail in DBFacade - commitBusinessTransaction");
                System.err.println(e);
            }
            uows = null;
        }
        return status;
    }

    public boolean commitBusinessTransactionCustomer() {
        boolean status = false;
        if (uowc != null) {
            try {
                status = uowc.commitCustomers(con);
            } catch (Exception e) {
                System.out.println("Fail in DBFacade - commitBusinessTransaction");
                System.err.println(e);
            }
            uowc = null;
        }
        return status;
    }

    // Methods to retrieve data from database
    public ArrayList getCustomer(String lname) {
        ArrayList c = null;
        c = new BookingMapper().getCustomer(lname, con);
        return c;
    }

    public ArrayList getCustomerID(String customerID) {
        ArrayList c = null;
        c = new BookingMapper().getCustomerFromID(customerID, con);
        return c;
    }

    public ArrayList getBookingList(String arrival, String departure) {
        ArrayList b = null;
        b = new BookingMapper().getBookingList(arrival, departure, con);
        return b;
    }

    public ArrayList getRoomsList(String arrival, String departure) {
        ArrayList r = null;
        r = new BookingMapper().getRoomsList(arrival, departure, con);
        return r;
    }

    public Booking findResNumber(int resNo) {
        Booking resNumber = null;
        resNumber = new BookingMapper().findResNumber(resNo, con);
        return resNumber;
    }

    public String locateResNumber(int resNo) {
        String name = new BookingMapper().lookAtResNumber(resNo, con);
        return name;
    }

    public boolean changeArrivalForBooking(Booking booking) {
        return BookingMapper.testRun;
    }

    public void registerDeleteBooking(Booking b) {
        if (uowb != null) {
            uowb.registerDeleteBooking(b);
        }
    }

    public void createSportsID(int resNumber) {
        Booking bm = new BookingMapper().findResNumber(resNumber, con);
        int guests = bm.getNumberOfGuests();
        boolean succes = new BookingMapper().createCustomerID(resNumber, guests, con);
    }

    public int countSportsBookings(String date, String sportsID) {
        int count = new BookingMapper().countBookingsForSportsId(con, date, sportsID);
        return count;
    }
}
