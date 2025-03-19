package controller;

import dao.DCD_YeuCauCapLaiDAO;
import model.DCD_YeuCauCapLai;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/manageYeuCau")
public class ManageYeuCauServlet extends HttpServlet {
    private DCD_YeuCauCapLaiDAO yeuCauDAO;

    public void init() {
        yeuCauDAO = new DCD_YeuCauCapLaiDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vaiTro = (String) request.getSession().getAttribute("vaiTro");
        if (!"QUAN_TRI".equals(vaiTro)) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "accept":
                int maYeuCau = Integer.parseInt(request.getParameter("maYeuCau"));
                yeuCauDAO.updateTrangThai(maYeuCau, "DA_DUYET");
                response.sendRedirect(request.getContextPath() + "/manageYeuCau");
                break;
            case "reject":
                maYeuCau = Integer.parseInt(request.getParameter("maYeuCau"));
                yeuCauDAO.updateTrangThai(maYeuCau, "TU_CHOI");
                response.sendRedirect(request.getContextPath() + "/manageYeuCau");
                break;
            case "updateGiaoHang":
                maYeuCau = Integer.parseInt(request.getParameter("maYeuCau"));
                String trangThaiGiaoHang = request.getParameter("trangThaiGiaoHang");
                yeuCauDAO.updateTrangThaiGiaoHang(maYeuCau, trangThaiGiaoHang);
                response.sendRedirect(request.getContextPath() + "/manageYeuCau");
                break;
            default:
                List<DCD_YeuCauCapLai> yeuCauList = yeuCauDAO.getAll();
                request.setAttribute("yeuCauList", yeuCauList);
                request.getRequestDispatcher("WEB-INF/views/admin/manageYeuCau.jsp").forward(request, response);
                break;
        }
    }
}