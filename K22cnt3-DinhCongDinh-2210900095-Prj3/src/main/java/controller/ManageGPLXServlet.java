package controller;

import dao.DCD_GPLXDAO;
import model.DCD_GiayPhepLaiXe;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/manageGPLX")
public class ManageGPLXServlet extends HttpServlet {
    private DCD_GPLXDAO gplxDAO;

    public void init() {
        gplxDAO = new DCD_GPLXDAO();
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
            case "create":
                request.getRequestDispatcher("WEB-INF/views/admin/createGPLX.jsp").forward(request, response);
                break;
            case "edit":
                String soGPLX = request.getParameter("soGPLX");
                DCD_GiayPhepLaiXe gplx = gplxDAO.getBySoGPLX(soGPLX);
                request.setAttribute("gplx", gplx);
                request.getRequestDispatcher("WEB-INF/views/admin/editGPLX.jsp").forward(request, response);
                break;
            case "delete":
                soGPLX = request.getParameter("soGPLX");
                gplxDAO.delete(soGPLX);
                response.sendRedirect(request.getContextPath() + "/manageGPLX");
                break;
            default:
                List<DCD_GiayPhepLaiXe> gplxList = gplxDAO.getAll();
                request.setAttribute("gplxList", gplxList);
                request.getRequestDispatcher("WEB-INF/views/admin/manageGPLX.jsp").forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vaiTro = (String) request.getSession().getAttribute("vaiTro");
        if (!"QUAN_TRI".equals(vaiTro)) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        String action = request.getParameter("action");
        DCD_GiayPhepLaiXe gplx = new DCD_GiayPhepLaiXe();
        gplx.setDCD_SoGPLX(request.getParameter("soGPLX"));
        gplx.setDCD_CCCD(request.getParameter("cccd"));
        gplx.setDCD_HangGPLX(request.getParameter("hangGPLX"));
        gplx.setDCD_NgayCap(Date.valueOf(request.getParameter("ngayCap")));
        String ngayHetHan = request.getParameter("ngayHetHan");
        if (ngayHetHan != null && !ngayHetHan.isEmpty()) {
            gplx.setDCD_NgayHetHan(Date.valueOf(ngayHetHan));
        } else {
            gplx.setDCD_NgayHetHan(null);
        }
        gplx.setDCD_NoiCap(request.getParameter("noiCap"));
        gplx.setDCD_TrangThai(request.getParameter("trangThai"));

        if ("create".equals(action)) {
            if (gplxDAO.create(gplx)) {
                response.sendRedirect(request.getContextPath() + "/manageGPLX");
            } else {
                request.setAttribute("error", "Thêm GPLX thất bại");
                request.getRequestDispatcher("WEB-INF/views/admin/createGPLX.jsp").forward(request, response);
            }
        } else if ("update".equals(action)) {
            if (gplxDAO.update(gplx)) {
                response.sendRedirect(request.getContextPath() + "/manageGPLX");
            } else {
                request.setAttribute("error", "Cập nhật GPLX thất bại");
                request.setAttribute("gplx", gplx);
                request.getRequestDispatcher("WEB-INF/views/admin/editGPLX.jsp").forward(request, response);
            }
        }
    }
}