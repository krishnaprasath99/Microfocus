package org.apache.http.examples.client;


import java.sql.*;

/**
 *
 * @author postgresqltutorial.com
 */
public class dbconnect{

    private final String url = "jdbc:postgresql://localhost/testdb";
    private final String user = "postgres";
    private final String password = "krishna";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public void connect(String fieldName, String ss1) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            System.out.println("Connected to the PostgreSQL server successfully.");

            String str = "create table table2 ( key varchar(255), links varchar(255));";
            PreparedStatement statement = conn.prepareStatement(str);
            statement.executeQuery();
            String s1="b",s2="b";
            String str1 = "INSERT INTO table1(key, links) VALUES('"+fieldName+"','"+ss1+"');";
            PreparedStatement statement1 = conn.prepareStatement(str1);
            System.out.println("**************");
            statement1.executeUpdate();

            String query = "SELECT * FROM table1";
            PreparedStatement stmt2 = conn.prepareStatement(query);
            stmt2.execute();
            ResultSet rs2 = stmt2.getResultSet();
            System.out.println("display");

            while(rs2.next())
            {
                System.out.print(rs2.getString(1));
                System.out.print("   ");
                System.out.println(rs2.getString(2));
                rs2.next();
            }


            System.out.println("**************");
            //System.out.println(rs1);
            System.out.println("**************");
            //ResultSet rs = pst.executeQuery();
            System.out.println("Inserted successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        //return conn;
    }

    /**
     * @param args the command line arguments
     */

}
