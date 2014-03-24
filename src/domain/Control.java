package domain;

import dataSource.*;
public class Control {
    
    Customers Cum = new Customers();
    DBFacade facade = new DBFacade();
    Rooms rooms = new Rooms();
    Booking booking = new Booking();
    
    public void newBooking(String fname, String lname, String country, String email, int phone, String address, int noOfGuest, String arrival, String departure, int roomNumber) {
        System.out.println(fname+" "+lname+" "+country+" "+email+" "+phone+" "+address+" "+noOfGuest+" "+arrival+" "+departure+" "+roomNumber);
    }
}
