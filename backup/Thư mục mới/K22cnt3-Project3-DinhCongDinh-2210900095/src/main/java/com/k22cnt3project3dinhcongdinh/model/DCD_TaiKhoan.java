package com.k22cnt3project3dinhcongdinh.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import com.k22cnt3project3dinhcongdinh.model.Enums.*;

@Entity
@Table(name = "DCD_TaiKhoan")
@Data
public class DCD_TaiKhoan {
    @Id
    @Column(name = "DCD_SoDienThoai", length = 15)
    private String soDienThoai;

    @Column(name = "DCD_CCCD", unique = true, nullable = false, length = 12)
    private String cccd;

    @Column(name = "DCD_MatKhau", nullable = false, length = 100)
    private String matKhau;

    @Enumerated(EnumType.STRING)
    @Column(name = "DCD_VaiTro", nullable = false)
    private VaiTro vaiTro = VaiTro.NGUOI_DUNG;

    @Enumerated(EnumType.STRING)
    @Column(name = "DCD_TrangThai")
    private TrangThai trangThai = TrangThai.HOAT_DONG; // Thêm lại trạng thái

    @Column(name = "DCD_NgayTao", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao = new Date();

    @OneToOne
    @JoinColumn(name = "DCD_CCCD", referencedColumnName = "DCD_CCCD", insertable = false, updatable = false)
    private DCD_CongDan congDan;
}