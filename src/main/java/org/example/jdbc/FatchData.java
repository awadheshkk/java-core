package org.example.jdbc;

import java.sql.*;

public class FatchData {
    private static final String URL = "jdbc:postgresql://localhost:5432/jtrain";
    private static final String USER = "awadhesh";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try  {
            Class.forName("org.postgresql.Driver"); //1
             conn = DriverManager.getConnection(URL, USER, PASSWORD) ;//2
            System.out.println("✅ Connected to PostgreSQL successfully.");

            String sql = "SELECT * FROM EMPLOYEE";
            try  {
                stmt = conn.createStatement();//3
                stmt.execute(sql); //4
                rs = stmt.getResultSet(); //5
                while (rs.next()) {//5
                    System.out.println(rs.getLong("ID") + ", " + rs.getString("NAME"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 4. Close resources in reverse order of creation
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing ResultSet: " + e.getMessage());
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing Statement: " + e.getMessage());
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing Connection: " + e.getMessage());
            }
        }

   long id = 2L;

        try  {
            Class.forName("org.postgresql.Driver"); //1
            conn = DriverManager.getConnection(URL, USER, PASSWORD) ;//2
            System.out.println("✅ Connected to PostgreSQL successfully.");

            String sql = "SELECT * FROM EMPLOYEE WHERE ID=? "; // '434 OR 1=1'
            try  { //2
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setLong(1,id);
              //  pstmt.setString(2,"Awadhesh");

                pstmt.executeQuery(); //3
                rs = pstmt.getResultSet(); //4
                while (rs.next()) {//5
                    System.out.println(rs.getLong("ID") + ", " + rs.getString("NAME"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }