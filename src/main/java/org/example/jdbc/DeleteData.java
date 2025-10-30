package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
//    private static final String URL = "jdbc:postgresql://localhost:5432/awadheshkumar";
//    private static final String USER = "postgres";
//    private static final String PASSWORD = "your_password";


    private static final String URL = "jdbc:postgresql://localhost:5432/jtrain";
    private static final String USER = "awadhesh";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try  {
            Class.forName("org.postgresql.Driver"); //1
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD) ;//2
            String sql = "DELETE FROM employee WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, 1);
                int rows = pstmt.executeUpdate();
                System.out.println("🟡 " + rows + " record(s) deleted.");
            }
        }catch (SQLException | ClassNotFoundException e){
            System.out.println(e);
        }

    }
}
