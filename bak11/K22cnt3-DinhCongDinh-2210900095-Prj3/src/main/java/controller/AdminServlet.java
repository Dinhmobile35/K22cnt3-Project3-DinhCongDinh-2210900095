package controller;

import dao.*;
import model.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null) path = "/index";

        DCD_CongDanDAO congDanDAO = new DCD_CongDanDAO();
        DCD_BaoHiemYTeDAO bhytDAO = new DCD_BaoHiemYTeDAO();
        DCD_GiayPhepLaiXeDAO gplxDAO = new DCD_GiayPhepLaiXeDAO();
        DCD_YeuCauCapLaiDAO capLaiDAO = new DCD_YeuCauCapLaiDAO();
        DCD_YeuCauChinhSuaDAO chinhSuaDAO = new DCD_YeuCauChinhSuaDAO();

        switch (path) {
            case "/crudCCCD":
                List<DCD_CongDan> congDanList = congDanDAO.getAll();
                request.setAttribute("congDanList", congDanList);
                request.getRequestDispatcher("/views/admin/crudCCCD.jsp").forward(request, response);
                break;
            case "/crudBHYT":
                List<DCD_BaoHiemYTe> bhytList = bhytDAO.getAll();
                request.setAttribute("bhytList", bhytList);
                request.getRequestDispatcher("/views/admin/crudBHYT.jsp").forward(request, response);
                break;
            case "/crudGPLX":
                List<DCD_GiayPhepLaiXe> gplxList = gplxDAO.getAll();
                request.setAttribute("gplxList", gplxList);
                request.getRequestDispatcher("/views/admin/crudGPLX.jsp").forward(request, response);
                break;
            case "/yeuCauCapLai":
                List<DCD_YeuCauCapLai> capLaiList = capLaiDAO.getAll();
                request.setAttribute("capLaiList", capLaiList);
                request.getRequestDispatcher("/views/admin/yeuCauCapLai.jsp").forward(request, response);
                break;
            case "/yeuCauChinhSua":
                List<DCD_YeuCauChinhSua> chinhSuaList = chinhSuaDAO.getAll();
                request.setAttribute("chinhSuaList", chinhSuaList);
                request.getRequestDispatcher("/views/admin/yeuCauChinhSua.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/views/admin/index.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null) path = "/index";

        DCD_CongDanDAO congDanDAO = new DCD_CongDanDAO();
        DCD_BaoHiemYTeDAO bhytDAO = new DCD_BaoHiemYTeDAO();
        DCD_GiayPhepLaiXeDAO gplxDAO = new DCD_GiayPhepLaiXeDAO();
        DCD_YeuCauCapLaiDAO capLaiDAO = new DCD_YeuCauCapLaiDAO();
        DCD_YeuCauChinhSuaDAO chinhSuaDAO = new DCD_YeuCauChinhSuaDAO();

        switch (path) {
            case "/crudCCCD":
                String cccd = request.getParameter("cccd");
                String action = request.getParameter("action");
                if ("delete".equals(action)) {
                    congDanDAO.delete(cccd);
                } else if ("update".equals(action)) {
                    DCD_CongDan congDan = new DCD_CongDan();
                    congDan.setDCD_CCCD(cccd);
                    congDan.setDCD_HoTen(request.getParameter("hoTen"));
                    congDan.setDCD_NgaySinh(Date.valueOf(request.getParameter("ngaySinh")));
                    congDan.setDCD_GioiTinh(request.getParameter("gioiTinh"));
                    congDan.setDCD_DiaChi(request.getParameter("diaChi"));
                    congDan.setDCD_MatKhau(request.getParameter("matKhau"));
                    congDan.setDCD_TrangThai(request.getParameter("trangThai"));
                    congDanDAO.update(congDan);
                }
                response.sendRedirect(request.getContextPath() + "/admin/crudCCCD");
                break;
            // Thêm các case khác nếu cần
            default:
                response.sendRedirect(request.getContextPath() + "/admin/index");
        }
    }
}