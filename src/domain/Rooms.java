package domain;

public class Rooms {
    
    private String roomType;
    private int price;
    private int roomNumber;

    //Here be constructer
    public Rooms(String roomType, int price, int roomNumber) {
        this.roomType = roomType;
        this.price = price;
        this.roomNumber = roomNumber;
    }
    
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
