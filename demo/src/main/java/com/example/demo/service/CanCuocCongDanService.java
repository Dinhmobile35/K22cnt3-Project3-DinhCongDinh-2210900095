package com.example.demo.service;

import com.example.demo.entity.CanCuocCongDan;
import java.util.List;
import java.util.Optional;

public interface CanCuocCongDanService {
    List<CanCuocCongDan> getAllCanCuocCongDan();
    Optional<CanCuocCongDan> getCanCuocCongDanById(Integer id);
}
