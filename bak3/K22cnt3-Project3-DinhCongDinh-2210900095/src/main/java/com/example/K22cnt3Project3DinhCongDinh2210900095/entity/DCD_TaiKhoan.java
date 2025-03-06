package com.example.K22cnt3Project3DinhCongDinh2210900095.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "DCD_TaiKhoan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DCD_TaiKhoan {
    @Id
    private String DCD_SoDienThoai;

    private String DCD_CCCD;
    private String DCD_MatKhau;
    @Enumerated(EnumType.STRING)
    private VaiTro DCD_VaiTro;
    @Enumerated(EnumType.STRING)
    private TrangThai DCD_TrangThai;
    private Timestamp DCD_NgayTao;
}
