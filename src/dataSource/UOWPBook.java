
package dataSource;

import domain.Booking;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class UOWPBook {
    private ArrayList<Booking> newBooking;
    private ArrayList<Booking> modifiedBooking;
    private ArrayList<Booking> deleteBooking;

    public UOWPBook() {
        newBooking = new ArrayList<Booking>(); // will never exceed 1 element
        modifiedBooking = new ArrayList<Booking>(); // will never exceed 1 element
        deleteBooking = new ArrayList<Booking>();
    }
  //====== Methods to register changes ==========================

    public void registerNewBooking(Booking b) {
        if (!newBooking.contains(b) && // if not allready registered in any list
                !modifiedBooking.contains(b)) {
            newBooking.add(b);
        }
    }

    public void registerDirtyBooking(Booking b) {
        if (!newBooking.contains(b) && // if not allready registered in any list
                !modifiedBooking.contains(b)) {
            modifiedBooking.add(b);
        }
    }


  //====== Method to save changes to DB ===============================
    public boolean commit(Connection conn) throws SQLException {
        boolean status = true;
        try {
            //=== system transaction - start
            conn.setAutoCommit(false);
            BookingMapper bm = new BookingMapper();

            status = status && bm.addNewBooking(newBooking, conn);
            status = status && bm.updateBooking(modifiedBooking, conn);
            status = status && bm.deleteBooking(deleteBooking, conn);
            if (!status) {
                throw new Exception("Business Transaction aborted");
            }
            //=== system transaction - end with success
            conn.commit();
        } catch (Exception e) {
            System.out.println("fail in UnitOfWork - commit()");
            System.err.println(e);
            //=== system transaction - end with roll back
            conn.rollback();
            status = false;// rettelse
        }
        return status;
    }

  //====== Methods to read from DB ===================================================
    public Order getOrder(int ono, Connection con) {
        Order o = null;;
        try {
            o = new OrderMapper().getOrder(ono, con);
        } catch (Exception e) {
            System.out.println("fail in UnitOfWork - getOrder()");
            System.err.println(e);
        }
        return o;

    }

    public void registerDeletedBooking(Booking b) {
        if (!newBooking.contains(b) && // if not allready registered in any list
                !deleteBooking.contains(b)) {
            modifiedBooking.add(b);
        }
    }
}
