package com.k22cnt3.project3.dinhcongdinh.service;

import com.k22cnt3.project3.dinhcongdinh.model.DCD_YeuCauDoiMatKhau;
import com.k22cnt3.project3.dinhcongdinh.repository.DCD_YeuCauDoiMatKhauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DCD_YeuCauDoiMatKhauService {

    @Autowired
    private DCD_YeuCauDoiMatKhauRepository yeuCauDoiMatKhauRepository;

    public List<DCD_YeuCauDoiMatKhau> getAllYeuCauDoiMatKhau() {
        return yeuCauDoiMatKhauRepository.findAll();
    }

    public DCD_YeuCauDoiMatKhau saveYeuCauDoiMatKhau(DCD_YeuCauDoiMatKhau yeuCauDoiMatKhau) {
        return yeuCauDoiMatKhauRepository.save(yeuCauDoiMatKhau);
    }
}

