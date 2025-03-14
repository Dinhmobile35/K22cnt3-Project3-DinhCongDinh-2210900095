package util; // Thay vì com.dinhcongdin.project3.util

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DatabaseConnection {
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
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Không thể kết nối database", e);
        }
    }
}