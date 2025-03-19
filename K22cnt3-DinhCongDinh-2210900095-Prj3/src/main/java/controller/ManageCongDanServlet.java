package controller;

import dao.DCD_CongDanDAO;
import model.DCD_CongDan;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/manageCongDan")
public class ManageCongDanServlet extends HttpServlet {
    private DCD_CongDanDAO congDanDAO;

    public void init() {
        congDanDAO = new DCD_CongDanDAO();
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
                request.getRequestDispatcher("WEB-INF/views/admin/createCongDan.jsp").forward(request, response);
                break;
            case "edit":
                String cccd = request.getParameter("cccd");
                DCD_CongDan congDan = congDanDAO.getByCCCD(cccd);
                request.setAttribute("congDan", congDan);
                request.getRequestDispatcher("WEB-INF/views/admin/editCongDan.jsp").forward(request, response);
                break;
            case "delete":
                cccd = request.getParameter("cccd");
                congDanDAO.delete(cccd);
                response.sendRedirect(request.getContextPath() + "/manageCongDan");
                break;
            default:
                List<DCD_CongDan> congDanList = congDanDAO.getAll();
                request.setAttribute("congDanList", congDanList);
                request.getRequestDispatcher("WEB-INF/views/admin/manageCongDan.jsp").forward(request, response);
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
        DCD_CongDan congDan = new DCD_CongDan();
        congDan.setDCD_CCCD(request.getParameter("cccd"));
        congDan.setDCD_HoTen(request.getParameter("hoTen"));
        congDan.setDCD_NgaySinh(Date.valueOf(request.getParameter("ngaySinh")));
        congDan.setDCD_GioiTinh(request.getParameter("gioiTinh"));
        congDan.setDCD_TrangThai(request.getParameter("trangThai"));
        congDan.setDCD_VaiTro(request.getParameter("vaiTro"));
        congDan.setDCD_MatKhau(request.getParameter("matKhau"));

        if ("create".equals(action)) {
            if (congDanDAO.create(congDan)) {
                response.sendRedirect(request.getContextPath() + "/manageCongDan");
            } else {
                request.setAttribute("error", "Thêm công dân thất bại");
                request.getRequestDispatcher("WEB-INF/views/admin/createCongDan.jsp").forward(request, response);
            }
        } else if ("update".equals(action)) {
            if (congDanDAO.update(congDan)) {
                response.sendRedirect(request.getContextPath() + "/manageCongDan");
            } else {
                request.setAttribute("error", "Cập nhật công dân thất bại");
                request.setAttribute("congDan", congDan);
                request.getRequestDispatcher("WEB-INF/views/admin/editCongDan.jsp").forward(request, response);
            }
        }
    }
}