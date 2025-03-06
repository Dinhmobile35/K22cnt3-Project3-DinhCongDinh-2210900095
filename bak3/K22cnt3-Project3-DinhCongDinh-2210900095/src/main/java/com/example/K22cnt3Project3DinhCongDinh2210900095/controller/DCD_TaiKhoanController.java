package com.example.K22cnt3Project3DinhCongDinh2210900095.controller;

import com.example.K22cnt3Project3DinhCongDinh2210900095.entity.DCD_TaiKhoan;
import com.example.K22cnt3Project3DinhCongDinh2210900095.service.DCD_TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/taikhoan")
public class DCD_TaiKhoanController {

    @Autowired
    private DCD_TaiKhoanService service;

    @GetMapping
    public List<DCD_TaiKhoan> getAllTaiKhoan() {
        return service.getAllTaiKhoan();
    }

    @GetMapping("/{soDienThoai}")
    public Optional<DCD_TaiKhoan> getTaiKhoanBySoDienThoai(@PathVariable String soDienThoai) {
        return service.getTaiKhoanBySoDienThoai(soDienThoai);
    }

    @PostMapping
    public DCD_TaiKhoan createTaiKhoan(@RequestBody DCD_TaiKhoan taiKhoan) {
        return service.saveTaiKhoan(taiKhoan);
    }

    @DeleteMapping("/{soDienThoai}")
    public void deleteTaiKhoanBySoDienThoai(@PathVariable String soDienThoai) {
        service.deleteTaiKhoanBySoDienThoai(soDienThoai);
    }
}
