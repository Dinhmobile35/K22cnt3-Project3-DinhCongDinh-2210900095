package com.example.demo.service;

import com.example.demo.entity.NguoiDung;
import com.example.demo.repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NguoiDungService {

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    // Lấy danh sách tất cả người dùng
    public List<NguoiDung> getAllUsers() {
        return nguoiDungRepository.findAll();
    }

    // Tìm người dùng theo ID
    public Optional<NguoiDung> getUserById(Long id) {
        return nguoiDungRepository.findById(id);
    }

    // Tìm người dùng theo tên đăng nhập
    public Optional<NguoiDung> getUserByUsername(String tenDangNhap) {
        return nguoiDungRepository.findByTenDangNhap(tenDangNhap);
    }

    // Thêm hoặc cập nhật người dùng
    public NguoiDung saveUser(NguoiDung nguoiDung) {
        return nguoiDungRepository.save(nguoiDung);
    }

    // Cập nhật người dùng
    public NguoiDung updateUser(Long id, NguoiDung userDetails) {
        Optional<NguoiDung> optionalUser = nguoiDungRepository.findById(id);
        if (optionalUser.isPresent()) {
            NguoiDung existingUser = optionalUser.get();
            existingUser.setTenDangNhap(userDetails.getTenDangNhap());
            existingUser.setMatKhau(userDetails.getMatKhau());
            existingUser.setVaiTro(userDetails.getVaiTro());
            return nguoiDungRepository.save(existingUser);
        } else {
            throw new RuntimeException("Không tìm thấy người dùng có ID: " + id);
        }
    }

    // Xóa người dùng
    public void deleteUser(Long id) {
        nguoiDungRepository.deleteById(id);
    }
}
