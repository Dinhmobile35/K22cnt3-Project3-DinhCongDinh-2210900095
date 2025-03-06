package model;

public class YeuCauCapLai {
    private int maYeuCau;
    private String cccd;
    private String loaiYeuCau;
    private String trangThai;
    private String trangThaiGiaoHang;
    private String tenNguoiNhan;
    private String soDienThoaiNhan;
    private String diaChiNhan;

    public YeuCauCapLai(int maYeuCau, String cccd, String loaiYeuCau, String trangThai, String trangThaiGiaoHang, String tenNguoiNhan, String soDienThoaiNhan, String diaChiNhan) {
        this.maYeuCau = maYeuCau;
        this.cccd = cccd;
        this.loaiYeuCau = loaiYeuCau;
        this.trangThai = trangThai;
        this.trangThaiGiaoHang = trangThaiGiaoHang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.soDienThoaiNhan = soDienThoaiNhan;
        this.diaChiNhan = diaChiNhan;
    }

    // Getters
    public int getMaYeuCau() { return maYeuCau; }
    public String getCccd() { return cccd; }
    public String getLoaiYeuCau() { return loaiYeuCau; }
    public String getTrangThai() { return trangThai; }
    public String getTrangThaiGiaoHang() { return trangThaiGiaoHang; }
    public String getTenNguoiNhan() { return tenNguoiNhan; }
    public String getSoDienThoaiNhan() { return soDienThoaiNhan; }
    public String getDiaChiNhan() { return diaChiNhan; }

    @Override
    public String toString() {
        return "Mã yêu cầu: " + maYeuCau + ", CCCD: " + cccd + ", Loại: " + loaiYeuCau + ", Trạng thái: " + trangThai +
                ", Giao hàng: " + trangThaiGiaoHang + ", Người nhận: " + tenNguoiNhan + ", SĐT nhận: " + soDienThoaiNhan +
                ", Địa chỉ nhận: " + diaChiNhan;
    }
}