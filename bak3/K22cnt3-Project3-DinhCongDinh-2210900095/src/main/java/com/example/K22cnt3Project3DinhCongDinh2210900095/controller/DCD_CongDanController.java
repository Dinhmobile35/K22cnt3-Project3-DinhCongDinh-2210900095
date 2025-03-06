package com.example.K22cnt3Project3DinhCongDinh2210900095.controller;

import com.example.K22cnt3Project3DinhCongDinh2210900095.entity.DCD_CongDan;
import com.example.K22cnt3Project3DinhCongDinh2210900095.service.DCD_CongDanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/congdan")
public class DCD_CongDanController {

    @Autowired
    private DCD_CongDanService service;

    @GetMapping
    public List<DCD_CongDan> getAllCongDan() {
        return service.getAllCongDan();
    }

    @GetMapping("/{id}")
    public Optional<DCD_CongDan> getCongDanById(@PathVariable String id) {
        return service.getCongDanById(id);
    }

    @PostMapping
    public DCD_CongDan createCongDan(@RequestBody DCD_CongDan congDan) {
        return service.saveCongDan(congDan);
    }

    @DeleteMapping("/{id}")
    public void deleteCongDanById(@PathVariable String id) {
        service.deleteCongDanById(id);
    }
}
