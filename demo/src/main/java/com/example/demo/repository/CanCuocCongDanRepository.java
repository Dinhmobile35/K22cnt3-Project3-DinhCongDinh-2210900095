package com.example.demo.repository;

import com.example.demo.entity.CanCuocCongDan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanCuocCongDanRepository extends JpaRepository<CanCuocCongDan, Integer> {
}
