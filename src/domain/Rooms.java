package domain;

public class Rooms {
    //Here be constructer
    private String roomType;
    private int price;
    private int roomNumber;
    
    //Constructor
    public String getRoomType() {
        return roomType;
    }

    public int getPrice() {
        return price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    //toString method added which returns a string of informations from contructor
    @Override
    public String toString() {
        return "Rooms{" + "roomType=" + roomType + ", price=" + price + ", roomNumber=" + roomNumber + '}';
    }
    
}
