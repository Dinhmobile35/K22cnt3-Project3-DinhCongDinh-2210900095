package com.example.K22cnt3Project3DinhCongDinh2210900095.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "DCD_YeuCauDoiMatKhau")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DCD_YeuCauDoiMatKhau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DCD_MaYeuCau;

    private String DCD_SoDienThoai;
    private String DCD_MatKhauMoi;
    @Enumerated(EnumType.STRING)
    private TrangThai DCD_TrangThai;
    private Timestamp DCD_NgayTao;
}
