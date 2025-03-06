package model;

public class TaiKhoan {
    private String soDienThoai;
    private String cccd;
    private String matKhau;
    private String vaiTro;
    private String trangThai;

    public TaiKhoan(String soDienThoai, String cccd, String matKhau, String vaiTro, String trangThai) {
        this.soDienThoai = soDienThoai;
        this.cccd = cccd;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.trangThai = trangThai;
    }

    // Getters
    public String getSoDienThoai() { return soDienThoai; }
    public String getCccd() { return cccd; }
    public String getMatKhau() { return matKhau; }
    public String getVaiTro() { return vaiTro; }
    public String getTrangThai() { return trangThai; }
}