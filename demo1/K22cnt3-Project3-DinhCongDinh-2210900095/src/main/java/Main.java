

import dao.CongDanDAO;
import dao.TaiKhoanDAO;
import dao.YeuCauCapLaiDAO;
import dao.YeuCauChinhSuaDAO;
import model.CongDan;
import model.TaiKhoan;
import model.YeuCauCapLai;
import model.YeuCauChinhSua;

import java.sql.Date;
import java.sql.SQLException; // Thêm import này để sửa lỗi
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CongDanDAO congDanDAO = new CongDanDAO();
    private static TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
    private static YeuCauCapLaiDAO yeuCauCapLaiDAO = new YeuCauCapLaiDAO();
    private static YeuCauChinhSuaDAO yeuCauChinhSuaDAO = new YeuCauChinhSuaDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Đăng nhập");
            System.out.println("2. Thoát");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                login();
            } else if (choice == 2) {
                break;
            }
        }
    }

    private static void login() {
        System.out.print("Nhập số điện thoại: ");
        String soDienThoai = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String matKhau = scanner.nextLine();
        try {
            TaiKhoan taiKhoan = taiKhoanDAO.getTaiKhoan(soDienThoai, matKhau);
            if (taiKhoan != null) {
                if (taiKhoan.getVaiTro().equals("QUAN_TRI")) {
                    adminMenu(taiKhoan);
                } else {
                    userMenu(taiKhoan);
                }
            } else {
                System.out.println("Sai thông tin đăng nhập!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void adminMenu(TaiKhoan taiKhoan) {
        while (true) {
            System.out.println("=== Menu Admin ===");
            System.out.println("1. Thêm công dân");
            System.out.println("2. Xem danh sách công dân");
            System.out.println("3. Cập nhật công dân");
            System.out.println("4. Xóa công dân");
            System.out.println("5. Xem và xử lý yêu cầu cấp lại");
            System.out.println("6. Xem và xử lý yêu cầu chỉnh sửa");
            System.out.println("7. Đăng xuất");
            int choice = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (choice) {
                    case 1:
                        CongDan cd = inputCongDan();
                        congDanDAO.addCongDan(cd);
                        System.out.println("Thêm thành công!");
                        break;
                    case 2:
                        List<CongDan> list = congDanDAO.getAllCongDan();
                        list.forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("Nhập CCCD cần cập nhật: ");
                        String cccdUpdate = scanner.nextLine();
                        CongDan cdUpdate = inputCongDan();
                        cdUpdate.setCccd(cccdUpdate);
                        congDanDAO.updateCongDan(cdUpdate);
                        System.out.println("Cập nhật thành công!");
                        break;
                    case 4:
                        System.out.print("Nhập CCCD cần xóa: ");
                        String cccdDelete = scanner.nextLine();
                        congDanDAO.deleteCongDan(cccdDelete);
                        System.out.println("Xóa thành công!");
                        break;
                    case 5:
                        handleYeuCauCapLai();
                        break;
                    case 6:
                        handleYeuCauChinhSua();
                        break;
                    case 7:
                        return;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void userMenu(TaiKhoan taiKhoan) {
        while (true) {
            System.out.println("=== Menu Người dùng ===");
            System.out.println("1. Xem thông tin căn cước");
            System.out.println("2. Yêu cầu cấp mới/cấp lại/báo mất");
            System.out.println("3. Yêu cầu chỉnh sửa thông tin");
            System.out.println("4. Đăng xuất");
            int choice = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (choice) {
                    case 1:
                        CongDan cd = congDanDAO.getCongDan(taiKhoan.getCccd());
                        System.out.println(cd);
                        break;
                    case 2:
                        YeuCauCapLai yccl = inputYeuCauCapLai(taiKhoan.getCccd());
                        yeuCauCapLaiDAO.addYeuCau(yccl);
                        System.out.println("Gửi yêu cầu thành công!");
                        break;
                    case 3:
                        YeuCauChinhSua yccs = inputYeuCauChinhSua(taiKhoan.getCccd());
                        yeuCauChinhSuaDAO.addYeuCau(yccs);
                        System.out.println("Gửi yêu cầu thành công!");
                        break;
                    case 4:
                        return;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static CongDan inputCongDan() {
        System.out.print("Nhập CCCD: ");
        String cccd = scanner.nextLine();
        System.out.print("Nhập họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhập ngày sinh (YYYY-MM-DD): ");
        Date ngaySinh = Date.valueOf(scanner.nextLine());
        System.out.print("Nhập giới tính (NAM/NỮ): ");
        String gioiTinh = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String soDienThoai = scanner.nextLine();
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String diaChi = scanner.nextLine();
        System.out.print("Nhập ngày cấp (YYYY-MM-DD): ");
        Date ngayCap = Date.valueOf(scanner.nextLine());
        System.out.print("Nhập ngày hết hạn (YYYY-MM-DD): ");
        Date ngayHetHan = Date.valueOf(scanner.nextLine());
        return new CongDan(cccd, hoTen, ngaySinh, gioiTinh, soDienThoai, email, diaChi, ngayCap, ngayHetHan);
    }

    private static YeuCauCapLai inputYeuCauCapLai(String cccd) {
        System.out.print("Loại yêu cầu (MOI/CAP_LAI/MAT): ");
        String loaiYeuCau = scanner.nextLine();
        System.out.print("Tên người nhận: ");
        String tenNguoiNhan = scanner.nextLine();
        System.out.print("SĐT nhận: ");
        String soDienThoaiNhan = scanner.nextLine();
        System.out.print("Địa chỉ nhận: ");
        String diaChiNhan = scanner.nextLine();
        return new YeuCauCapLai(0, cccd, loaiYeuCau, "CHO_DUYET", "CHUA_GIAO", tenNguoiNhan, soDienThoaiNhan, diaChiNhan);
    }

    private static YeuCauChinhSua inputYeuCauChinhSua(String cccd) {
        System.out.print("Trường cần sửa (DCD_SoDienThoai/DCD_Email): ");
        String truongCanSua = scanner.nextLine();
        System.out.print("Giá trị mới: ");
        String giaTriMoi = scanner.nextLine();
        return new YeuCauChinhSua(0, cccd, truongCanSua, giaTriMoi, "CHO_DUYET");
    }

    private static void handleYeuCauCapLai() throws SQLException {
        List<YeuCauCapLai> list = yeuCauCapLaiDAO.getAllYeuCau();
        list.forEach(System.out::println);
        System.out.print("Nhập mã yêu cầu cần xử lý: ");
        int maYeuCau = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Duyệt (1) hay Từ chối (2): ");
        int action = scanner.nextInt();
        if (action == 1) {
            yeuCauCapLaiDAO.approveYeuCau(maYeuCau);
            System.out.println("Đã duyệt!");
        } else {
            yeuCauCapLaiDAO.rejectYeuCau(maYeuCau);
            System.out.println("Đã từ chối!");
        }
    }

    private static void handleYeuCauChinhSua() throws SQLException {
        List<YeuCauChinhSua> list = yeuCauChinhSuaDAO.getAllYeuCau();
        list.forEach(System.out::println);
        System.out.print("Nhập mã yêu cầu cần xử lý: ");
        int maYeuCau = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Duyệt (1) hay Từ chối (2): ");
        int action = scanner.nextInt();
        if (action == 1) {
            yeuCauChinhSuaDAO.approveYeuCau(maYeuCau);
            System.out.println("Đã duyệt!");
        } else {
            yeuCauChinhSuaDAO.rejectYeuCau(maYeuCau);
            System.out.println("Đã từ chối!");
        }
    }
}