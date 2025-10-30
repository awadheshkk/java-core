package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
        private static final String URL = "jdbc:postgresql://localhost:5432/jtrain";
        private static final String USER = "awadhesh";
        private static final String PASSWORD = "mypassword";

        public static void main(String[] args) throws ClassNotFoundException {

            try  {
                Class.forName("org.postgresql.Driver"); //1
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);//2
                String sql = "INSERT INTO employee (ID, NAME) VALUES (?,?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    pstmt.setInt(1, 2);
                    pstmt.setString(2, "Spandana");
                    int rows = pstmt.executeUpdate();
                    System.out.println("🟡 " + rows + " record(s) inserted.");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
}
