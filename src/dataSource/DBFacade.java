/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataSource;

import domain.Booking;
import java.sql.Connection;

/**
 *
 * @author frederikolesen
 */
public class DBFacade {
    private UOWPBook uow;
    private Connection con;
    private Booking b;
    
    //=====	Singleton
    private static DBFacade instance;

    private DBFacade() {
        con = new DBConnector().getConnection();  // the connection will be released upon program 
    }

    public static DBFacade getInstance() {
        if (instance == null) {
            instance = new DBFacade();
        }
        return instance;
    }

    //======	Methods to retrieve data 
    public Order getOrder(int ono) {
        Order o = null;
        o = new OrderMapper().getOrder(ono, con);
        return o;
    }

    public int getNextOrderNo() {
        int nextOno = 0;
        nextOno = new BookingMapper().getNextOrderNo(con);
        return nextOno;
    }

    //=====	Methods to register changes	in UnitOfWork  
    public void registerNewBooking(Booking b) {
        if (uow != null) {
            uow.registerNewBooking(b);
        }
    }

    public void registerDirtyBooking(Booking b) {
        if (uow != null) {
            uow.registerDirtyBooking(b);
        }
    }

    public void registerNewOrderDetail(OrderDetail od) {
        if (uow != null) {
            uow.registerNewOrderDetail(od);
        }
    }

    //=== Methods to handle business transactions
    //=====	Ignore changes after last commit
    public void startNewBusinessTransaction() {
        uow = new UOWPBook();
    }

    //=====	Save all changes
    public boolean commitBusinessTransaction() {
        boolean status = false;
        if (uow != null) {
            try {
                status = uow.commit(con);
            } catch (Exception e) {
                System.out.println("Fail in DBFacade - commitBusinessTransaction");
                System.err.println(e);
            }
            uow = null;
        }
        return status;
    }

    //=== connection specifics

    public void registerDeleteOrder(Order o) {
        if (uow !=null) {
            uow.registerDeleteOrder(o);
        }
    }   
}