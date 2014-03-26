package domain;


import java.util.ArrayList;

public class Booking {
    
    //Created all the variables.
    
    private String arrival;
    private String departure;
    private int resNumber;
    private String roomType;
    private int payment;
    private int roomNumber;
    private int customerID; 

    public int getNumberOfGuests()
    {
        return numberOfGuests;
    }

    public int getCustomerID()
    {
        return customerID;
    }

    public void setNumberOfGuests(int numberOfGuests)
    {
        this.numberOfGuests = numberOfGuests;
    }
    private int numberOfGuests;
    private ArrayList<Booking> booking = new ArrayList<Booking>();

    public ArrayList<Booking> getBooking() {
        return booking;
    }

    public Booking(String arrival, String departure,int nextResNr, int numberOfGuests)
    {
        this.arrival = arrival;
        this.departure = departure;
        this.resNumber = nextResNr;
        this.numberOfGuests = numberOfGuests;
    }
    

    //Created getters and setters for the variables above.
    
    public String getArrival() {
        return arrival;
    }

    public int getRoomNumber() {
        return roomNumber = 1;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public int getResNumber() {
        return resNumber;
    }

    public void setResNumber(int resNumber) {
        this.resNumber = resNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    
    //Created a toString-method, which returns a String representation of the object.
    @Override
    public String toString() {
        return "Booking{" + "arrival=" + arrival + ", departure=" + departure + ", resNumber=" + resNumber + ", roomType=" + roomType + ", payment=" + payment + '}';
    }
    
}