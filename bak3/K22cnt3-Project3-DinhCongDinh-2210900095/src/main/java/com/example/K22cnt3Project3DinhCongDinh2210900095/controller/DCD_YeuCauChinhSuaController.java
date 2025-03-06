package com.example.K22cnt3Project3DinhCongDinh2210900095.controller;

import com.example.K22cnt3Project3DinhCongDinh2210900095.entity.DCD_YeuCauChinhSua;
import com.example.K22cnt3Project3DinhCongDinh2210900095.service.DCD_YeuCauChinhSuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/yeucauchinhsua")
public class DCD_YeuCauChinhSuaController {

    @Autowired
    private DCD_YeuCauChinhSuaService service;

    @GetMapping
    public List<DCD_YeuCauChinhSua> getAllYeuCauChinhSua() {
        return service.getAllYeuCauChinhSua();
    }

    @GetMapping("/{id}")
    public Optional<DCD_YeuCauChinhSua> getYeuCauChinhSuaById(@PathVariable int id) {
        return service.getYeuCauChinhSuaById(id);
    }

    @PostMapping
    public DCD_YeuCauChinhSua createYeuCauChinhSua(@RequestBody DCD_YeuCauChinhSua yeuCauChinhSua) {
        return service.saveYeuCauChinhSua(yeuCauChinhSua);
    }

    @DeleteMapping("/{id}")
    public void deleteYeuCauChinhSuaById(@PathVariable int id) {
        service.deleteYeuCauChinhSuaById(id);
    }
}
