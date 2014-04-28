package dataSource;

import java.sql.*;

public class Fixture {

    int resnumber = 0;

    // sets up the tables
    public static void setUp(Connection con) {
        try {

            Statement st = con.createStatement();

            // start transaction
            con.setAutoCommit(false);

            // create table
            st.addBatch("delete from booking");
            st.addBatch("delete from customer");
            st.addBatch("delete from rooms");

            // insert tuples
            String insertbooking = "insert into booking values ";
            String insertroom = "insert into rooms values";
            String insertcustomer = "insert into customer values";
            st.addBatch(insertroom + "(100,2,100)");
            st.addBatch(insertcustomer + "(123456798,'Hej', 'Hejsa', 'Denmark', 'Asdas@ªsd.com', 12345678, 'asdsadas')");
            st.addBatch(insertbooking + "(2014-03-02,2015-03-04,601,3,1,1234567, 2) ");
            int[] opcounts = st.executeBatch();
            if (opcounts.length != 9) {
                throw new Exception();
            }
            // end transaction
            System.out.println("opcounts.length = " + opcounts.length);
            con.commit();
        } catch (Exception e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            System.out.println("Fail in Fixture.setup()");
            System.out.println(e.getMessage());
        }
    }
}
