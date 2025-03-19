package controller;

import dao.*;
import model.*;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null) path = "/login";

        DCD_CongDanDAO congDanDAO = new DCD_CongDanDAO();

        if ("logout".equals(request.getParameter("logout"))) {
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        switch (path) {
            case "/login":
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                break;
            case "/register":
                request.getRequestDispatcher("/register.jsp").forward(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null) path = "/login";

        DCD_CongDanDAO congDanDAO = new DCD_CongDanDAO();

        switch (path) {
            case "/login":
                String cccd = request.getParameter("cccd");
                String matKhau = request.getParameter("matKhau");
                System.out.println("Đăng nhập với CCCD: " + cccd + ", MatKhau: " + matKhau);
                DCD_CongDan congDan = congDanDAO.getByCCCD(cccd);

                if (congDan != null && congDan.getDCD_MatKhau() != null && congDan.getDCD_MatKhau().equals(matKhau)) {
                    request.getSession().setAttribute("congDan", congDan);
                    System.out.println("Đăng nhập thành công cho: " + cccd);
                    if (cccd.startsWith("000")) {
                        System.out.println("Chuyển hướng đến: /views/admin/index.jsp");
                        request.getRequestDispatcher("/views/admin/index.jsp").forward(request, response);
                    } else {
                        System.out.println("Chuyển hướng đến:/views/user/index.jsp");
                        request.getRequestDispatcher("/views/user/index.jsp").forward(request, response);
                    }
                } else {
                    System.out.println("Đăng nhập thất bại cho CCCD: " + cccd + ", MatKhau: " + matKhau + ", CongDan: " + congDan);
                    request.setAttribute("error", "CCCD hoặc mật khẩu không đúng!");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
                break;
            case "/register":
                String newCCCD = request.getParameter("cccd");
                String newMatKhau = request.getParameter("matKhau");
                String hoTen = request.getParameter("hoTen");
                String ngaySinh = request.getParameter("ngaySinh");
                String gioiTinh = request.getParameter("gioiTinh");
                String diaChi = request.getParameter("diaChi");

                DCD_CongDan newCongDan = new DCD_CongDan();
                newCongDan.setDCD_CCCD(newCCCD);
                newCongDan.setDCD_MatKhau(newMatKhau);
                newCongDan.setDCD_HoTen(hoTen);
                newCongDan.setDCD_NgaySinh(Date.valueOf(ngaySinh));
                newCongDan.setDCD_GioiTinh(gioiTinh);
                newCongDan.setDCD_DiaChi(diaChi);
                newCongDan.setDCD_TrangThai("Hoạt động");
                newCongDan.setDCD_NgayTao(new Date(System.currentTimeMillis()));

                if (congDanDAO.create(newCongDan)) {
                    response.sendRedirect(request.getContextPath() + "/login");
                } else {
                    request.setAttribute("error", "Đăng ký thất bại!");
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                }
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}