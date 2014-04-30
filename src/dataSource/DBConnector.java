package dataSource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

    //Credentials used to access our database
    private static String id = "SEM2_GR11";						
    private static String pw = "SEM2_GR11";

    //Method to establish connection to database
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat", id, pw);
        } catch (Exception e) {
            System.out.println("\n*** Remember to insert your Oracle ID and PW in the DBConnector class! ***\n");
            System.out.println("eror in DBConnector.getConnection()");
            System.out.println(e);
        }

        return con;
    }

    //Method to close the connection.
    public void releaseConnection(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
