package org.example.jdbc;

import java.sql.*;

public class CallStoredProcExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/jtrain";
        String user = "awadhesh";
        String password = "mypassword";

        Connection conn = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;

        try {
            // Load driver (optional for modern JDBC)
            Class.forName("org.postgresql.Driver");

            // Connect to DB
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false); // Required for cursors

            // Prepare callable statement
            cstmt = conn.prepareCall("{ call EMPLOYEE_SP(?, ?) }");

            // Set IN parameter
            cstmt.setLong(1, 2); // Example ID

            // Register OUT parameter as REFCURSOR
          //  cstmt.registerOutParameter(2, Types.OTHER);

            // Execute procedure
            cstmt.execute();

            // Get cursor name
            rs = (ResultSet) cstmt.getObject(2);

            // Iterate through result set
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");


                System.out.println(id + " | " + name);
            }

            conn.commit(); // Close transaction

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (cstmt != null) cstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}