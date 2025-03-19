package controller;

import dao.DCD_CongDanDAO;
import model.DCD_CongDan;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private DCD_CongDanDAO congDanDAO;

    public void init() {
        congDanDAO = new DCD_CongDanDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy các giá trị từ form
        String cccd = request.getParameter("cccd");
        String hoTen = request.getParameter("hoTen");
        String ngaySinhStr = request.getParameter("ngaySinh");
        String gioiTinh = request.getParameter("gioiTinh");
        String diaChi = request.getParameter("diaChi");
        String ngayCapStr = request.getParameter("ngayCap");
        String password = request.getParameter("password");

        // Kiểm tra các trường bắt buộc
        if (cccd == null || cccd.trim().isEmpty() ||
                hoTen == null || hoTen.trim().isEmpty() ||
                ngaySinhStr == null || ngaySinhStr.trim().isEmpty() ||
                gioiTinh == null || gioiTinh.trim().isEmpty() ||
                diaChi == null || diaChi.trim().isEmpty() ||
                ngayCapStr == null || ngayCapStr.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {
            request.setAttribute("error", "Vui lòng điền đầy đủ thông tin bắt buộc.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Chuyển đổi giá trị ngày
        Date ngaySinh = Date.valueOf(ngaySinhStr);
        Date ngayCap = Date.valueOf(ngayCapStr);

        // Chuyển đổi gioiTinh thành chữ in hoa để khớp với ENUM
        gioiTinh = gioiTinh.toUpperCase();

        // Tạo đối tượng DCD_CongDan
        DCD_CongDan congDan = new DCD_CongDan();
        congDan.setDCD_CCCD(cccd);
        congDan.setDCD_HoTen(hoTen);
        congDan.setDCD_NgaySinh(ngaySinh);
        congDan.setDCD_GioiTinh(gioiTinh);
        congDan.setDCD_DiaChi(diaChi); // Đảm bảo DCD_DiaChi không null
        congDan.setDCD_NgayCap(ngayCap);
        congDan.setDCD_MatKhau(password);
        congDan.setDCD_VaiTro("NGUOI_DUNG");
        congDan.setDCD_TrangThai("HOAT_DONG");

        // Các trường không bắt buộc
        congDan.setDCD_SoDienThoai(null);
        congDan.setDCD_Email(null);
        congDan.setDCD_NgayHetHan(null);
        congDan.setDCD_NgayTao(null); // Để DB tự set CURRENT_TIMESTAMP

        // Thực hiện đăng ký
        if (congDanDAO.create(congDan)) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } else {
            request.setAttribute("error", "Đăng ký thất bại. Số CCCD đã tồn tại hoặc dữ liệu không hợp lệ.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}