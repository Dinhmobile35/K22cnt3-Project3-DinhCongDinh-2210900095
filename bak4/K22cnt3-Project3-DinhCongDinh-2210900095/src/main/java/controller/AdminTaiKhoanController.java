package controller;

import dao.CongDanDAO;
import model.TaiKhoan;

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
        if (session == null || session.getAttribute("soDienThoai") == null || !"QUAN_TRI".equals(session.getAttribute("vaiTro"))) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        try {
            if ("lock".equals(action)) {
                lockTaiKhoan(request, response);
            } else if ("unlock".equals(action)) {
                unlockTaiKhoan(request, response);
            } else {
                listTaiKhoan(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listTaiKhoan(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<TaiKhoan> taiKhoanList = congDanDAO.selectAllTaiKhoan();
        request.setAttribute("taiKhoanList", taiKhoanList);
        request.getRequestDispatcher("/WEB-INF/views/admin/taiKhoanList.jsp").forward(request, response);
    }

    private void lockTaiKhoan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String soDienThoai = request.getParameter("soDienThoai");
        congDanDAO.updateTaiKhoanStatus(soDienThoai, "KHOA");
        response.sendRedirect("taikhoan");
    }

    private void unlockTaiKhoan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String soDienThoai = request.getParameter("soDienThoai");
        congDanDAO.updateTaiKhoanStatus(soDienThoai, "HOAT_DONG");
        response.sendRedirect("taikhoan");
    }
}