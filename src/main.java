
import dataSource.BookingMapper;
import dataSource.DBConnector;
import domain.Booking;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author frederikolesen
 */
public class main {

    public static void main(String[] args) {
        
        BookingMapper bm = new BookingMapper();
        
        Booking b = new Booking();
        
        DBConnector dbc = new DBConnector();
        
        bm.getNextResNumber(dbc.getConnection());
    }
}
