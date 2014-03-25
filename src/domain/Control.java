package domain;

import dataSource.*;

public class Control
{

    Customers Cum = new Customers();
    //DBFacade facade = new DBFacade();
    Rooms rooms = new Rooms();
    Booking booking = new Booking();
    UOWPBook uow = new UOWPBook();

    private boolean processingBooking;	// state of business transaction
    private Booking currentBooking;       	// Order in focus
    private DBFacade dbFacade;

    public Control()
    {
        processingBooking = false;
        currentBooking = null;
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

    public Booking createNewBooking(String fname, String lname, String country, String email, int phone, String address, int noOfGuest, String arrival, String departure, int roomNumber)
    {
        roomNumber = 1; 
        if (processingBooking)
        {
            return null;
        }
        dbFacade.startNewBusinessTransaction();
        int newResnr = dbFacade.getNextResnr();// rDB-generated unique ID
        if (newResnr != 0)
        {
            processingBooking = true;
            currentBooking = new Booking();
            dbFacade.registerNewBooking(currentBooking);
        } else
        {
            processingBooking = false;
            currentBooking = null;
        }
        return currentBooking;
    }

    public boolean saveBooking()
    {
        boolean status = false;
        if (processingBooking)
        {
            //== ends ongoing business transaction
            status = dbFacade.commitBusinessTransaction();
            processingBooking = false;
            currentBooking = null;
        }
        return status;
    }
    
    public void resetBooking() {
        processingBooking = false;
        currentBooking = null;
    }
}
