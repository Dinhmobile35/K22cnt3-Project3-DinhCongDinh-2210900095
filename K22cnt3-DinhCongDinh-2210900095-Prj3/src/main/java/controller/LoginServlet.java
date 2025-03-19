package controller;

import dao.DCD_CongDanDAO;
import model.DCD_CongDan;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private DCD_CongDanDAO congDanDAO;

    public void init() {
        congDanDAO = new DCD_CongDanDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cccd = request.getParameter("cccd");
        String matKhau = request.getParameter("matKhau");

        DCD_CongDan congDan = congDanDAO.login(cccd, matKhau);
        if (congDan != null) {
            HttpSession session = request.getSession();
            session.setAttribute("cccd", congDan.getDCD_CCCD());
            session.setAttribute("vaiTro", congDan.getDCD_VaiTro()); // Lưu vai trò vào session

            // Phân quyền dựa trên vai trò
            if ("QUAN_TRI".equals(congDan.getDCD_VaiTro())) {
                // Sử dụng forward thay vì sendRedirect
                request.getRequestDispatcher("WEB-INF/views/admin/dashboard.jsp").forward(request, response);
            } else if ("NGUOI_DUNG".equals(congDan.getDCD_VaiTro())) {
                // Sử dụng forward thay vì sendRedirect
                request.getRequestDispatcher("WEB-INF/views/user/home.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Vai trò không hợp lệ");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Sai CCCD hoặc mật khẩu");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    // Thêm doGet để xử lý truy cập trực tiếp vào /login
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}