package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "can_cuoc_cong_dan")
@Data
public class CanCuocCongDan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String danToc;
    private String tonGiao;
    private String queQuan;
    private String diaChiThuongTru;
    private String soDienThoai;
    private String email;
    private Date ngayCap;
    private String noiCap;
}
