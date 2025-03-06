package com.example.K22cnt3Project3DinhCongDinh2210900095.service;

import com.example.K22cnt3Project3DinhCongDinh2210900095.entity.DCD_YeuCauChinhSua;
import com.example.K22cnt3Project3DinhCongDinh2210900095.repository.DCD_YeuCauChinhSuaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DCD_YeuCauChinhSuaService {

    @Autowired
    private DCD_YeuCauChinhSuaRepository repository;

    public List<DCD_YeuCauChinhSua> getAllYeuCauChinhSua() {
        return repository.findAll();
    }

    public Optional<DCD_YeuCauChinhSua> getYeuCauChinhSuaById(int id) {
        return repository.findById(id);
    }

    public DCD_YeuCauChinhSua saveYeuCauChinhSua(DCD_YeuCauChinhSua yeuCauChinhSua) {
        return repository.save(yeuCauChinhSua);
    }

    public void deleteYeuCauChinhSuaById(int id) {
        repository.deleteById(id);
    }
}
