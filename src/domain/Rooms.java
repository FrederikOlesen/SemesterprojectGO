package domain;

public class Rooms {
    
    private String roomType;
    private int price;
    private String roomNumber;

    //Here be constructer
//    public Rooms(String roomType, int price, String roomNumber) {
//        this.roomType = roomType;
//        this.price = price;
//        this.roomNumber = roomNumber;
//    }
    
    public String getRoomType() {
        return roomType;
    }

    public int getPrice() {
        return price;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    //toString method added which returns a string of informations from contructor
    @Override
    public String toString() {
        return "Rooms{" + "roomType=" + roomType + ", price=" + price + ", roomNumber=" + roomNumber + '}';
    }
    
}
