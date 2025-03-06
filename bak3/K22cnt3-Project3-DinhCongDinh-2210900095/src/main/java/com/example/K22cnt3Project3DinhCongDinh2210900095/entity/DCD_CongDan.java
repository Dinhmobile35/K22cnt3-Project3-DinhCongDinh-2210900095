package com.example.K22cnt3Project3DinhCongDinh2210900095.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;


@NoArgsConstructor
@AllArgsConstructor
public class DCD_CongDan {

    private String DCD_CCCD;

    private String DCD_HoTen;
    private Date DCD_NgaySinh;
    @Enumerated(EnumType.STRING)
    private GioiTinh DCD_GioiTinh;
    private String DCD_SoDienThoai;
    private String DCD_Email;
    private String DCD_DiaChi;
    private Date DCD_NgayCap;
    private Date DCD_NgayHetHan;
    private Timestamp DCD_NgayTao;
}
