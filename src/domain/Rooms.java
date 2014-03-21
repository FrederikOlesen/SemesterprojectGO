package domain;

public class Rooms {
    
    private String roomType;
    private int price;
    private int roomNumber;

    public String getRoomType() {
        return roomType;
    }

    public int getPrice() {
        return price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return "Rooms{" + "roomType=" + roomType + ", price=" + price + ", roomNumber=" + roomNumber + '}';
    }
    
}
