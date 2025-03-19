package controller;

import dao.DCD_YeuCauCapLaiDAO;
import model.DCD_YeuCauCapLai;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/yeucauCapLai")
public class YeuCauCapLaiServlet extends HttpServlet {
    private DCD_YeuCauCapLaiDAO yeuCauDAO;

    public void init() {
        yeuCauDAO = new DCD_YeuCauCapLaiDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vaiTro = (String) request.getSession().getAttribute("vaiTro");
        if (!"NGUOI_DUNG".equals(vaiTro)) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("WEB-INF/views/user/yeucauCapLai.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vaiTro = (String) request.getSession().getAttribute("vaiTro");
        if (!"NGUOI_DUNG".equals(vaiTro)) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        DCD_YeuCauCapLai yeuCau = new DCD_YeuCauCapLai();
        yeuCau.setDCD_CCCD((String) request.getSession().getAttribute("cccd"));
        yeuCau.setDCD_LoaiYeuCau(request.getParameter("loaiYeuCau"));
        yeuCau.setDCD_TrangThai("CHO_DUYET");
        yeuCau.setDCD_TrangThaiGiaoHang("CHUA_GIAO");
        yeuCau.setDCD_TenNguoiNhan(request.getParameter("tenNguoiNhan"));
        yeuCau.setDCD_SoDienThoaiNhan(request.getParameter("soDienThoaiNhan"));
        yeuCau.setDCD_DiaChiNhan(request.getParameter("diaChiNhan"));

        if (yeuCauDAO.create(yeuCau)) {
            response.sendRedirect(request.getContextPath() + "/viewYeuCau");
        } else {
            request.setAttribute("error", "Gửi yêu cầu thất bại");
            request.getRequestDispatcher("WEB-INF/views/user/yeucauCapLai.jsp").forward(request, response);
        }
    }
}