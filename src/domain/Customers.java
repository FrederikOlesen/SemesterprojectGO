package domain;

import java.util.ArrayList;

public class Customers {

    // Variables for the customers
    private int CustomerID;
    private String FirstName;
    private String LastName;
    private String Country;
    private String Email;
    private int Phone;
    private String Address;
    ArrayList<Customers> cu = new ArrayList<>();

    public Customers(int CustomerID, String FirstName, String LastName, String Country, String Email, int Phone, String Address) {
        this.CustomerID = CustomerID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Country = Country;
        this.Email = Email;
        this.Phone = Phone;
        this.Address = Address;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    //Constructor for a customer, needs all the variables that makes a customer
    public int getCustomerID() {
        return CustomerID;
    }

    //Getters and setters for the variables 
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAdress(String Address) {
        this.Address = Address;
    }

}
