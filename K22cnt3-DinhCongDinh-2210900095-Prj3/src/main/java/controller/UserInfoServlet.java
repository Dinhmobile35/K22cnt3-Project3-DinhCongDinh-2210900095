package controller;

import dao.DCD_CongDanDAO;
import dao.DCD_BHYTDAO;
import dao.DCD_GPLXDAO;
import model.DCD_CongDan;
import model.DCD_BaoHiemYTe;
import model.DCD_GiayPhepLaiXe;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
    private DCD_CongDanDAO congDanDAO;
    private DCD_BHYTDAO bhytDAO;
    private DCD_GPLXDAO gplxDAO;

    public void init() {
        congDanDAO = new DCD_CongDanDAO();
        bhytDAO = new DCD_BHYTDAO();
        gplxDAO = new DCD_GPLXDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vaiTro = (String) request.getSession().getAttribute("vaiTro");
        String cccd = (String) request.getSession().getAttribute("cccd");

        if (!"NGUOI_DUNG".equals(vaiTro) || cccd == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // Lấy thông tin công dân
        DCD_CongDan congDan = congDanDAO.getByCCCD(cccd);
        request.setAttribute("congDan", congDan);

        // Lấy thông tin bảo hiểm y tế
        List<DCD_BaoHiemYTe> bhytList = bhytDAO.getAll();
        DCD_BaoHiemYTe bhyt = bhytList.stream()
                .filter(b -> b.getDCD_CCCD().equals(cccd))
                .findFirst()
                .orElse(null);
        request.setAttribute("bhyt", bhyt);

        // Lấy thông tin giấy phép lái xe
        List<DCD_GiayPhepLaiXe> gplxList = gplxDAO.getAll();
        DCD_GiayPhepLaiXe gplx = gplxList.stream()
                .filter(g -> g.getDCD_CCCD().equals(cccd))
                .findFirst()
                .orElse(null);
        request.setAttribute("gplx", gplx);

        request.getRequestDispatcher("WEB-INF/views/user/userInfo.jsp").forward(request, response);
    }
}