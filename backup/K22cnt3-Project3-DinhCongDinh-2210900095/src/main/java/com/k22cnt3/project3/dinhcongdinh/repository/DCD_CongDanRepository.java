package com.k22cnt3.project3.dinhcongdinh.repository;

import com.k22cnt3.project3.dinhcongdinh.model.DCD_CongDan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DCD_CongDanRepository extends JpaRepository<DCD_CongDan, String> {
}
