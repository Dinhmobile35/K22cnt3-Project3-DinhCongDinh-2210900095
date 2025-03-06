package com.k22cnt3.project3.dinhcongdinh.controller;

import com.k22cnt3.project3.dinhcongdinh.model.DCD_TaiKhoan;
import com.k22cnt3.project3.dinhcongdinh.service.DCD_TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/taikhoan")
public class DCD_TaiKhoanController {

    @Autowired
    private DCD_TaiKhoanService taiKhoanService;

    // Xác thực đăng nhập
    @PostMapping("/dang-nhap")
    public ResponseEntity<DCD_TaiKhoan> dangNhap(@RequestParam String soDienThoai, @RequestParam String matKhau) {
        Optional<DCD_TaiKhoan> taiKhoan = taiKhoanService.xacThucTaiKhoan(soDienThoai, matKhau);

        return taiKhoan.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(401).build());
    }

    // Lấy thông tin tài khoản theo số điện thoại
    @GetMapping("/{soDienThoai}")
    public ResponseEntity<DCD_TaiKhoan> getTaiKhoan(@PathVariable String soDienThoai) {
        Optional<DCD_TaiKhoan> taiKhoan = taiKhoanService.getTaiKhoanBySoDienThoai(soDienThoai);
        return taiKhoan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Đăng ký tài khoản
    @PostMapping("/dang-ky")
    public ResponseEntity<String> dangKyTaiKhoan(@RequestBody DCD_TaiKhoan taiKhoan) {
        boolean isRegistered = taiKhoanService.dangKyTaiKhoan(taiKhoan);
        if (isRegistered) {
            return ResponseEntity.ok("Đăng ký thành công");
        } else {
            return ResponseEntity.badRequest().body("Số điện thoại đã tồn tại");
        }
    }

    // Xóa tài khoản theo số điện thoại
    @DeleteMapping("/{soDienThoai}")
    public ResponseEntity<Void> deleteTaiKhoan(@PathVariable String soDienThoai) {
        taiKhoanService.deleteTaiKhoan(soDienThoai);
        return ResponseEntity.noContent().build();
    }
}
