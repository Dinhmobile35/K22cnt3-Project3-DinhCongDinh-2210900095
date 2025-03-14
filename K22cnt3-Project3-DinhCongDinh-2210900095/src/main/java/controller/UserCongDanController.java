package controller;

import dao.CongDanDAO;
import model.CongDan;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserCongDanController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(UserCongDanController.class.getName());
    private CongDanDAO congDanDAO;

    @Override
    public void init() {
        congDanDAO = new CongDanDAO();
        LOGGER.info("UserCongDanController initialized.");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("soDienThoai") == null || !"NGUOI_DUNG".equals(session.getAttribute("vaiTro"))) {
            LOGGER.warning("Unauthorized access attempt. Redirecting to login.jsp.");
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String action = request.getParameter("action");
        try {
            switch (action == null ? "list" : action) {
                case "view":
                    viewCongDan(request, response);
                    break;
                case "search":
                    searchCongDan(request, response);
                    break;
                default:
                    listCongDan(request, response);
                    break;
            }
        } catch (SQLException e) {
            LOGGER.severe("SQL Exception in doGet: " + e.getMessage());
            throw new ServletException("Lỗi khi truy vấn dữ liệu công dân: " + e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("soDienThoai") == null || !"NGUOI_DUNG".equals(session.getAttribute("vaiTro"))) {
            LOGGER.warning("Unauthorized access attempt. Redirecting to login.jsp.");
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String action = request.getParameter("action");
        try {
            switch (action == null ? "list" : action) {
                case "search":
                    searchCongDan(request, response);
                    break;
                default:
                    listCongDan(request, response);
                    break;
            }
        } catch (SQLException e) {
            LOGGER.severe("SQL Exception in doPost: " + e.getMessage());
            throw new ServletException("Lỗi khi xử lý yêu cầu: " + e.getMessage(), e);
        }
    }

    private void listCongDan(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        LOGGER.info("Fetching all citizens...");
        List<CongDan> congDanList = congDanDAO.selectAllCongDan();
        request.setAttribute("congDanList", congDanList);
        request.getRequestDispatcher("/WEB-INF/views/user/congDanList.jsp").forward(request, response);
    }

    private void viewCongDan(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String cccd = request.getParameter("cccd");
        LOGGER.info("Viewing citizen with CCCD: " + cccd);
        CongDan congDan = congDanDAO.selectCongDan(cccd);
        if (congDan == null) {
            LOGGER.warning("Citizen not found with CCCD: " + cccd);
            request.setAttribute("error", "Không tìm thấy công dân với CCCD: " + cccd);
            request.getRequestDispatcher("/WEB-INF/views/user/error.jsp").forward(request, response);
        } else {
            request.setAttribute("congDan", congDan);
            request.getRequestDispatcher("/WEB-INF/views/user/congDanView.jsp").forward(request, response);
        }
    }

    private void searchCongDan(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String cccdSearch = request.getParameter("cccdSearch");
        LOGGER.info("Searching citizen with CCCD: " + cccdSearch);
        List<CongDan> congDanList;
        if (cccdSearch != null && !cccdSearch.trim().isEmpty()) {
            CongDan congDan = congDanDAO.selectCongDan(cccdSearch);
            congDanList = (congDan != null) ? List.of(congDan) : List.of();
        } else {
            congDanList = congDanDAO.selectAllCongDan();
        }
        request.setAttribute("congDanList", congDanList);
        request.getRequestDispatcher("/WEB-INF/views/user/congDanList.jsp").forward(request, response);
    }
}