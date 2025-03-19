package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vaiTro = (String) request.getSession().getAttribute("vaiTro");
        if (!"QUAN_TRI".equals(vaiTro)) {
            request.getRequestDispatcher("login.jsp").forward(request, response); // Sử dụng forward
            return;
        }

        request.getRequestDispatcher("WEB-INF/views/admin/dashboard.jsp").forward(request, response);
    }
}