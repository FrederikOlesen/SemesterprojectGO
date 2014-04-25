/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataSource;

import domain.Booking;
import domain.Customer;
import domain.SportsBooking;
import java.sql.Connection;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Uffe
 */
public class BookingMapperTest {
    
    public BookingMapperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addNewBooking method, of class BookingMapper.
     */
    @Test
    public void testAddNewBooking() throws Exception {
        System.out.println("addNewBooking");
        Booking booking = new Booking("","",0,0,0,0,0);
        ArrayList<Booking> bl = null;
        bl.add(booking);
        Connection conn = null;
        BookingMapper instance = new BookingMapper();
        boolean expResult = true;
        boolean result = instance.addNewBooking(bl, conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addNewCustomer method, of class BookingMapper.
     */
    @Test
    public void testAddNewCustomer() throws Exception {
        System.out.println("addNewCustomer");
        ArrayList<Customer> cu = null;
        Connection conn = null;
        BookingMapper instance = new BookingMapper();
        boolean expResult = false;
        boolean result = instance.addNewCustomer(cu, conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNextResNumber method, of class BookingMapper.
     */
    @Test
    public void testGetNextResNumber() {
        System.out.println("getNextResNumber");
        Connection conn = null;
        BookingMapper instance = new BookingMapper();
        int expResult = 0;
        int result = instance.getNextResNumber(conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findResNumber method, of class BookingMapper.
     */
    @Test
    public void testFindResNumber() {
        System.out.println("findResNumber");
        int resNo = 0;
        Connection conn = null;
        BookingMapper instance = new BookingMapper();
        Booking expResult = null;
        Booking result = instance.findResNumber(resNo, conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNextCustomerID method, of class BookingMapper.
     */
    @Test
    public void testGetNextCustomerID() {
        System.out.println("getNextCustomerID");
        Connection conn = null;
        BookingMapper instance = new BookingMapper();
        int expResult = 0;
        int result = instance.getNextCustomerID(conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomer method, of class BookingMapper.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        String lname = "";
        Connection conn = null;
        BookingMapper instance = new BookingMapper();
        ArrayList expResult = null;
        ArrayList result = instance.getCustomer(lname, conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateBooking method, of class BookingMapper.
     */
    @Test
    public void testUpdateBooking() throws Exception {
        System.out.println("updateBooking");
        ArrayList<Booking> bl = null;
        Connection conn = null;
        BookingMapper instance = new BookingMapper();
        boolean expResult = false;
        boolean result = instance.updateBooking(bl, conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getBookingList method, of class BookingMapper.
     */
    @Test
    public void testGetBookingList() {
        System.out.println("getBookingList");
        String arrival = "";
        String departure = "";
        Connection conn = null;
        BookingMapper instance = new BookingMapper();
        ArrayList expResult = null;
        ArrayList result = instance.getBookingList(arrival, departure, conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerFromID method, of class BookingMapper.
     */
    @Test
    public void testGetCustomerFromID() {
        System.out.println("getCustomerFromID");
        String customerID = "";
        Connection conn = null;
        BookingMapper instance = new BookingMapper();
        ArrayList expResult = null;
        ArrayList result = instance.getCustomerFromID(customerID, conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomsList method, of class BookingMapper.
     */
    @Test
    public void testGetRoomsList() {
        System.out.println("getRoomsList");
        String arrival = "";
        String departure = "";
        Connection conn = null;
        BookingMapper instance = new BookingMapper();
        ArrayList expResult = null;
        ArrayList result = instance.getRoomsList(arrival, departure, conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBooking method, of class BookingMapper.
     */
    @Test
    public void testDeleteBooking() {
        System.out.println("deleteBooking");
        ArrayList<Booking> deleteBooking = null;
        Connection conn = null;
        BookingMapper instance = new BookingMapper();
        boolean expResult = false;
        boolean result = instance.deleteBooking(deleteBooking, conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of lookAtResNumber method, of class BookingMapper.
     */
    @Test
    public void testLookAtResNumber() {
        System.out.println("lookAtResNumber");
        int resNumber = 0;
        Connection conn = null;
        BookingMapper instance = new BookingMapper();
        String expResult = "";
        String result = instance.lookAtResNumber(resNumber, conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createCustomerID method, of class BookingMapper.
     */
    @Test
    public void testCreateCustomerID() {
        System.out.println("createCustomerID");
        int resNumber = 0;
        int noOfGuests = 0;
        Connection conn = null;
        BookingMapper instance = new BookingMapper();
        boolean expResult = false;
        boolean result = instance.createCustomerID(resNumber, noOfGuests, conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addNewSportsBooking method, of class BookingMapper.
     */
    @Test
    public void testAddNewSportsBooking() throws Exception {
        System.out.println("addNewSportsBooking");
        ArrayList<SportsBooking> sb1 = null;
        Connection conn = null;
        BookingMapper instance = new BookingMapper();
        boolean expResult = false;
        boolean result = instance.addNewSportsBooking(sb1, conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addTrainerToBooking method, of class BookingMapper.
     */
    @Test
    public void testAddTrainerToBooking() throws Exception {
        System.out.println("addTrainerToBooking");
        Connection conn = null;
        BookingMapper instance = new BookingMapper();
        boolean expResult = false;
        boolean result = instance.addTrainerToBooking(conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of countBookingsForSportsId method, of class BookingMapper.
     */
    @Test
    public void testCountBookingsForSportsId() {
        System.out.println("countBookingsForSportsId");
        Connection conn = null;
        String date = "";
        String sportsID = "";
        BookingMapper instance = new BookingMapper();
        int expResult = 0;
        int result = instance.countBookingsForSportsId(conn, date, sportsID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
