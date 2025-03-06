package com.k22cnt3project3dinhcongdinh.service;

import com.k22cnt3project3dinhcongdinh.model.DCD_CongDan;
import com.k22cnt3project3dinhcongdinh.repository.DCD_CongDanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DCD_CongDanService {

    private static final Logger logger = LoggerFactory.getLogger(DCD_CongDanService.class);

    @Autowired
    private DCD_CongDanRepository congDanRepository;

    public List<DCD_CongDan> getAllCongDan() {
        List<DCD_CongDan> congDanList = congDanRepository.findAll();
        logger.info("Số lượng công dân tìm thấy: {}", congDanList.size());
        return congDanList;
    }

    public Optional<DCD_CongDan> getCongDanByCccd(String cccd) {
        return congDanRepository.findById(cccd);
    }

    public DCD_CongDan saveCongDan(DCD_CongDan congDan) {
        return congDanRepository.save(congDan);
    }

    public void deleteCongDan(String cccd) {
        congDanRepository.deleteById(cccd);
    }
}