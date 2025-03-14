package controller;

import dao.CongDanDAO;
import dao.YeuCauCapLaiDAO;
import model.CongDan;
import model.YeuCauCapLai;
import model.YeuCauChinhSua;
import model.YeuCauDoiMatKhau;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

public class UserController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());
    private CongDanDAO congDanDAO;
    private YeuCauCapLaiDAO yeuCauCapLaiDAO;

    @Override
    public void init() {
        congDanDAO = new CongDanDAO();
        yeuCauCapLaiDAO = new YeuCauCapLaiDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("soDienThoai") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        if ("dashboard".equals(action) || action == null) {
            showDashboard(request, response);
        } else if ("editProfile".equals(action)) {
            showEditProfile(request, response);
        } else if ("capLaiRequest".equals(action)) {
            showCapLaiRequestForm(request, response);
        } else if ("chinhSuaRequest".equals(action)) {
            showChinhSuaRequestForm(request, response);
        } else if ("doiMatKhauRequest".equals(action)) {
            showDoiMatKhauRequestForm(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("soDienThoai") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        try {
            switch (action) {
                case "submitCapLai":
                    submitCapLaiRequest(request, response);
                    break;
                case "submitChinhSua":
                    submitChinhSuaRequest(request, response);
                    break;
                case "submitDoiMatKhau":
                    submitDoiMatKhauRequest(request, response);
                    break;
                default:
                    response.sendRedirect("${pageContext.request.contextPath}/user?action=dashboard");
                    break;
            }
        } catch (SQLException e) {
            LOGGER.severe("SQLException in doPost: " + e.getMessage());
            request.setAttribute("error", "Lỗi khi xử lý yêu cầu: " + e.getMessage());
            try {
                showDashboard(request, response);
            } catch (Exception ex) {
                response.sendRedirect("login.jsp");
            }
        }
    }

    private void showDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/user/userDashboard.jsp").forward(request, response);
    }

    private void showEditProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/user/editProfile.jsp").forward(request, response);
    }

    private void showCapLaiRequestForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/user/capLaiRequest.jsp").forward(request, response);
    }

    private void showChinhSuaRequestForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/user/chinhSuaRequest.jsp").forward(request, response);
    }

    private void showDoiMatKhauRequestForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/user/doiMatKhauRequest.jsp").forward(request, response);
    }

    private void submitCapLaiRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String cccd = (String) request.getSession().getAttribute("cccd");
        String loaiYeuCau = request.getParameter("loaiYeuCau");
        String tenNguoiNhan = request.getParameter("tenNguoiNhan");
        String soDienThoaiNhan = request.getParameter("soDienThoaiNhan");
        String diaChiNhan = request.getParameter("diaChiNhan");

        YeuCauCapLai yeuCau = new YeuCauCapLai(0, cccd, loaiYeuCau, "CHO_DUYET", "CHUA_GIAO", tenNguoiNhan, soDienThoaiNhan, diaChiNhan, null, null);
        yeuCauCapLaiDAO.insertYeuCauCapLai(yeuCau);

        LOGGER.info("Submitted cap lai request for CCCD: " + cccd);
        request.setAttribute("message", "Yêu cầu cấp lại CCCD đã được gửi thành công!");
        request.getRequestDispatcher("/WEB-INF/views/user/capLaiRequest.jsp").forward(request, response);
    }

    private void submitChinhSuaRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String cccd = (String) request.getSession().getAttribute("cccd");
        String truongCanSua = request.getParameter("truongCanSua");
        String giaTriMoi = request.getParameter("giaTriMoi");

        congDanDAO.insertChinhSuaRequest(new YeuCauChinhSua(0, cccd, truongCanSua, giaTriMoi, "CHO_DUYET", null, null));

        LOGGER.info("Submitted chinh sua request for CCCD: " + cccd);
        request.setAttribute("message", "Yêu cầu chỉnh sửa thông tin đã được gửi thành công!");
        request.getRequestDispatcher("/WEB-INF/views/user/chinhSuaRequest.jsp").forward(request, response);
    }

    private void submitDoiMatKhauRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String soDienThoai = (String) request.getSession().getAttribute("soDienThoai");
        String matKhauMoi = request.getParameter("matKhauMoi");

        congDanDAO.insertDoiMatKhauRequest(new YeuCauDoiMatKhau(0, soDienThoai, matKhauMoi, "CHO_DUYET", null));

        LOGGER.info("Submitted doi mat khau request for soDienThoai: " + soDienThoai);
        request.setAttribute("message", "Yêu cầu đổi mật khẩu đã được gửi thành công!");
        request.getRequestDispatcher("/WEB-INF/views/user/doiMatKhauRequest.jsp").forward(request, response);
    }
}