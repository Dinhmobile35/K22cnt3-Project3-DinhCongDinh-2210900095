package com.example.K22cnt3Project3DinhCongDinh2210900095.controller;

import com.example.K22cnt3Project3DinhCongDinh2210900095.entity.DCD_YeuCauDoiMatKhau;
import com.example.K22cnt3Project3DinhCongDinh2210900095.service.DCD_YeuCauDoiMatKhauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/yeucaudoimatkhau")
public class DCD_YeuCauDoiMatKhauController {

    @Autowired
    private DCD_YeuCauDoiMatKhauService service;

    @GetMapping
    public List<DCD_YeuCauDoiMatKhau> getAllYeuCauDoiMatKhau() {
        return service.getAllYeuCauDoiMatKhau();
    }

    @GetMapping("/{id}")
    public Optional<DCD_YeuCauDoiMatKhau> getYeuCauDoiMatKhauById(@PathVariable int id) {
        return service.getYeuCauDoiMatKhauById(id);
    }

    @PostMapping
    public DCD_YeuCauDoiMatKhau createYeuCauDoiMatKhau(@RequestBody DCD_YeuCauDoiMatKhau yeuCauDoiMatKhau) {
        return service.saveYeuCauDoiMatKhau(yeuCauDoiMatKhau);
    }

    @DeleteMapping("/{id}")
    public void deleteYeuCauDoiMatKhauById(@PathVariable int id) {
        service.deleteYeuCauDoiMatKhauById(id);
    }
}
