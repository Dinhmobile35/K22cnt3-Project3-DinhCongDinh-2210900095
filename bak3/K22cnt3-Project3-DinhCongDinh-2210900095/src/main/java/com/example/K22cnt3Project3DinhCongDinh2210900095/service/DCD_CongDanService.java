package com.example.K22cnt3Project3DinhCongDinh2210900095.service;

import com.example.K22cnt3Project3DinhCongDinh2210900095.entity.DCD_CongDan;
import com.example.K22cnt3Project3DinhCongDinh2210900095.repository.DCD_CongDanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DCD_CongDanService {

    @Autowired
    private DCD_CongDanRepository repository;

    public List<DCD_CongDan> getAllCongDan() {
        return repository.findAll();
    }

    public Optional<DCD_CongDan> getCongDanById(String id) {
        return repository.findById(id);
    }

    public DCD_CongDan saveCongDan(DCD_CongDan congDan) {
        return repository.save(congDan);
    }

    public void deleteCongDanById(String id) {
        repository.deleteById(id);
    }
}
