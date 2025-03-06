package com.k22cnt3.project3.dinhcongdinh.repository;

import com.k22cnt3.project3.dinhcongdinh.model.DCD_TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DCD_TaiKhoanRepository extends JpaRepository<DCD_TaiKhoan, String> {
    Optional<DCD_TaiKhoan> findBySoDienThoai(String soDienThoai);
}
