package com.example.demo.service;

import com.example.demo.entity.NguoiDung;
import com.example.demo.repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Override
    public UserDetails loadUserByUsername(String tenDangNhap) throws UsernameNotFoundException {
        Optional<NguoiDung> nguoiDungOptional = nguoiDungRepository.findByTenDangNhap(tenDangNhap);
        if (nguoiDungOptional.isEmpty()) {
            throw new UsernameNotFoundException("Không tìm thấy người dùng: " + tenDangNhap);
        }

        NguoiDung nguoiDung = nguoiDungOptional.get();
        return User.withUsername(nguoiDung.getTenDangNhap())
                .password(nguoiDung.getMatKhau())
                .roles(nguoiDung.getVaiTro()) // Đảm bảo vai trò được lưu đúng trong DB
                .build();
    }
}
