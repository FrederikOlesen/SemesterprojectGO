package domain;

import java.sql.Date;

public class Booking {
    
    //Created all the variables.
    
    private Date arrival;
    private Date departure;
    private String resNumber;
    private String roomType;
    private boolean payment;

    //Created getters and setters for the variables above.
    
    public Date getArrival() {
        return arrival;
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

    public String getResNumber() {
        return resNumber;
    }

    public void setResNumber(String resNumber) {
        this.resNumber = resNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    //Created a toString-method, which returns a String representation of the object.
    @Override
    public String toString() {
        return "Booking{" + "arrival=" + arrival + ", departure=" + departure + ", resNumber=" + resNumber + ", roomType=" + roomType + ", payment=" + payment + '}';
    }
    
}