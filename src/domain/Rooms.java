package domain;

public class Rooms {

    // Variables used for room creation
    private String roomNumber;
    private int price;
    private String roomType;

    public Rooms(String roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
    }

    // Getters and setters
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    // End of getters and setters
    //toString method added which returns a string of informations from contructor
    @Override
    public String toString() {
        return "Type: " + roomType + "      Price: " + price + "        Room number: " + roomNumber;
    }

}
