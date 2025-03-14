package controller;

import dao.CongDanDAO;
import model.CongDan;
import java.sql.SQLException; // Thêm import này

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
        String cccd = request.getParameter("cccd");
        String matKhau = request.getParameter("matKhau");
        String vaiTro = request.getParameter("vaiTro");

        if (soDienThoai == null || cccd == null || matKhau == null || vaiTro == null ||
                soDienThoai.trim().isEmpty() || cccd.trim().isEmpty() || matKhau.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Vui lòng điền đầy đủ thông tin!");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        try {
            // Kiểm tra xem CCCD đã tồn tại trong DCD_CongDan chưa
            CongDan congDan = congDanDAO.selectCongDan(cccd);
            if (congDan == null) {
                request.setAttribute("errorMessage", "CCCD không tồn tại trong hệ thống!");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
                return;
            }

            // Kiểm tra xem số điện thoại đã được sử dụng chưa
            if (congDanDAO.isPhoneNumberExists(soDienThoai)) {
                request.setAttribute("errorMessage", "Số điện thoại đã được sử dụng!");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
                return;
            }

            // Đăng ký tài khoản
            boolean registered = congDanDAO.registerAccount(soDienThoai, cccd, matKhau, vaiTro);
            if (registered) {
                request.setAttribute("successMessage", "Đăng ký thành công! Vui lòng đăng nhập.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Đăng ký thất bại!");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        } catch (SQLException e) { // Dòng 64
            request.setAttribute("errorMessage", "Lỗi: " + e.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}