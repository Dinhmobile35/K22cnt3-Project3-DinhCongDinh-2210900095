package model;

import java.sql.Timestamp;

public class YeuCauCapLai {
    private int maYeuCau;
    private String cccd;
    private String loaiYeuCau;
    private String trangThai;
    private String trangThaiGiaoHang;
    private String tenNguoiNhan;
    private String soDienThoaiNhan;
    private String diaChiNhan;
    private Timestamp ngayTao;
    private Timestamp ngayCapNhat;

    // Thêm constructor mặc định
    public YeuCauCapLai() {
        // Giá trị mặc định (có thể để null hoặc gán giá trị mặc định nếu cần)
        this.maYeuCau = 0;
        this.cccd = null;
        this.loaiYeuCau = null;
        this.trangThai = null;
        this.trangThaiGiaoHang = null;
        this.tenNguoiNhan = null;
        this.soDienThoaiNhan = null;
        this.diaChiNhan = null;
        this.ngayTao = null;
        this.ngayCapNhat = null;
    }

    // Constructor với 10 tham số
    public YeuCauCapLai(int maYeuCau, String cccd, String loaiYeuCau, String trangThai, String trangThaiGiaoHang,
                        String tenNguoiNhan, String soDienThoaiNhan, String diaChiNhan, Timestamp ngayTao, Timestamp ngayCapNhat) {
        this.maYeuCau = maYeuCau;
        this.cccd = cccd;
        this.loaiYeuCau = loaiYeuCau;
        this.trangThai = trangThai;
        this.trangThaiGiaoHang = trangThaiGiaoHang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.soDienThoaiNhan = soDienThoaiNhan;
        this.diaChiNhan = diaChiNhan;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    // Getter và Setter
    public int getMaYeuCau() { return maYeuCau; }
    public void setMaYeuCau(int maYeuCau) { this.maYeuCau = maYeuCau; }

    public String getCccd() { return cccd; }
    public void setCccd(String cccd) { this.cccd = cccd; }

    public String getLoaiYeuCau() { return loaiYeuCau; }
    public void setLoaiYeuCau(String loaiYeuCau) { this.loaiYeuCau = loaiYeuCau; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }

    public String getTrangThaiGiaoHang() { return trangThaiGiaoHang; }
    public void setTrangThaiGiaoHang(String trangThaiGiaoHang) { this.trangThaiGiaoHang = trangThaiGiaoHang; }

    public String getTenNguoiNhan() { return tenNguoiNhan; }
    public void setTenNguoiNhan(String tenNguoiNhan) { this.tenNguoiNhan = tenNguoiNhan; }

    public String getSoDienThoaiNhan() { return soDienThoaiNhan; }
    public void setSoDienThoaiNhan(String soDienThoaiNhan) { this.soDienThoaiNhan = soDienThoaiNhan; }

    public String getDiaChiNhan() { return diaChiNhan; }
    public void setDiaChiNhan(String diaChiNhan) { this.diaChiNhan = diaChiNhan; }

    public Timestamp getNgayTao() { return ngayTao; }
    public void setNgayTao(Timestamp ngayTao) { this.ngayTao = ngayTao; }

    public Timestamp getNgayCapNhat() { return ngayCapNhat; }
    public void setNgayCapNhat(Timestamp ngayCapNhat) { this.ngayCapNhat = ngayCapNhat; }
}