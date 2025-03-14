package model;

import java.sql.Timestamp;

public class YeuCauDoiMatKhau {
    private int maYeuCau;
    private String soDienThoai;
    private String matKhauMoi;
    private String trangThai;
    private Timestamp ngayTao;

    public YeuCauDoiMatKhau(int maYeuCau, String soDienThoai, String matKhauMoi, String trangThai, Timestamp ngayTao) {
        this.maYeuCau = maYeuCau;
        this.soDienThoai = soDienThoai;
        this.matKhauMoi = matKhauMoi;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }

    public int getMaYeuCau() { return maYeuCau; }
    public String getSoDienThoai() { return soDienThoai; }
    public String getMatKhauMoi() { return matKhauMoi; }
    public String getTrangThai() { return trangThai; }
    public Timestamp getNgayTao() { return ngayTao; }
}