package com.k22cnt3.project3.dinhcongdinh.service;

import com.k22cnt3.project3.dinhcongdinh.model.DCD_YeuCauCapLai;
import com.k22cnt3.project3.dinhcongdinh.repository.DCD_YeuCauCapLaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DCD_YeuCauCapLaiService {

    @Autowired
    private DCD_YeuCauCapLaiRepository yeuCauCapLaiRepository;

    public List<DCD_YeuCauCapLai> getAllYeuCauCapLai() {
        return yeuCauCapLaiRepository.findAll();
    }

    public DCD_YeuCauCapLai saveYeuCauCapLai(DCD_YeuCauCapLai yeuCauCapLai) {
        return yeuCauCapLaiRepository.save(yeuCauCapLai);
    }
}
