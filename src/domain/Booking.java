package domain;

import java.util.ArrayList;

public class Booking {

    //Created all the variables.
    private String arrival;
    private String departure;
    private int resNumber;
    private int roomType;
    private int payment;
    private int roomNumber;
    private int customerID;
    ArrayList<Booking> booking = new ArrayList<Booking>();

    public Booking(String arrival, String departure, int resNumber, int roomType, int payment, int roomNumber, int customerID, int numberOfGuests) {
        this.departure = departure;
        this.resNumber = resNumber;
        this.roomType = roomType;
        this.payment = payment;
        this.roomNumber = roomNumber;
        this.customerID = customerID;
        this.numberOfGuests = numberOfGuests;
        this.arrival = arrival;

    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }
    private int numberOfGuests;

    public ArrayList<Booking> getBooking() {
        return booking;
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

    public int getRoomType() {
        return roomType;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Booking{" + "arrival=" + arrival + ", departure=" + departure + ", resNumber=" + resNumber + ", roomType=" + roomType + ", roomNumber=" + roomNumber + ", numberOfGuests=" + numberOfGuests + '}';
    }
    
}
