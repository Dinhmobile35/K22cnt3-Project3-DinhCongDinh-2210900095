package com.example.K22cnt3Project3DinhCongDinh2210900095.service;

import com.example.K22cnt3Project3DinhCongDinh2210900095.entity.DCD_TaiKhoan;
import com.example.K22cnt3Project3DinhCongDinh2210900095.repository.DCD_TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DCD_TaiKhoanService {

    @Autowired
    private DCD_TaiKhoanRepository repository;

    public List<DCD_TaiKhoan> getAllTaiKhoan() {
        return repository.findAll();
    }

    public Optional<DCD_TaiKhoan> getTaiKhoanBySoDienThoai(String soDienThoai) {
        return repository.findById(soDienThoai);
    }

    public DCD_TaiKhoan saveTaiKhoan(DCD_TaiKhoan taiKhoan) {
        return repository.save(taiKhoan);
    }

    public void deleteTaiKhoanBySoDienThoai(String soDienThoai) {
        repository.deleteById(soDienThoai);
    }
}
