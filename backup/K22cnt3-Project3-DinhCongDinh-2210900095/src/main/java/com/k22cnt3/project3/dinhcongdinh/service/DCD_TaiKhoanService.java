package com.k22cnt3.project3.dinhcongdinh.service;

import com.k22cnt3.project3.dinhcongdinh.model.DCD_TaiKhoan;
import com.k22cnt3.project3.dinhcongdinh.repository.DCD_TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DCD_TaiKhoanService {

    @Autowired
    private DCD_TaiKhoanRepository taiKhoanRepository;

    // Xác thực đăng nhập
    public Optional<DCD_TaiKhoan> xacThucTaiKhoan(String soDienThoai, String matKhau) {
        return taiKhoanRepository.findBySoDienThoai(soDienThoai)
                .filter(tk -> tk.getMatKhau().equals(matKhau));
    }

    // Lấy thông tin tài khoản theo số điện thoại
    public Optional<DCD_TaiKhoan> getTaiKhoanBySoDienThoai(String soDienThoai) {
        return taiKhoanRepository.findBySoDienThoai(soDienThoai);
    }

    // Đăng ký tài khoản mới
    public boolean dangKyTaiKhoan(DCD_TaiKhoan taiKhoan) {
        if (taiKhoanRepository.findBySoDienThoai(taiKhoan.getSoDienThoai()).isPresent()) {
            return false; // Số điện thoại đã tồn tại
        }
        taiKhoanRepository.save(taiKhoan);
        return true;
    }

    // Lưu tài khoản
    public DCD_TaiKhoan saveTaiKhoan(DCD_TaiKhoan taiKhoan) {
        return taiKhoanRepository.save(taiKhoan);
    }

    // Xóa tài khoản theo số điện thoại
    public void deleteTaiKhoan(String soDienThoai) {
        taiKhoanRepository.findBySoDienThoai(soDienThoai)
                .ifPresent(taiKhoanRepository::delete);
    }
}
