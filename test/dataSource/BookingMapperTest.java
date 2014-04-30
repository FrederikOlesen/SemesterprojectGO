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

public class BookingMapperTest {

    //Initializing objects.
    BookingMapper bm;
    Connection con;
    String pw = "SEM2_GR11";
    String id = "SEM2_GR11";
    boolean test = false;

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
        if (!test) {
            releaseConnection();
        }
    }

    //This method test save a booking in our program. 
    @Test
    public void testSaveNewBooking() throws Exception {
        ArrayList<Booking> bl = new ArrayList();
        String arrival = "2018-03-04";
        String departure = "2019-03-04";
        int resnumber = bm.getNextResNumber(con);
        Booking b = new Booking(arrival, departure, resnumber, 1, 1, 2, 2);
        bl.add(b);
        boolean saveOk = bm.addNewBooking(bl, con);

        ArrayList<Booking> bl1 = bm.getBookingList(arrival, departure, con);

        assertTrue("size not 1 as expected", bl1.size() == 1);
        assertTrue("SaveNewBooking failed", saveOk);

    }

    //This method test the opportunity of updating a booking.
    @Test
    public void testUpdateBooking() throws Exception {
        ArrayList<Booking> bl = new ArrayList();
        Booking b = new Booking("2014-02-03", "2014-03-03", 3212, 1, 12, 2, 2);
        bl.add(b);
        boolean saveOk = bm.addNewBooking(bl, con);
        b.setArrival("2014-02-06");
        boolean updateOK = bm.updateBooking(bl, con);
        //== return value correct?
        assertTrue("UpdateBooking failed1", updateOK);
        String arrival = "2014-02-06";
        String departure = "2014-03-03";
        ArrayList<Booking> bl2 = bm.getBookingList(arrival, departure, con);

        //== end state correct?
        assertEquals(bl2.get(0).getArrival(), "2014-02-06");
    }

    //Its also possible to delete a booking. This method test that.
    @Test
    public void testDeleteBooking() throws Exception {
        ArrayList<Booking> bl = new ArrayList();
        Booking b = new Booking("2014-02-06", "2014-03-03", 3212, 1, 12, 2, 2);
        bl.add(b);
        boolean saveOk = bm.addNewBooking(bl, con);

        boolean deleteOK = bm.deleteBooking(bl, con);
        //== return value correct?
        assertTrue("DeleteBooking failed1", deleteOK);

        String arrival = "2014-02-06";
        String departure = "2014-03-03";

        ArrayList<Booking> bl1 = bm.getBookingList(arrival, departure, con);
        for (int i = 0; i < bl1.size(); i++) {
            System.out.println(bl1.get(i));
        }
        assertFalse("size not 1 as expected", bl1.size() == 1);
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
