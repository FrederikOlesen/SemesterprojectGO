package domain;

import dataSource.*;
import java.util.ArrayList;
import dataSource.BookingMapper;
import dataSource.DBFacade;
import dataSource.UOWPBook;

public class Control
{

    // Booleans and objects used to keep track of bussiness transactions.
    private boolean processingBooking;
    private boolean processingCustomer;
    private boolean processingRooms;
    private Customer currentCustomer;
    private Booking currentBooking;
    private Rooms currentRooms;

    // Instances of classes needed in methods 
    UOWPBook uow = new UOWPBook();
    private DBFacade dbFacade;
    BookingMapper bm = new BookingMapper();
    ArrayList currentBookingList = new ArrayList();
    ArrayList currentCustomerList = new ArrayList();
    ArrayList currentRoomsList = new ArrayList();

    // Contructor
    public Control()
    {
        processingBooking = false;
        currentBooking = null;
        processingCustomer = false;
        currentCustomer = null;
        processingRooms = false;
        currentRooms = null;
        dbFacade = DBFacade.getInstance();
    }

    // Method for creating a new booking, returns a booking object.
    public Booking createNewBooking(String arrival, String departure, int numberOfGuests, int roomType, int CustomerID)
    {
        if (processingBooking)
        {
            return null;
        }
        dbFacade.startNewBusinessTransactionBook();
        int nextResNr = dbFacade.getNextResnr();// rDB-generated unique ID
        int payment = 1;
        int roomNumber = 10;

        if (nextResNr != 0)
        {
            processingBooking = true;
            currentBooking = new Booking(arrival, departure, nextResNr, payment, roomNumber, CustomerID, numberOfGuests);
            dbFacade.registerNewBooking(currentBooking);
        } else
        {
            processingBooking = false;
            currentBooking = null;
        }
        return currentBooking;
    }

    // Method for creating a new customer. Returns a customer object.
    public Customer createNewCustomer(String FirstName, String LastName, String Country, String Email, int Phone, String Address)
    {
        if (processingCustomer)
        {
            return null;
        }
        dbFacade.startNewBusinessTransactionCus();

        int customerID = dbFacade.getNextCustomerID();
        if (customerID != 0)
        {
            processingCustomer = true;
            currentCustomer = new Customer(customerID, FirstName, LastName, Country, Email, Phone, Address);
            dbFacade.registerNewCustomer(currentCustomer);
        } else
        {
            processingCustomer = false;
            currentCustomer = null;
        }
        return currentCustomer;
    }

    // Method for saving the curent booking, returns true if succesfull
    public boolean saveBooking()
    {
        boolean status = false;
        if (processingBooking)
        {
            //== ends ongoing business transaction
            status = dbFacade.commitBusinessTransactionBooking();
            processingBooking = false;
            currentBooking = null;
        }
        return status;
    }

    public void resetBooking()
    {
        processingBooking = false;
        currentBooking = null;
    }

    // Method for saving the curent customer, returns true if succesfull
    public boolean saveCustomer()
    {
        boolean status = false;
        if (processingCustomer)
        {
            //== ends ongoing business transaction
            status = dbFacade.commitBusinessTransactionCustomer();
            processingCustomer = false;
            currentCustomer = null;
        }
        return status;
    }

    public void resetCustomer()
    {
        processingCustomer = false;
        currentCustomer = null;
    }
    
        public void resetRooms()
    {
        processingRooms = false;
        currentRooms = null;
    }

    //Method used for getting customer data from database, returns customer object
    public ArrayList getCustomer(String lname)
    {
        if (processingCustomer)
        {
            return null;
        }
        dbFacade.startNewBusinessTransactionCus();
        processingCustomer = true;
        currentCustomerList = dbFacade.getCustomer(lname);
        return currentCustomerList;
    }
    
        public ArrayList getBookingList(String arrival, String departure)
    {
        if (processingBooking)
        {
            return null;
        }
        dbFacade.startNewBusinessTransactionBook();
        processingBooking = true;
        currentBookingList = dbFacade.getBookingList(arrival, departure);
        return currentBookingList;
    }
        public ArrayList getCustomerID(String customerID)
    {
        if (processingCustomer)
        {
            return null;
        }
        dbFacade.startNewBusinessTransactionCus();
        processingCustomer = true;
        currentCustomerList = dbFacade.getCustomerID(customerID);
        return currentCustomerList;
    }
        
            public ArrayList getRoomsList(String arrival, String departure)
    {
        if (processingRooms)
        {
            return null;
        }
        dbFacade.startNewBusinessTransactionBook();
        processingRooms = true;
        currentRoomsList = dbFacade.getRoomsList(arrival, departure);
        return currentRoomsList;
    }
}
