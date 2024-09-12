package Default;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Jib;

public class DBConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/jib?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // รหัสผ่านฐานข้อมูล

    public boolean insertNewJib(Jib jib) {
        boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // โหลดไดรเวอร์
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // เชื่อมต่อกับฐานข้อมูล
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // คำสั่ง SQL สำหรับเพิ่มข้อมูล
            String query = "INSERT INTO jib_oder (jibName, jibType, jibPrice) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);

            // ตั้งค่าพารามิเตอร์ของ PreparedStatement
            preparedStatement.setString(1, jib.getName());
            preparedStatement.setString(2, jib.getType());
            preparedStatement.setString(3, String.valueOf(jib.getPrice())); // แปลงเป็น String

            // ดำเนินการคำสั่ง SQL
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                result = true;
            } else {
                System.out.println("Insert operation failed. Rows affected: " + rowsAffected);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } finally {
            // ปิดการเชื่อมต่อ
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
