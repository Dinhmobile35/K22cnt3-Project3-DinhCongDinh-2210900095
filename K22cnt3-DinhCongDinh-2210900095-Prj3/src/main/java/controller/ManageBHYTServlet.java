package controller;

import dao.DCD_BHYTDAO;
import model.DCD_BaoHiemYTe;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/manageBHYT")
public class ManageBHYTServlet extends HttpServlet {
    private DCD_BHYTDAO bhytDAO;

    public void init() {
        bhytDAO = new DCD_BHYTDAO();
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
                request.getRequestDispatcher("WEB-INF/views/admin/createBHYT.jsp").forward(request, response);
                break;
            case "edit":
                String maBHYT = request.getParameter("maBHYT");
                DCD_BaoHiemYTe bhyt = bhytDAO.getByMaBHYT(maBHYT);
                request.setAttribute("bhyt", bhyt);
                request.getRequestDispatcher("WEB-INF/views/admin/editBHYT.jsp").forward(request, response);
                break;
            case "delete":
                maBHYT = request.getParameter("maBHYT");
                bhytDAO.delete(maBHYT);
                response.sendRedirect(request.getContextPath() + "/manageBHYT");
                break;
            default:
                List<DCD_BaoHiemYTe> bhytList = bhytDAO.getAll();
                request.setAttribute("bhytList", bhytList);
                request.getRequestDispatcher("WEB-INF/views/admin/manageBHYT.jsp").forward(request, response);
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
        DCD_BaoHiemYTe bhyt = new DCD_BaoHiemYTe();
        bhyt.setDCD_MaBHYT(request.getParameter("maBHYT"));
        bhyt.setDCD_CCCD(request.getParameter("cccd"));
        bhyt.setDCD_NgayCap(Date.valueOf(request.getParameter("ngayCap")));
        String ngayHetHan = request.getParameter("ngayHetHan");
        if (ngayHetHan != null && !ngayHetHan.isEmpty()) {
            bhyt.setDCD_NgayHetHan(Date.valueOf(ngayHetHan));
        } else {
            bhyt.setDCD_NgayHetHan(null);
        }
        bhyt.setDCD_NoiDangKyKhamBenh(request.getParameter("noiDangKyKhamBenh"));
        String trangThai = request.getParameter("trangThai");
        if (!"HOAT_DONG".equals(trangThai) && !"HET_HAN".equals(trangThai)) {
            trangThai = "HOAT_DONG"; // Mặc định nếu giá trị không hợp lệ
        }
        bhyt.setDCD_TrangThai(trangThai);

        if ("create".equals(action)) {
            if (bhytDAO.create(bhyt)) {
                response.sendRedirect(request.getContextPath() + "/manageBHYT");
            } else {
                request.setAttribute("error", "Thêm BHYT thất bại");
                request.getRequestDispatcher("WEB-INF/views/admin/createBHYT.jsp").forward(request, response);
            }
        } else if ("update".equals(action)) {
            if (bhytDAO.update(bhyt)) {
                response.sendRedirect(request.getContextPath() + "/manageBHYT");
            } else {
                request.setAttribute("error", "Cập nhật BHYT thất bại");
                request.setAttribute("bhyt", bhyt);
                request.getRequestDispatcher("WEB-INF/views/admin/editBHYT.jsp").forward(request, response);
            }
        }
    }
}