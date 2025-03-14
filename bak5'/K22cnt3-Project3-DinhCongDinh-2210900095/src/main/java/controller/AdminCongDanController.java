package controller;

import dao.CongDanDAO;
import model.CongDan;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminCongDanController extends HttpServlet {
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
            switch (action == null ? "list" : action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteCongDan(request, response);
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
        if (session == null || session.getAttribute("soDienThoai") == null || !"QUAN_TRI".equals(session.getAttribute("vaiTro"))) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        try {
            switch (action) {
                case "insert":
                    insertCongDan(request, response);
                    break;
                case "update":
                    updateCongDan(request, response);
                    break;
                default:
                    response.sendRedirect("congdan");
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listCongDan(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<CongDan> congDanList = congDanDAO.selectAllCongDan();
        request.setAttribute("congDanList", congDanList);
        request.getRequestDispatcher("/WEB-INF/views/admin/congDanList.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/admin/congDanForm.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String cccd = request.getParameter("cccd");
        CongDan congDan = congDanDAO.selectCongDan(cccd);
        request.setAttribute("congDan", congDan);
        request.getRequestDispatcher("/WEB-INF/views/admin/congDanForm.jsp").forward(request, response);
    }

    private void insertCongDan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String cccd = request.getParameter("cccd");
        String hoTen = request.getParameter("hoTen");
        Date ngaySinh = Date.valueOf(request.getParameter("ngaySinh"));
        String gioiTinh = request.getParameter("gioiTinh");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");
        String diaChi = request.getParameter("diaChi");
        Date ngayCap = Date.valueOf(request.getParameter("ngayCap"));
        Date ngayHetHan = Date.valueOf(request.getParameter("ngayHetHan"));

        CongDan congDan = new CongDan(cccd, hoTen, ngaySinh, gioiTinh, soDienThoai, email, diaChi, ngayCap, ngayHetHan, null);
        congDanDAO.insertCongDan(congDan);
        response.sendRedirect("congdan");
    }

    private void updateCongDan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String cccd = request.getParameter("cccd");
        String hoTen = request.getParameter("hoTen");
        Date ngaySinh = Date.valueOf(request.getParameter("ngaySinh"));
        String gioiTinh = request.getParameter("gioiTinh");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");
        String diaChi = request.getParameter("diaChi");
        Date ngayCap = Date.valueOf(request.getParameter("ngayCap"));
        Date ngayHetHan = Date.valueOf(request.getParameter("ngayHetHan"));

        CongDan congDan = new CongDan(cccd, hoTen, ngaySinh, gioiTinh, soDienThoai, email, diaChi, ngayCap, ngayHetHan, null);
        congDanDAO.updateCongDan(congDan);
        response.sendRedirect("congdan");
    }

    private void deleteCongDan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String cccd = request.getParameter("cccd");
        congDanDAO.deleteCongDan(cccd);
        response.sendRedirect("congdan");
    }
}