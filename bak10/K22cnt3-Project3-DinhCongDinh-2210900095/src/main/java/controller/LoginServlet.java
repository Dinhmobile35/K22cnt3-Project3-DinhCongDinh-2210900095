package controller;

import dao.CongDanDAO;
import model.CongDan;

import java.io.IOException;
import java.sql.SQLException;
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

                // Lấy thông tin công dân đầy đủ
                CongDan congDan = congDanDAO.getCongDanByPhone(soDienThoai);
                if (congDan != null) {
                    session.setAttribute("cccd", congDan.getCccd());
                    session.setAttribute("hoTen", congDan.getHoTen());
                    session.setAttribute("ngaySinh", congDan.getNgaySinh());
                    session.setAttribute("gioiTinh", congDan.getGioiTinh());
                    session.setAttribute("soDienThoai", congDan.getSoDienThoai());
                    session.setAttribute("email", congDan.getEmail());
                    session.setAttribute("diaChi", congDan.getDiaChi());
                    session.setAttribute("ngayCap", congDan.getNgayCap());
                    session.setAttribute("ngayHetHan", congDan.getNgayHetHan());
                }

                // Chuyển hướng dựa trên vai trò với context path
                String contextPath = request.getContextPath();
                if ("QUAN_TRI".equals(vaiTro)) {
                    response.sendRedirect(contextPath + "/admin/dashboard");
                } else if ("NGUOI_DUNG".equals(vaiTro)) {
                    response.sendRedirect(contextPath + "/user/userDashboard");
                } else {
                    session.invalidate();
                    request.setAttribute("error", "Vai trò không hợp lệ!");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error", "Số điện thoại hoặc mật khẩu không đúng!");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}