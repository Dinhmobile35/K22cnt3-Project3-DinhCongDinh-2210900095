package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DatabaseConnection {
    // Không dùng static connection nữa, tạo mới mỗi lần
    public static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Không tìm thấy file config.properties");
            }
            props.load(input);
            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");
            return DriverManager.getConnection(url, username, password); // Trả về kết nối mới
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối database: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.err.println("Lỗi đọc file cấu hình: " + e.getMessage());
            throw new RuntimeException("Không thể kết nối database", e);
        }
    }
}