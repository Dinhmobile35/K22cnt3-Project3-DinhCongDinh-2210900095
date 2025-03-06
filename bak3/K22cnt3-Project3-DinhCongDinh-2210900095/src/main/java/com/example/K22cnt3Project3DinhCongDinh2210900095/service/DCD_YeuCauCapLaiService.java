package com.example.K22cnt3Project3DinhCongDinh2210900095.service;

import com.example.K22cnt3Project3DinhCongDinh2210900095.entity.DCD_YeuCauCapLai;
import com.example.K22cnt3Project3DinhCongDinh2210900095.repository.DCD_YeuCauCapLaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DCD_YeuCauCapLaiService {

    @Autowired
    private DCD_YeuCauCapLaiRepository repository;

    public List<DCD_YeuCauCapLai> getAllYeuCauCapLai() {
        return repository.findAll();
    }

    public Optional<DCD_YeuCauCapLai> getYeuCauCapLaiById(int id) {
        return repository.findById(id);
    }

    public DCD_YeuCauCapLai saveYeuCauCapLai(DCD_YeuCauCapLai yeuCauCapLai) {
        return repository.save(yeuCauCapLai);
    }

    public void deleteYeuCauCapLaiById(int id) {
        repository.deleteById(id);
    }
}
