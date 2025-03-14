package controller;

import dao.CongDanDAO;
import model.CongDan;
import model.TaiKhoan; // Giả sử bạn có lớp TaiKhoan

import java.io.IOException;
import java.sql.SQLException;
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
        if (session == null || !("QUAN_TRI".equals(session.getAttribute("vaiTro")))) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        try {
            if ("list".equals(action)) {
                List<TaiKhoan> taiKhoanList = congDanDAO.selectAllTaiKhoan(); // Dòng 46
                request.setAttribute("taiKhoanList", taiKhoanList);
                request.getRequestDispatcher("/WEB-INF/views/admin/taiKhoanList.jsp").forward(request, response);
            } else {
                response.sendRedirect("admin/dashboard");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xử lý POST (nếu cần, ví dụ: cập nhật trạng thái tài khoản)
        String action = request.getParameter("action");
        try {
            if ("updateStatus".equals(action)) {
                String soDienThoai = request.getParameter("soDienThoai");
                String trangThai = request.getParameter("trangThai");
                congDanDAO.updateTaiKhoanStatus(soDienThoai, trangThai);
                response.sendRedirect("admin/taikhoan?action=list");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}