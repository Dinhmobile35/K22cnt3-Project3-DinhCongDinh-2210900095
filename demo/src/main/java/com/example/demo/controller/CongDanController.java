package com.example.demo.controller;

import com.example.demo.entity.CongDan;
import com.example.demo.service.CongDanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CongDanController {

    @Autowired
    private CongDanService congDanService;

    @GetMapping("/congdan")
    public String getAllCongDan(Model model) {
        List<CongDan> danhSachCongDan = congDanService.getAllCongDan();
        System.out.println("Danh sách công dân: " + danhSachCongDan); // Debug log
        model.addAttribute("danhSachCongDan", danhSachCongDan);
        return "congdan-list";
    }
}
