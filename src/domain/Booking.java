package domain;

import java.sql.Date;
import java.util.ArrayList;

public class Booking {
    
    //Created all the variables.
    
    private Date arrival;
    private Date departure;
    private int resNumber;
    private String roomType;
    private int payment;
    private int roomNumber;
    private ArrayList<Booking> booking = new ArrayList<Booking>();

    public ArrayList<Booking> getBooking() {
        return booking;
    }

    //Created getters and setters for the variables above.
    
    public Date getArrival() {
        return arrival;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
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