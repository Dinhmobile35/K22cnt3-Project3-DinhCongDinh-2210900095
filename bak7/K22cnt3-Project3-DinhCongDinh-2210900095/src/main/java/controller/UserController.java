package controller;

import dao.CongDanDAO;
import model.CongDan;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserController extends HttpServlet {
    private CongDanDAO congDanDAO;

    @Override
    public void init() {
        congDanDAO = new CongDanDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("soDienThoai") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        if ("dashboard".equals(action) || action == null) {
            showDashboard(request, response);
        } else if ("editProfile".equals(action)) {
            showEditProfile(request, response);
        } else if ("capLaiRequest".equals(action)) {
            showCapLaiRequestForm(request, response);
        } else if ("chinhSuaRequest".equals(action)) {
            showChinhSuaRequestForm(request, response);
        } else if ("doiMatKhauRequest".equals(action)) {
            showDoiMatKhauRequestForm(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xử lý form submit (chưa triển khai chi tiết)
        response.sendRedirect("userDashboard?action=dashboard");
    }

    private void showDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/user/userDashboard.jsp").forward(request, response);
    }

    private void showEditProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ session hoặc cơ sở dữ liệu
        request.getRequestDispatcher("/WEB-INF/views/user/editProfile.jsp").forward(request, response);
    }

    private void showCapLaiRequestForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/user/capLaiRequest.jsp").forward(request, response);
    }

    private void showChinhSuaRequestForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/user/chinhSuaRequest.jsp").forward(request, response);
    }

    private void showDoiMatKhauRequestForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/user/doiMatKhauRequest.jsp").forward(request, response);
    }
}