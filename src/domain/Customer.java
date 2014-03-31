package domain;

import java.util.ArrayList;

public class Customer
{

    // Variables for the customers
    private int customerID;
    private String firstName;
    private String lastName;
    private String country;
    private String email;
    private int phone;
    private String address;
    // Customer ArrayList used to store customer objects.
    ArrayList<Customer> cu = new ArrayList<>();

    // Constructor
    public Customer(int customerID, String firstName, String lastName, String country, String email, int phone, String address)
    {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // Getters and settets
    public int getCustomerID()
    {
        return customerID;
    }

    public void setCustomerID(int customerID)
    {
        this.customerID = customerID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getPhone()
    {
        return phone;
    }

    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public ArrayList<Customer> getCu()
    {
        return cu;
    }

    public void setCu(ArrayList<Customer> cu)
    {
        this.cu = cu;
    }
    // End of getters and setters

    // toString method
    @Override
    public String toString()
    {
        return "CustomerID=" + customerID + ", FirstName=" + firstName + ", LastName=" + lastName + ", Country=" + country + ", Email=" + email + ", Phone=" + phone + ", Address=" + address + '}';
    }

}
