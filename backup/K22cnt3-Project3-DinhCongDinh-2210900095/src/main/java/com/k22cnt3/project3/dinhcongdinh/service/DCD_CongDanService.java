package com.k22cnt3.project3.dinhcongdinh.service;



import com.k22cnt3.project3.dinhcongdinh.model.DCD_CongDan;
import com.k22cnt3.project3.dinhcongdinh.repository.DCD_CongDanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DCD_CongDanService {

    @Autowired
    private DCD_CongDanRepository congDanRepository;

    public List<DCD_CongDan> getAllCongDan() {
        return congDanRepository.findAll();
    }

    public Optional<DCD_CongDan> getCongDanById(String cccd) {
        return congDanRepository.findById(cccd);
    }

    public DCD_CongDan saveCongDan(DCD_CongDan congDan) {
        return congDanRepository.save(congDan);
    }

    public void deleteCongDan(String cccd) {
        congDanRepository.deleteById(cccd);
    }
}
