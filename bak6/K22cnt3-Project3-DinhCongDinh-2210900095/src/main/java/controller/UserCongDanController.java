package controller;

import dao.CongDanDAO;
import model.CongDan;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserCongDanController extends HttpServlet {
    private CongDanDAO congDanDAO;

    @Override
    public void init() {
        congDanDAO = new CongDanDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("soDienThoai") == null || !"NGUOI_DUNG".equals(session.getAttribute("vaiTro"))) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        try {
            switch (action == null ? "list" : action) {
                case "view":
                    viewCongDan(request, response);
                    break;
                default:
                    listCongDan(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("soDienThoai") == null || !"NGUOI_DUNG".equals(session.getAttribute("vaiTro"))) {
            response.sendRedirect("login.jsp");
            return;
        }
    }

    private void listCongDan(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<CongDan> congDanList = congDanDAO.selectAllCongDan();
        request.setAttribute("congDanList", congDanList);
        request.getRequestDispatcher("/WEB-INF/views/user/congDanList.jsp").forward(request, response);
    }

    private void viewCongDan(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String cccd = request.getParameter("cccd");
        CongDan congDan = congDanDAO.selectCongDan(cccd);
        if (congDan == null) {
            request.setAttribute("error", "Không tìm thấy công dân với CCCD: " + cccd);
            request.getRequestDispatcher("/WEB-INF/views/user/error.jsp").forward(request, response);
        } else {
            request.setAttribute("congDan", congDan);
            request.getRequestDispatcher("/WEB-INF/views/user/congDanView.jsp").forward(request, response);
        }
    }
}