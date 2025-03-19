package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/userHome")
public class UserHomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vaiTro = (String) request.getSession().getAttribute("vaiTro");
        String cccd = (String) request.getSession().getAttribute("cccd");

        if (!"NGUOI_DUNG".equals(vaiTro) || cccd == null) { // Cập nhật vai trò thành NGUOI_DUNG
            request.getRequestDispatcher("login.jsp").forward(request, response); // Sử dụng forward
            return;
        }

        request.getRequestDispatcher("WEB-INF/views/user/home.jsp").forward(request, response);
    }
}