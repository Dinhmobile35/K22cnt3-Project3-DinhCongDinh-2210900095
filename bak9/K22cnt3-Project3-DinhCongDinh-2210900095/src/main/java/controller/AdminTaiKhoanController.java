package controller;

import dao.CongDanDAO;
import model.TaiKhoan;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminTaiKhoanController extends HttpServlet {
    private CongDanDAO congDanDAO;

    @Override
    public void init() {
        congDanDAO = new CongDanDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || !"QUAN_TRI".equals(session.getAttribute("vaiTro"))) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String action = request.getParameter("action");
        switch (action == null ? "list" : action) {
            case "list":
                listTaiKhoan(request, response);
                break;
            case "new":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteTaiKhoan(request, response);
                break;
            default:
                listTaiKhoan(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || !"QUAN_TRI".equals(session.getAttribute("vaiTro"))) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String action = request.getParameter("action");
        try {
            switch (action) {
                case "insert":
                    insertTaiKhoan(request, response);
                    break;
                case "update":
                    updateTaiKhoan(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/admin/taikhoan");
                    break;
            }
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Lỗi: " + e.getMessage());
            if ("insert".equals(action)) {
                try {
                    showNewForm(request, response);
                } catch (ServletException ex) {
                    throw new IOException("Không thể hiển thị form thêm tài khoản: " + ex.getMessage(), ex);
                }
            } else if ("update".equals(action)) {
                try {
                    showEditForm(request, response);
                } catch (ServletException ex) {
                    throw new IOException("Không thể hiển thị form sửa tài khoản: " + ex.getMessage(), ex);
                }
            }
        }
    }

    private void listTaiKhoan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TaiKhoan> taiKhoanList = new ArrayList<>();
        try {
            taiKhoanList = congDanDAO.selectAllTaiKhoan();
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Lỗi khi lấy danh sách tài khoản: " + e.getMessage());
        }
        request.setAttribute("taiKhoanList", taiKhoanList);
        request.getRequestDispatcher("/WEB-INF/views/admin/taikhoan.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/admin/taikhoanForm.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String soDienThoai = request.getParameter("soDienThoai");
        if (soDienThoai == null || soDienThoai.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Số điện thoại không hợp lệ!");
            listTaiKhoan(request, response);
            return;
        }
        TaiKhoan taiKhoan = null;
        try {
            taiKhoan = congDanDAO.selectAllTaiKhoan().stream()
                    .filter(t -> t.getSoDienThoai().equals(soDienThoai))
                    .findFirst()
                    .orElse(null);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Lỗi khi lấy thông tin tài khoản: " + e.getMessage());
            listTaiKhoan(request, response);
            return;
        }
        if (taiKhoan == null) {
            request.setAttribute("errorMessage", "Tài khoản không tồn tại!");
            listTaiKhoan(request, response);
            return;
        }
        request.setAttribute("taiKhoan", taiKhoan);
        request.getRequestDispatcher("/WEB-INF/views/admin/taikhoanForm.jsp").forward(request, response);
    }

    private void insertTaiKhoan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String soDienThoai = request.getParameter("soDienThoai");
        String cccd = request.getParameter("cccd");
        String matKhau = request.getParameter("matKhau");
        String vaiTro = request.getParameter("vaiTro");
        String trangThai = request.getParameter("trangThai");

        // Kiểm tra dữ liệu đầu vào
        if (soDienThoai == null || cccd == null || matKhau == null || vaiTro == null || trangThai == null ||
                soDienThoai.trim().isEmpty() || cccd.trim().isEmpty() || matKhau.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Vui lòng điền đầy đủ thông tin!");
            try {
                showNewForm(request, response);
            } catch (ServletException e) {
                throw new IOException("Không thể hiển thị form thêm tài khoản: " + e.getMessage(), e);
            }
            return;
        }

        // Kiểm tra số điện thoại đã tồn tại
        try {
            if (congDanDAO.isPhoneNumberExists(soDienThoai)) {
                request.setAttribute("errorMessage", "Số điện thoại đã tồn tại!");
                try {
                    showNewForm(request, response);
                } catch (ServletException e) {
                    throw new IOException("Không thể hiển thị form thêm tài khoản: " + e.getMessage(), e);
                }
                return;
            }
        } catch (SQLException e) {
            throw new SQLException("Lỗi khi kiểm tra số điện thoại: " + e.getMessage(), e);
        }

        // Thêm tài khoản
        congDanDAO.insertTaiKhoan(soDienThoai, cccd, matKhau, vaiTro, trangThai);
        response.sendRedirect(request.getContextPath() + "/admin/taikhoan");
    }

    private void updateTaiKhoan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String soDienThoai = request.getParameter("soDienThoai");
        String cccd = request.getParameter("cccd");
        String matKhau = request.getParameter("matKhau");
        String vaiTro = request.getParameter("vaiTro");
        String trangThai = request.getParameter("trangThai");

        // Kiểm tra dữ liệu đầu vào
        if (soDienThoai == null || cccd == null || matKhau == null || vaiTro == null || trangThai == null ||
                soDienThoai.trim().isEmpty() || cccd.trim().isEmpty() || matKhau.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Vui lòng điền đầy đủ thông tin!");
            try {
                showEditForm(request, response);
            } catch (ServletException e) {
                throw new IOException("Không thể hiển thị form sửa tài khoản: " + e.getMessage(), e);
            }
            return;
        }

        // Cập nhật tài khoản
        congDanDAO.updateTaiKhoan(soDienThoai, cccd, matKhau, vaiTro, trangThai);
        response.sendRedirect(request.getContextPath() + "/admin/taikhoan");
    }

    private void deleteTaiKhoan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String soDienThoai = request.getParameter("soDienThoai");
        if (soDienThoai == null || soDienThoai.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Số điện thoại không hợp lệ!");
            listTaiKhoan(request, response);
            return;
        }
        try {
            congDanDAO.updateTaiKhoanStatus(soDienThoai, "KHOA"); // Chuyển trạng thái thành "KHOA"
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Lỗi khi xóa tài khoản: " + e.getMessage());
            listTaiKhoan(request, response);
            return;
        }
        response.sendRedirect(request.getContextPath() + "/admin/taikhoan");
    }
}