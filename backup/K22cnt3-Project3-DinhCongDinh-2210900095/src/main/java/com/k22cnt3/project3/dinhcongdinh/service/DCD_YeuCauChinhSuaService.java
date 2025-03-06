package com.k22cnt3.project3.dinhcongdinh.service;


import com.k22cnt3.project3.dinhcongdinh.model.DCD_YeuCauChinhSua;
import com.k22cnt3.project3.dinhcongdinh.repository.DCD_YeuCauChinhSuaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DCD_YeuCauChinhSuaService {

    @Autowired
    private DCD_YeuCauChinhSuaRepository yeuCauChinhSuaRepository;

    public List<DCD_YeuCauChinhSua> getAllYeuCauChinhSua() {
        return yeuCauChinhSuaRepository.findAll();
    }

    public DCD_YeuCauChinhSua saveYeuCauChinhSua(DCD_YeuCauChinhSua yeuCauChinhSua) {
        return yeuCauChinhSuaRepository.save(yeuCauChinhSua);
    }
}
