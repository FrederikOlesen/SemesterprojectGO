package domain;

public class Rooms {

    // Variables used for room creation
    private String roomType;
    private int price;
    private String roomNumber;

    // Getters and setters
    public String getRoomType() {
        return roomType;
    }

    public int getPrice() {
        return price;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
    // End of getters and setters
    
    //toString method added which returns a string of informations from contructor
    @Override
    public String toString() {
        return "Rooms{" + "roomType=" + roomType + ", price=" + price + ", roomNumber=" + roomNumber + '}';
    }

}
