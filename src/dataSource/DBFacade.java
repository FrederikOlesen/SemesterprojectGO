/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.*;
import java.sql.Connection;

/**
 *
 * @author frederikolesen
 */
public class DBFacade {

    private UOWPBook uowb;
    private UOWPBook uowc;
    private Connection con;
    private int nextResNr;
    private int nextCustomerID;

    //=====	Singleton
    private static DBFacade instance;

    public DBFacade() {
        con = new DBConnector().getConnection();  // the connection will be released upon program 
    }

    public static DBFacade getInstance() {
        if (instance == null) {
            instance = new DBFacade();
        }
        return instance;
    }

    public int getNextResnr() {

        nextResNr = new BookingMapper().getNextResNumber(con);
        return nextResNr;
    }

    public int getNextCustomerID() {
        nextCustomerID = new BookingMapper().getNextCustomerID(con);
        return nextCustomerID;
    }

    //=====	Methods to register changes	in UnitOfWork  
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

    //=== Methods to handle business transactions
    //=====	Ignore changes after last commit
    public void startNewBusinessTransactionBook() {
        uowb = new UOWPBook();
    }

    public void startNewBusinessTransactionCus() {
        uowc = new UOWPBook();
    }

    //=====	Save all changes
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

    public boolean commitBusinessTransactionCustomer() {
        boolean status = false;
        System.out.println("CommitBTC out if");
        if (uowc != null) {
            System.out.println("CommitBTC in if");
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

    public Customer getCustomer(String lname) {
        Customer c = null;
        c = new BookingMapper().getCustomer(lname, con);
        return c;
    }
    
    public Booking getBookingList(String arrival, String departure) {
        Booking b = null;
        b = new BookingMapper().getBookingList(arrival, departure, con);
        return b;
    }
}
