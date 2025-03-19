package controller;

import dao.DCD_YeuCauCapLaiDAO;
import model.DCD_YeuCauCapLai;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/viewYeuCau")
public class ViewYeuCauServlet extends HttpServlet {
    private DCD_YeuCauCapLaiDAO yeuCauDAO;

    public void init() {
        yeuCauDAO = new DCD_YeuCauCapLaiDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vaiTro = (String) request.getSession().getAttribute("vaiTro");
        String cccd = (String) request.getSession().getAttribute("cccd");

        if (!"NGUOI_DUNG".equals(vaiTro) || cccd == null) { // Cập nhật vai trò thành NGUOI_DUNG
            request.getRequestDispatcher("login.jsp").forward(request, response); // Sử dụng forward
            return;
        }

        // Lấy danh sách yêu cầu của user
        List<DCD_YeuCauCapLai> yeuCauList = yeuCauDAO.getAll().stream()
                .filter(y -> y.getDCD_CCCD().equals(cccd))
                .collect(Collectors.toList());
        request.setAttribute("yeuCauList", yeuCauList);

        request.getRequestDispatcher("WEB-INF/views/user/viewYeuCau.jsp").forward(request, response);
    }
}