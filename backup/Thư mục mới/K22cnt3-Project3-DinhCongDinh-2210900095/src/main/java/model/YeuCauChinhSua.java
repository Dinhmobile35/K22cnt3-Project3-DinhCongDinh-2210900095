package model;

public class YeuCauChinhSua {
    private int maYeuCau;
    private String cccd;
    private String truongCanSua;
    private String giaTriMoi;
    private String trangThai;

    public YeuCauChinhSua(int maYeuCau, String cccd, String truongCanSua, String giaTriMoi, String trangThai) {
        this.maYeuCau = maYeuCau;
        this.cccd = cccd;
        this.truongCanSua = truongCanSua;
        this.giaTriMoi = giaTriMoi;
        this.trangThai = trangThai;
    }

    // Getters
    public int getMaYeuCau() { return maYeuCau; }
    public String getCccd() { return cccd; }
    public String getTruongCanSua() { return truongCanSua; }
    public String getGiaTriMoi() { return giaTriMoi; }
    public String getTrangThai() { return trangThai; }

    @Override
    public String toString() {
        return "Mã yêu cầu: " + maYeuCau + ", CCCD: " + cccd + ", Trường cần sửa: " + truongCanSua +
                ", Giá trị mới: " + giaTriMoi + ", Trạng thái: " + trangThai;
    }
}