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

public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null) path = "/index";

        DCD_CongDanDAO congDanDAO = new DCD_CongDanDAO();
        DCD_BaoHiemYTeDAO bhytDAO = new DCD_BaoHiemYTeDAO();
        DCD_GiayPhepLaiXeDAO gplxDAO = new DCD_GiayPhepLaiXeDAO();

        DCD_CongDan congDan = (DCD_CongDan) request.getSession().getAttribute("congDan");
        if (congDan == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        switch (path) {
            case "/index":
                request.getRequestDispatcher("/views/user/index.jsp").forward(request, response);
                break;
            case "/thongTinCaNhan":
                DCD_CongDan user = congDanDAO.getByCCCD(congDan.getDCD_CCCD());
                request.setAttribute("congDan", user);
                request.getRequestDispatcher("/views/user/thongTinCaNhan.jsp").forward(request, response);
                break;
            case "/baoHiemYTe":
                DCD_BaoHiemYTe bhyt = bhytDAO.getByCCCD(congDan.getDCD_CCCD());
                request.setAttribute("bhyt", bhyt);
                request.getRequestDispatcher("/views/user/baoHiemYTe.jsp").forward(request, response);
                break;
            case "/giayPhepLaiXe":
                DCD_GiayPhepLaiXe gplx = gplxDAO.getByCCCD(congDan.getDCD_CCCD());
                request.setAttribute("gplx", gplx);
                request.getRequestDispatcher("/views/user/giayPhepLaiXe.jsp").forward(request, response);
                break;
            case "/yeuCauCapLai":
                request.getRequestDispatcher("/views/user/yeuCauCapLai.jsp").forward(request, response);
                break;
            case "/yeuCauChinhSua":
                request.getRequestDispatcher("/views/user/yeuCauChinhSua.jsp").forward(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/user/index");
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

        DCD_CongDan congDan = (DCD_CongDan) request.getSession().getAttribute("congDan");
        if (congDan == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        switch (path) {
            case "/yeuCauCapLai":
                DCD_YeuCauCapLai capLai = new DCD_YeuCauCapLai();
                capLai.setDCD_CCCD(congDan.getDCD_CCCD());
                capLai.setDCD_LoaiYeuCau(request.getParameter("loaiYeuCau"));
                capLai.setDCD_TenNguoiNhan(request.getParameter("tenNguoiNhan"));
                capLai.setDCD_SoDienThoaiNhan(request.getParameter("soDienThoaiNhan"));
                capLai.setDCD_DiaChiNhan(request.getParameter("diaChiNhan"));
                capLai.setDCD_TrangThai("Chờ xử lý");
                capLai.setDCD_NgayTao(new Date(System.currentTimeMillis()));
                capLaiDAO.create(capLai);
                response.sendRedirect(request.getContextPath() + "/user/yeuCauCapLai");
                break;
            case "/yeuCauChinhSua":
                DCD_YeuCauChinhSua chinhSua = new DCD_YeuCauChinhSua();
                chinhSua.setDCD_CCCD(congDan.getDCD_CCCD());
                chinhSua.setDCD_TruongCanSua(request.getParameter("truongCanSua"));
                chinhSua.setDCD_GiaTriMoi(request.getParameter("giaTriMoi"));
                chinhSua.setDCD_TrangThai("Chờ xử lý");
                chinhSua.setDCD_NgayTao(new Date(System.currentTimeMillis()));
                chinhSuaDAO.create(chinhSua);
                response.sendRedirect(request.getContextPath() + "/user/yeuCauChinhSua");
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/user/index");
        }
    }
}