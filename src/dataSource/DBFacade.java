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
public class DBFacade
{

    // objects used in class
    private UOWPBook uowb;
    private UOWPBook uowc;
    private Connection con;
    // Variables used in class
    private int nextResNr;
    private int nextCustomerID;

    // Singleton
    private static DBFacade instance;

    public DBFacade()
    {
        con = new DBConnector().getConnection();  // the connection will be released upon program 
    }

    public static DBFacade getInstance()
    {
        if (instance == null)
        {
            instance = new DBFacade();
        }
        return instance;
    }

    // Method to get next reservation number from database
    public int getNextResnr()
    {

        nextResNr = new BookingMapper().getNextResNumber(con);
        return nextResNr;
    }

// Method to get next customer ID from database
    public int getNextCustomerID()
    {
        nextCustomerID = new BookingMapper().getNextCustomerID(con);
        return nextCustomerID;
    }

    // Methods to register changes
    public void registerNewBooking(Booking b)
    {
        if (uowb != null)
        {
            uowb.registerNewBooking(b);
        }
    }

    public void registerDirtyBooking(Booking b)
    {
        if (uowb != null)
        {
            uowb.registerDirtyBooking(b);
        }
    }

    public void registerNewCustomer(Customer c)
    {
        if (uowc != null)
        {
            uowc.registerNewCustomers(c);
        }
    }

    public void registerDirtyCustomer(Customer c)
    {
        if (uowc != null)
        {
            uowc.registerDirtyCustomers(c);
        }
    }

    // Methods to handle business transactions
    public void startNewBusinessTransactionBook()
    {
        uowb = new UOWPBook();
    }

    public void startNewBusinessTransactionCus()
    {
        uowc = new UOWPBook();
    }

    // Methods to save transactions to database
    public boolean commitBusinessTransactionBooking()
    {
        boolean status = false;
        if (uowb != null)
        {
            try
            {
                status = uowb.commit(con);
            } catch (Exception e)
            {
                System.out.println("Fail in DBFacade - commitBusinessTransaction");
                System.err.println(e);
            }
            uowb = null;
        }
        return status;
    }

    public boolean commitBusinessTransactionCustomer()
    {
        boolean status = false;
        System.out.println("CommitBTC out if");
        if (uowc != null)
        {
            System.out.println("CommitBTC in if");
            try
            {
                status = uowc.commitCustomers(con);
            } catch (Exception e)
            {
                System.out.println("Fail in DBFacade - commitBusinessTransaction");
                System.err.println(e);
            }
            uowc = null;
        }
        return status;
    }

    // Methods to retrieve data from database
    public ArrayList getCustomer(String lname)
    {
        ArrayList c = null;
        c = new BookingMapper().getCustomer(lname, con);
        return c;
    }

    public ArrayList getCustomerID(String customerID)
    {
        ArrayList c = null;
        c = new BookingMapper().getCustomerID(customerID, con);
        return c;
    }

    public ArrayList getBookingList(String arrival, String departure)
    {
        ArrayList b = null;
        b = new BookingMapper().getBookingList(arrival, departure, con);
        return b;
    }
    
        public ArrayList getRoomsList(String arrival, String departure)
    {
        ArrayList r = null;
        r = new BookingMapper().getRoomsList(arrival, departure, con);
        return r;
    }
        public Booking findResNumber(int resNo)
    {
        Booking resNumber = null;
        resNumber = new BookingMapper().findResNumber(resNo, con);
        return resNumber;
    }
        public boolean changeArrivalForBooking(Booking booking){
        return BookingMapper.testRun;
          }
}
