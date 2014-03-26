package domain;

import dataSource.*;

public class Control
{
   
    //DBFacade facade = new DBFacade();
    Rooms rooms = new Rooms();
    UOWPBook uow = new UOWPBook();
    
    private boolean processingBooking;	// state of business transaction
    private Booking currentBooking;       	// Order in focus
    private DBFacade dbFacade;
    private boolean processingCustomer;
    private Customers currentCustomer;
    
    int nextResNr;
    public Control()
    {
        processingBooking = false;
        currentBooking = null;
        processingCustomer = false;
        currentCustomer = null;
        dbFacade = DBFacade.getInstance();
    }
//
//    public void newBooking(String fname, String lname, String country, String email, int phone, String address, int noOfGuest, String arrival, String departure, int roomNumber)
//    {
//
//        uow.getNewBooking().add(booking);
//        // System.out.println(fname+" "+lname+" "+country+" "+email+" "+phone+" "+address+" "+noOfGuest+" "+arrival+" "+departure+" "+roomNumber);
//        dbFacade.startNewBusinessTransaction();
//        //DBinstance.registerNewBooking(booking);
//    }

    public Booking createNewBooking(String arrival, String departure, int roomNumber)
    {
        roomNumber = 1;
        if (processingBooking)
        {
            return null;
        }
        dbFacade.startNewBusinessTransaction();
        nextResNr = dbFacade.getNextResnr();// rDB-generated unique ID
        if (nextResNr != 0)
        {
            processingBooking = true;
            currentBooking = new Booking(arrival, departure, roomNumber);
            dbFacade.registerNewBooking(currentBooking);
        } else
        {
            processingBooking = false;
            currentBooking = null;
        }
        return currentBooking;
    }

    public Customers createNewCustomer(String FirstName, String LastName, String Country, String Email,String Address, int Phone, int NumberofGuests)
    {
        if (processingCustomer)
        {
            return null;
        }
        //dbFacade.startNewBusinessTransaction();
        //int newResnr = dbFacade.getNextResnr();// rDB-generated unique ID
        if (nextResNr != 0)
        {
            processingCustomer = true;
            currentCustomer = new Customers(FirstName,LastName,Country,Email,Address,Phone,NumberofGuests);
            dbFacade.registerNewCustomer(currentCustomer);
        } else
        {
            processingCustomer = false;
            currentCustomer = null;
        }
        return currentCustomer;
    }

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

    public boolean saveCustomer()
    {
        boolean status = false;
        System.out.println("Test Customer");
        if (processingCustomer)
        {
            System.out.println("Test Customer 1");
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
}
