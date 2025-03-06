package com.example.K22cnt3Project3DinhCongDinh2210900095.controller;

import com.example.K22cnt3Project3DinhCongDinh2210900095.entity.DCD_YeuCauCapLai;
import com.example.K22cnt3Project3DinhCongDinh2210900095.service.DCD_YeuCauCapLaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/yeucaucaplai")
public class DCD_YeuCauCapLaiController {

    @Autowired
    private DCD_YeuCauCapLaiService service;

    @GetMapping
    public List<DCD_YeuCauCapLai> getAllYeuCauCapLai() {
        return service.getAllYeuCauCapLai();
    }

    @GetMapping("/{id}")
    public Optional<DCD_YeuCauCapLai> getYeuCauCapLaiById(@PathVariable int id) {
        return service.getYeuCauCapLaiById(id);
    }

    @PostMapping
    public DCD_YeuCauCapLai createYeuCauCapLai(@RequestBody DCD_YeuCauCapLai yeuCauCapLai) {
        return service.saveYeuCauCapLai(yeuCauCapLai);
    }

    @DeleteMapping("/{id}")
    public void deleteYeuCauCapLaiById(@PathVariable int id) {
        service.deleteYeuCauCapLaiById(id);
    }
}
