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
        // Lấy dữ liệu từ form
        String cccd = request.getParameter("cccd");
        String soDienThoai = request.getParameter("soDienThoai");
        String matKhau = request.getParameter("matKhau");
        String vaiTro = "NGUOI_DUNG"; // Vai trò mặc định là người dùng

        // Kiểm tra dữ liệu đầu vào
        if (cccd == null || soDienThoai == null || matKhau == null ||
                cccd.trim().isEmpty() || soDienThoai.trim().isEmpty() || matKhau.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Vui lòng điền đầy đủ thông tin!");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        try {
            // Kiểm tra xem số điện thoại đã tồn tại chưa
            if (congDanDAO.isPhoneNumberExists(soDienThoai)) {
                request.setAttribute("errorMessage", "Số điện thoại đã được sử dụng!");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
                return;
            }

            // Kiểm tra xem CCCD có tồn tại trong bảng DCD_CongDan không
            if (!congDanDAO.isCccdExists(cccd)) {
                request.setAttribute("errorMessage", "Số CCCD không tồn tại trong hệ thống!");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
                return;
            }

            // Đăng ký tài khoản với CCCD, số điện thoại và mật khẩu
            boolean registered = congDanDAO.registerAccount(soDienThoai, cccd, matKhau, vaiTro);
            if (registered) {
                request.setAttribute("successMessage", "Đăng ký thành công! Vui lòng đăng nhập.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Đăng ký thất bại! Vui lòng thử lại.");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Lỗi hệ thống: " + e.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}