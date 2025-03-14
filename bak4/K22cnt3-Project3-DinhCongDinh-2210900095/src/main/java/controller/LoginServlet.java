package controller;

import dao.CongDanDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    private CongDanDAO congDanDAO;

    @Override
    public void init() {
        congDanDAO = new CongDanDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String soDienThoai = request.getParameter("soDienThoai");
        String matKhau = request.getParameter("matKhau");

        try {
            String vaiTro = congDanDAO.checkLogin(soDienThoai, matKhau);
            if (vaiTro != null) {
                HttpSession session = request.getSession();
                session.setAttribute("soDienThoai", soDienThoai);
                session.setAttribute("vaiTro", vaiTro);

                if ("QUAN_TRI".equals(vaiTro)) {
                    response.sendRedirect("admin/dashboard"); // Chuyển hướng đến Dashboard
                } else if ("NGUOI_DUNG".equals(vaiTro)) {
                    response.sendRedirect("user/congdan");
                }
            } else {
                request.setAttribute("errorMessage", "Số điện thoại hoặc mật khẩu không đúng hoặc tài khoản đã bị khóa!");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Lỗi: " + e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}