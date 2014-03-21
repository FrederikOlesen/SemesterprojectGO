/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author frederikolesen
 */
public class BookingMapper {
    
    public boolean addReservation(ArrayList<Order> ol, Connection conn) throws SQLException {
        int rowsInserted = 0;
        String SQLString = "insert into v_orders values (?,?,?,?,?,?)";
        PreparedStatement statement = null;
        statement = conn.prepareStatement(SQLString);

        for (int i = 0; i < ol.size(); i++) {
            Order o = ol.get(i);
            statement.setInt(1, o.getOno());
            statement.setInt(2, o.getCno());
            statement.setInt(3, o.getEno());
            statement.setString(4, o.getReceived());
            statement.setString(5, o.getShipped());
            statement.setInt(6, o.getVer());
            rowsInserted += statement.executeUpdate();
        }
        if (testRun) {
            System.out.println("insertOrders(): " + (rowsInserted == ol.size())); // for test
        }
        return (rowsInserted == ol.size());
    }
    
}
