package domain;

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
    private boolean processingFindBooking;
    private boolean processingSPBooking;
    private Customer currentCustomer;
    private Booking currentBooking;
    private Rooms currentRooms;
    private SportsBooking currentSPBooking;

    // Instances of classes needed in methods 
    UOWPBook uow = new UOWPBook();
    private DBFacade dbFacade;
    BookingMapper bm = new BookingMapper();
    Booking booking;
    ArrayList currentBookingList = new ArrayList();
    ArrayList currentCustomerList = new ArrayList();
    ArrayList currentRoomsList = new ArrayList();
    ArrayList currentFindBooking = new ArrayList();
  //  ArrayList currentSPBooking = new ArrayList();

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
        // processingFindBooking = false;
        currentFindBooking = null;
    }

    // Method for creating a new booking, returns a booking object.
    public Booking createNewBooking(String arrival, String departure, int numberOfGuests, int paid, int roomNumber, int CustomerID)
    {
        if (processingBooking)
        {
            return null;
        }
        dbFacade.startNewBusinessTransactionBook();
        int nextResNr = dbFacade.getNextResnr();// rDB-generated unique ID

        if (nextResNr != 0)
        {
            processingBooking = true;
            currentBooking = new Booking(arrival, departure, nextResNr, paid, roomNumber, CustomerID, numberOfGuests);
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

    public SportsBooking createNewSPBooking(String reservationsNumber, String sportsID, String SportType, String sportDate, int counter, int trainer)
    {
        if (processingSPBooking)
        {
            return null;
        }
        dbFacade.StartNewSPBookingTransaction();
        processingSPBooking = true;
        currentSPBooking = new SportsBooking(reservationsNumber, sportsID, SportType, sportDate, counter, trainer);
        dbFacade.registerNewSPBooking(currentSPBooking);
        return currentSPBooking;
    }

    //Created a method to change all three booking information in a booking.
    public Booking changeBookingInformation(String arrival, String departure, int nog, int paid)
    {
        if (processingBooking)
        {
            currentBooking.setArrival(arrival);
            currentBooking.setDeparture(departure);
            currentBooking.setNumberOfGuests(nog);
            currentBooking.setPayment(paid);
            dbFacade.registerDirtyBooking(currentBooking);
        }
        return currentBooking;
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

    public boolean saveSPBooking()
    {
        boolean status = false;
        if (processingSPBooking)
        {
            //== ends ongoing business transaction
            status = dbFacade.commitBusinessTransactionBooking();
            processingSPBooking = false;
            currentSPBooking = null;
        }
        return status;
    }

    public void resetSPBooking()
    {
        processingSPBooking = false;
        currentSPBooking = null;
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

    public Booking findResNumber(int resNo)
    {
        if (processingBooking)
        {
            return null;
        }
        dbFacade.startNewBusinessTransactionBook();
        processingBooking = true;
        currentBooking = dbFacade.findResNumber(resNo);
        return currentBooking;
    }

    public void deleteBooking()
    {
        if (processingBooking)
        {
            dbFacade.registerDeleteBooking(currentBooking);
        }
    }

    public String findNameFromResNo(int resNo)
    {
        String name = dbFacade.locateResNumber(resNo);
        return name;

    }

    public void createCustomerID(int resNo)
    {
        dbFacade.createSportsID(resNo);
    }
}
