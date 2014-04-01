package domain;

public class Rooms {

    // Variables used for room creation
    private String roomType;
    private int price;
    private String roomNumber;

    public Rooms(String roomType, String roomNumber) {
        this.roomType = roomType;
        this.price = price;
        this.roomNumber = roomNumber;
    }

    
         

    // Getters and setters
    public String getRoomType()
    {
        return roomType;
    }

    public void setRoomType(String roomType)
    {
        this.roomType = roomType;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public String getRoomNumber()
    {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber)
    {
        this.roomNumber = roomNumber;
    }

    // End of getters and setters
    
    //toString method added which returns a string of informations from contructor
    @Override
    public String toString() {
        return "roomType: " + roomType + " Price: " + price + " roomNumber: " + roomNumber;
    }

}
