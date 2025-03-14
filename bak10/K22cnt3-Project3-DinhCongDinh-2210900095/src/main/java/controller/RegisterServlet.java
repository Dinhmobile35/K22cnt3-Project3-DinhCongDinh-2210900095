package controller;

import dao.CongDanDAO;
import model.CongDan;
import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    private CongDanDAO congDanDAO;

    @Override
    public void init() {
        congDanDAO = new CongDanDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String soDienThoai = request.getParameter("soDienThoai");
        String matKhau = request.getParameter("matKhau");
        String vaiTro = "NGUOI_DUNG"; // Mặc định vai trò là người dùng

        if (soDienThoai == null || matKhau == null || soDienThoai.trim().isEmpty() || matKhau.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Vui lòng điền đầy đủ thông tin!");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        try {
            // Kiểm tra xem số điện thoại đã được sử dụng chưa
            if (congDanDAO.isPhoneNumberExists(soDienThoai)) {
                request.setAttribute("errorMessage", "Số điện thoại đã được sử dụng!");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
                return;
            }

            // Đăng ký tài khoản với số điện thoại và mật khẩu
            boolean registered = congDanDAO.registerAccount(soDienThoai, null, matKhau, vaiTro);
            if (registered) {
                request.setAttribute("successMessage", "Đăng ký thành công! Vui lòng đăng nhập.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Đăng ký thất bại!");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Lỗi: " + e.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
