package com.example.demo.service.impl;

import com.example.demo.entity.CanCuocCongDan;
import com.example.demo.repository.CanCuocCongDanRepository;
import com.example.demo.service.CanCuocCongDanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CanCuocCongDanServiceImpl implements CanCuocCongDanService {

    @Autowired
    private CanCuocCongDanRepository repository;

    @Override
    public List<CanCuocCongDan> getAllCanCuocCongDan() {
        return repository.findAll();
    }

    @Override
    public Optional<CanCuocCongDan> getCanCuocCongDanById(Integer id) {
        return repository.findById(id);
    }
}
