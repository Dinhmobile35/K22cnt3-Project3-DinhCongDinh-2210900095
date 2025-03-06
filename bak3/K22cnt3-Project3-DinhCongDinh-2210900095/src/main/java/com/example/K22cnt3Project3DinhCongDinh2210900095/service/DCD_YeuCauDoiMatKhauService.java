package com.example.K22cnt3Project3DinhCongDinh2210900095.service;

import com.example.K22cnt3Project3DinhCongDinh2210900095.entity.DCD_YeuCauDoiMatKhau;
import com.example.K22cnt3Project3DinhCongDinh2210900095.repository.DCD_YeuCauDoiMatKhauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DCD_YeuCauDoiMatKhauService {

    @Autowired
    private DCD_YeuCauDoiMatKhauRepository repository;

    public List<DCD_YeuCauDoiMatKhau> getAllYeuCauDoiMatKhau() {
        return repository.findAll();
    }

    public Optional<DCD_YeuCauDoiMatKhau> getYeuCauDoiMatKhauById(int id) {
        return repository.findById(id);
    }

    public DCD_YeuCauDoiMatKhau saveYeuCauDoiMatKhau(DCD_YeuCauDoiMatKhau yeuCauDoiMatKhau) {
        return repository.save(yeuCauDoiMatKhau);
    }

    public void deleteYeuCauDoiMatKhauById(int id) {
        repository.deleteById(id);
    }
}
