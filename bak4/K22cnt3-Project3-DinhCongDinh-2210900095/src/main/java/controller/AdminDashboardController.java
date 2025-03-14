package controller;

import dao.CongDanDAO;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminDashboardController extends HttpServlet {
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

        try {
            int totalCongDan = congDanDAO.countCongDan();
            int totalTaiKhoan = congDanDAO.countTaiKhoan();
            int lockedTaiKhoan = congDanDAO.countLockedTaiKhoan();

            request.setAttribute("totalCongDan", totalCongDan);
            request.setAttribute("totalTaiKhoan", totalTaiKhoan);
            request.setAttribute("lockedTaiKhoan", lockedTaiKhoan);

            request.getRequestDispatcher("/WEB-INF/views/admin/dashboard.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}