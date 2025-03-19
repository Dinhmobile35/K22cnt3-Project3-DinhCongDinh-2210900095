package controller;

import dao.DCD_YeuCauChinhSuaDAO;
import model.DCD_YeuCauChinhSua;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/yeucauChinhSua")
public class YeuCauChinhSuaServlet extends HttpServlet {
    private DCD_YeuCauChinhSuaDAO yeuCauDAO;

    public void init() {
        yeuCauDAO = new DCD_YeuCauChinhSuaDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cccd = request.getParameter("cccd");
        String truongCanSua = request.getParameter("truongCanSua");
        String giaTriMoi = request.getParameter("giaTriMoi");

        DCD_YeuCauChinhSua yeuCau = new DCD_YeuCauChinhSua();
        yeuCau.setDCD_CCCD(cccd);
        yeuCau.setDCD_TruongCanSua(truongCanSua);
        yeuCau.setDCD_GiaTriMoi(giaTriMoi);

        if (yeuCauDAO.create(yeuCau)) {
            response.sendRedirect("WEB-INF/views/user/home.jsp");
        } else {
            request.setAttribute("error", "Gửi yêu cầu thất bại");
            request.getRequestDispatcher("WEB-INF/views/user/yeucauChinhSua.jsp").forward(request, response);
        }
    }
}