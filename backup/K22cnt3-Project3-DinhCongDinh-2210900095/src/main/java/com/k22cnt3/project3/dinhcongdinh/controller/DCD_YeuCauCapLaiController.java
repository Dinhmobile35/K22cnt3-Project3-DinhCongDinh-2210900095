package com.k22cnt3.project3.dinhcongdinh.controller;


import com.k22cnt3.project3.dinhcongdinh.model.DCD_YeuCauCapLai;
import com.k22cnt3.project3.dinhcongdinh.service.DCD_YeuCauCapLaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/yeucaucaplai")
public class DCD_YeuCauCapLaiController {

    @Autowired
    private DCD_YeuCauCapLaiService yeuCauCapLaiService;

    @GetMapping
    public List<DCD_YeuCauCapLai> getAllYeuCauCapLai() {
        return yeuCauCapLaiService.getAllYeuCauCapLai();
    }

    @PostMapping
    public DCD_YeuCauCapLai createYeuCauCapLai(@RequestBody DCD_YeuCauCapLai yeuCauCapLai) {
        return yeuCauCapLaiService.saveYeuCauCapLai(yeuCauCapLai);
    }
}
