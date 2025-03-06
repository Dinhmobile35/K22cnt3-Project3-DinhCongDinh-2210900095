package com.example.demo.service;

import com.example.demo.entity.CongDan;
import java.util.List;
import java.util.Optional;

public interface CongDanService {
    List<CongDan> getAllCongDan();
    Optional<CongDan> getCongDanById(Integer id);
}
