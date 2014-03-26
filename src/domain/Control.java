package domain;

import dataSource.*;
public class Control
{
   
    UOWPBook uow = new UOWPBook();
    private boolean processingBooking;	// state of business transaction
    private Booking currentBooking;       	// Order in focus
    private DBFacade dbFacade;
    private boolean processingCustomer;
    private Customers currentCustomer;
    BookingMapper bm = new BookingMapper(); 
    public Control()
    {
        processingBooking = false;
        currentBooking = null;
        processingCustomer = false;
        currentCustomer = null;
        dbFacade = DBFacade.getInstance();
    }

    public Booking createNewBooking(String arrival, String departure, int numberOfGuests,int roomNumber)
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
            currentBooking = new Booking(arrival, departure, numberOfGuests);
            dbFacade.registerNewBooking(currentBooking);
        } else
        {
            processingBooking = false;
            currentBooking = null;
        }
        return currentBooking;
    }

    public Customers createNewCustomer(String FirstName, String LastName, String Country, String Email,  int Phone,String Address)
    {
        if (processingCustomer)
        {
            return null;
        }
        dbFacade.startNewBusinessTransactionCus();
        //int newResnr = dbFacade.getNextResnr();// rDB-generated unique ID
        int customerID = dbFacade.getNextCustomerID();
        System.out.println("createNewCustomer out if");
        System.out.println("customerID from createNewCustomer :" + customerID);
        if (customerID != 0)
        {
                  System.out.println("createNewCustomer in if");
            processingCustomer = true;
            currentCustomer = new Customers(FirstName,LastName,Country,Email,Phone,Address);
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
        System.out.println("SaveCustomer out if");
        if (processingCustomer)
        {
            System.out.println("SaveCustomer in if");
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
