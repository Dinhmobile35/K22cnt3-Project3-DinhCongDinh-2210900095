package com.admin.dashboard;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/admin/dashboard")
public class DashboardServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            int totalOrders = getTotalCount(conn, "orders");
            int totalProducts = getTotalCount(conn, "products");
            int totalUsers = getTotalCount(conn, "users");
            double totalRevenue = getTotalRevenue(conn);

            request.setAttribute("totalOrders", totalOrders);
            request.setAttribute("totalProducts", totalProducts);
            request.setAttribute("totalUsers", totalUsers);
            request.setAttribute("totalRevenue", totalRevenue);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/dashboard.jsp");
            dispatcher.forward(request, response);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getTotalCount(Connection conn, String tableName) throws Exception {
        String query = "SELECT COUNT(*) FROM " + tableName;
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    private double getTotalRevenue(Connection conn) throws Exception {
        String query = "SELECT SUM(total_price) FROM orders";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble(1);
        }
        return 0.0;
    }
}
