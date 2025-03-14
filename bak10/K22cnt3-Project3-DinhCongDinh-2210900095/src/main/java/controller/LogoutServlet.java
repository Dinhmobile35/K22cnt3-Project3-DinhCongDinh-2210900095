package controller;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(LogoutServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleLogout(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleLogout(request, response);
    }

    private void handleLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String soDienThoai = null;

        // Lấy số điện thoại trước khi hủy session để ghi log
        if (session != null) {
            soDienThoai = (String) session.getAttribute("soDienThoai");
            session.invalidate();
            LOGGER.info("User logged out: " + (soDienThoai != null ? soDienThoai : "Unknown"));
        } else {
            LOGGER.info("Logout attempt with no active session.");
        }

        // Thêm thông báo đăng xuất thành công
        request.setAttribute("message", "Đăng xuất thành công!");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}