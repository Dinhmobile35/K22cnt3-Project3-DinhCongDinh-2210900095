package com.example.demo.service.impl;

import com.example.demo.entity.CongDan;
import com.example.demo.repository.CongDanRepository;
import com.example.demo.service.CongDanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CongDanServiceImpl implements CongDanService {

    @Autowired
    private CongDanRepository congDanRepository;

    @Override
    public List<CongDan> getAllCongDan() {
        return congDanRepository.findAll();
    }

    @Override
    public Optional<CongDan> getCongDanById(Integer id) {
        return congDanRepository.findById(id);
    }
}
