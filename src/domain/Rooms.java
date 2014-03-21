/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 *
 * @author frederikolesen
 */
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
