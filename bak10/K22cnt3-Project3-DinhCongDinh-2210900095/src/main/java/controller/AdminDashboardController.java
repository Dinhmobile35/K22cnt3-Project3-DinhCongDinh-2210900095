package controller;

import dao.CongDanDAO;
import model.YeuCauCapLai;
import model.YeuCauChinhSua;
import model.YeuCauDoiMatKhau;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminDashboardController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(AdminDashboardController.class.getName());
    private CongDanDAO congDanDAO;

    @Override
    public void init() {
        congDanDAO = new CongDanDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("soDienThoai") == null || !"QUAN_TRI".equals(session.getAttribute("vaiTro"))) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        try {
            switch (action == null ? "dashboard" : action) {
                case "dashboard":
                    showDashboard(request, response);
                    break;
                case "capLaiList":
                    showCapLaiRequests(request, response);
                    break;
                case "chinhSuaList":
                    showChinhSuaRequests(request, response);
                    break;
                case "doiMatKhauList":
                    showDoiMatKhauRequests(request, response);
                    break;
                default:
                    showDashboard(request, response);
                    break;
            }
        } catch (SQLException e) {
            LOGGER.severe("SQLException in doGet: " + e.getMessage());
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("soDienThoai") == null || !"QUAN_TRI".equals(session.getAttribute("vaiTro"))) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        try {
            switch (action) {
                case "approveCapLai":
                    approveCapLaiRequest(request, response);
                    break;
                case "rejectCapLai":
                    rejectCapLaiRequest(request, response);
                    break;
                case "updateDeliveryCapLai":
                    updateDeliveryCapLai(request, response);
                    break;
                case "approveChinhSua":
                    approveChinhSuaRequest(request, response);
                    break;
                case "rejectChinhSua":
                    rejectChinhSuaRequest(request, response);
                    break;
                case "approveDoiMatKhau":
                    approveDoiMatKhauRequest(request, response);
                    break;
                case "rejectDoiMatKhau":
                    rejectDoiMatKhauRequest(request, response);
                    break;
                default:
                    response.sendRedirect("dashboard");
                    break;
            }
        } catch (SQLException e) {
            LOGGER.severe("SQLException in doPost: " + e.getMessage());
            throw new ServletException(e);
        }
    }

    private void showDashboard(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int totalCongDan = congDanDAO.countCongDan();
        int totalTaiKhoan = congDanDAO.countTaiKhoan();
        int lockedTaiKhoan = congDanDAO.countLockedTaiKhoan();
        int capLaiChoDuyet = congDanDAO.countCapLaiRequestsByStatus("CHO_DUYET");
        int capLaiDaDuyet = congDanDAO.countCapLaiRequestsByStatus("DA_DUYET");
        int capLaiTuChoi = congDanDAO.countCapLaiRequestsByStatus("TU_CHOI");
        int capLaiChuaGiao = congDanDAO.countCapLaiRequestsByStatusAndDelivery("CHUA_GIAO");
        int capLaiDangGiao = congDanDAO.countCapLaiRequestsByStatusAndDelivery("DANG_GIAO");
        int capLaiDaNhan = congDanDAO.countCapLaiRequestsByStatusAndDelivery("DA_NHAN");
        int chinhSuaChoDuyet = congDanDAO.countChinhSuaRequestsByStatus("CHO_DUYET");
        int chinhSuaDaDuyet = congDanDAO.countChinhSuaRequestsByStatus("DA_DUYET");
        int chinhSuaTuChoi = congDanDAO.countChinhSuaRequestsByStatus("TU_CHOI");
        int doiMatKhauChoDuyet = congDanDAO.countDoiMatKhauRequestsByStatus("CHO_DUYET");
        int doiMatKhauHoanThanh = congDanDAO.countDoiMatKhauRequestsByStatus("HOAN_THANH");
        int doiMatKhauTuChoi = congDanDAO.countDoiMatKhauRequestsByStatus("TU_CHOI");

        request.setAttribute("totalCongDan", totalCongDan);
        request.setAttribute("totalTaiKhoan", totalTaiKhoan);
        request.setAttribute("lockedTaiKhoan", lockedTaiKhoan);
        request.setAttribute("capLaiChoDuyet", capLaiChoDuyet);
        request.setAttribute("capLaiDaDuyet", capLaiDaDuyet);
        request.setAttribute("capLaiTuChoi", capLaiTuChoi);
        request.setAttribute("capLaiChuaGiao", capLaiChuaGiao);
        request.setAttribute("capLaiDangGiao", capLaiDangGiao);
        request.setAttribute("capLaiDaNhan", capLaiDaNhan);
        request.setAttribute("chinhSuaChoDuyet", chinhSuaChoDuyet);
        request.setAttribute("chinhSuaDaDuyet", chinhSuaDaDuyet);
        request.setAttribute("chinhSuaTuChoi", chinhSuaTuChoi);
        request.setAttribute("doiMatKhauChoDuyet", doiMatKhauChoDuyet);
        request.setAttribute("doiMatKhauHoanThanh", doiMatKhauHoanThanh);
        request.setAttribute("doiMatKhauTuChoi", doiMatKhauTuChoi);

        request.getRequestDispatcher("/WEB-INF/views/admin/dashboard.jsp").forward(request, response);
    }

    private void showCapLaiRequests(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<YeuCauCapLai> capLaiRequests = congDanDAO.getAllCapLaiRequests();
        if (capLaiRequests == null || capLaiRequests.isEmpty()) {
            LOGGER.info("Danh sách yêu cầu cấp lại CCCD rỗng hoặc null");
        } else {
            LOGGER.info("Số lượng yêu cầu cấp lại CCCD: " + capLaiRequests.size());
            for (YeuCauCapLai req : capLaiRequests) {
                LOGGER.info("Yêu cầu cấp lại - Mã: " + req.getMaYeuCau() + ", CCCD: " + req.getCccd());
            }
        }
        request.setAttribute("capLaiRequests", capLaiRequests);
        request.getRequestDispatcher("/WEB-INF/views/admin/capLaiList.jsp").forward(request, response);
    }

    private void showChinhSuaRequests(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<YeuCauChinhSua> chinhSuaRequests = congDanDAO.getAllChinhSuaRequests();
        if (chinhSuaRequests == null || chinhSuaRequests.isEmpty()) {
            LOGGER.info("Danh sách yêu cầu chỉnh sửa thông tin rỗng hoặc null");
        } else {
            LOGGER.info("Số lượng yêu cầu chỉnh sửa thông tin: " + chinhSuaRequests.size());
            for (YeuCauChinhSua req : chinhSuaRequests) {
                LOGGER.info("Yêu cầu chỉnh sửa - Mã: " + req.getMaYeuCau() + ", CCCD: " + req.getCccd());
            }
        }
        request.setAttribute("chinhSuaRequests", chinhSuaRequests);
        request.getRequestDispatcher("/WEB-INF/views/admin/chinhSuaList.jsp").forward(request, response);
    }

    private void showDoiMatKhauRequests(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<YeuCauDoiMatKhau> doiMatKhauRequests = congDanDAO.getAllDoiMatKhauRequests();
        if (doiMatKhauRequests == null || doiMatKhauRequests.isEmpty()) {
            LOGGER.info("Danh sách yêu cầu đổi mật khẩu rỗng hoặc null");
        } else {
            LOGGER.info("Số lượng yêu cầu đổi mật khẩu: " + doiMatKhauRequests.size());
            for (YeuCauDoiMatKhau req : doiMatKhauRequests) {
                LOGGER.info("Yêu cầu đổi mật khẩu - Mã: " + req.getMaYeuCau() + ", Số điện thoại: " + req.getSoDienThoai());
            }
        }
        request.setAttribute("doiMatKhauRequests", doiMatKhauRequests);
        request.getRequestDispatcher("/WEB-INF/views/admin/doiMatKhauList.jsp").forward(request, response);
    }

    private void approveCapLaiRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int maYeuCau = Integer.parseInt(request.getParameter("maYeuCau"));
        congDanDAO.updateCapLaiRequestStatus(maYeuCau, "DA_DUYET", "CHUA_GIAO");
        response.sendRedirect("dashboard?action=capLaiList");
    }

    private void rejectCapLaiRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int maYeuCau = Integer.parseInt(request.getParameter("maYeuCau"));
        congDanDAO.updateCapLaiRequestStatus(maYeuCau, "TU_CHOI", "CHUA_GIAO");
        response.sendRedirect("dashboard?action=capLaiList");
    }

    private void updateDeliveryCapLai(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int maYeuCau = Integer.parseInt(request.getParameter("maYeuCau"));
        String trangThaiGiaoHang = request.getParameter("trangThaiGiaoHang");
        congDanDAO.updateCapLaiRequestStatus(maYeuCau, "DA_DUYET", trangThaiGiaoHang);
        response.sendRedirect("dashboard?action=capLaiList");
    }

    private void approveChinhSuaRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int maYeuCau = Integer.parseInt(request.getParameter("maYeuCau"));
        congDanDAO.updateChinhSuaRequestStatus(maYeuCau, "DA_DUYET");
        response.sendRedirect("dashboard?action=chinhSuaList");
    }

    private void rejectChinhSuaRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int maYeuCau = Integer.parseInt(request.getParameter("maYeuCau"));
        congDanDAO.updateChinhSuaRequestStatus(maYeuCau, "TU_CHOI");
        response.sendRedirect("dashboard?action=chinhSuaList");
    }

    private void approveDoiMatKhauRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int maYeuCau = Integer.parseInt(request.getParameter("maYeuCau"));
        congDanDAO.updateDoiMatKhauRequestStatus(maYeuCau, "HOAN_THANH");
        response.sendRedirect("dashboard?action=doiMatKhauList");
    }

    private void rejectDoiMatKhauRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int maYeuCau = Integer.parseInt(request.getParameter("maYeuCau"));
        congDanDAO.updateDoiMatKhauRequestStatus(maYeuCau, "TU_CHOI");
        response.sendRedirect("dashboard?action=doiMatKhauList");
    }
}