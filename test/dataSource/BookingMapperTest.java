/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.Booking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Uffe
 */
public class BookingMapperTest {

    BookingMapper bm;
    Connection con;
    String pw = "SEM2_TEST_GR11";
    String id = "SEM2_TEST_GR11";
    boolean hej = false;

    public BookingMapperTest() {
    }

    @Before
    public void setUp() throws Exception {

        getConnection();
        Fixture.setUp(con);
        bm = new BookingMapper();

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
        if (!hej) {
            releaseConnection();
        }
    }

    @Test
    public void testSaveNewBooking() throws Exception {
        ArrayList<Booking> bl = new ArrayList();
        String arrival = "2018-03-04";
        String departure = "2019-03-04";
        Booking b = new Booking(arrival, departure, 2102, 8, 1, 212, 2);
        bl.add(b);
        boolean saveOk = bm.addNewBooking(bl, con);
        ArrayList<Booking> bl1 = bm.getBookingList(arrival, departure, con);
        assertTrue("size not 1 as expected", bl1.size() == 1);
        assertTrue("SaveNewPart failed", saveOk);

    }
    
    //=== Connection specifics
    private void getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat", id, pw);
        } catch (Exception e) {
            System.out.println("fail in getConnection()");
            System.out.println(e);
        }
    }

    //=== Connection specifics
    public void releaseConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
