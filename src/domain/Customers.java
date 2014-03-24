package domain;

import java.util.ArrayList;

public class Customers
{

    // Variables for the customers
    private String FirstName;
    private String LastName;
    private String Country;
    private String Email;
    private int Phone;
    private String Address;
    private int ReservationNumber;
    private int NumberofGuests;
    private String TravelAgency;

    //Constructor for a customer, needs all the variables that makes a customer
    public Customers(String FirstName, String LastName, String Country, String Email, int Phone, int ReservationNumber, int NumberofGuests)
    {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Country = Country;
        this.Email = Email;
        this.Phone = Phone;
        this.Address = Address;
        this.ReservationNumber = ReservationNumber;
        this.NumberofGuests = NumberofGuests;
        this.TravelAgency = TravelAgency;
    }
    
    //Getters and setters for the variables 
    public String getFirstName()
    {
        return FirstName;
    }

    public void setFirstName(String FirstName)
    {
        this.FirstName = FirstName;
    }

    public String getLastName()
    {
        return LastName;
    }

    public void setLastName(String LastName)
    {
        this.LastName = LastName;
    }

    public String getCountry()
    {
        return Country;
    }

    public void setCountry(String Country)
    {
        this.Country = Country;
    }

    public String getEmail()
    {
        return Email;
    }

    public void setEmail(String Email)
    {
        this.Email = Email;
    }

    public int getPhone()
    {
        return Phone;
    }

    public void setPhone(int Phone)
    {
        this.Phone = Phone;
    }

    public String getAddress()
    {
        return Address;
    }

    public void setAdress(String Address)
    {
        this.Address = Address;
    }

    public int getReservationNumber()
    {
        return ReservationNumber;
    }

    public void setReservationNumber(int ReservationNumber)
    {
        this.ReservationNumber = ReservationNumber;
    }

    public int getNumberofGuests()
    {
        return NumberofGuests;
    }

    public void setNumberofGuests(int NumberofGuests)
    {
        this.NumberofGuests = NumberofGuests;
    }

    public String getTravelAgency()
    {
        return TravelAgency;
    }

    public void setTravelAgency(String TravelAgency)
    {
        this.TravelAgency = TravelAgency;
    }

    //toString method
    @Override
    public String toString()
    {
        return "Customers{" + "Phone=" + Phone + ", NumberofGuests=" + NumberofGuests + '}';
    }
    

}
