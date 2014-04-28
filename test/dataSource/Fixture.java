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
            st.addBatch("delete from sportsbooking");
            st.addBatch("delete from customersportsid");
            st.addBatch("delete from booking");

            // insert tuples
            int[] opcounts = st.executeBatch();
            
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
