package com.k22cnt3.project3.dinhcongdinh.controller;

import com.k22cnt3.project3.dinhcongdinh.model.DCD_CongDan;
import com.k22cnt3.project3.dinhcongdinh.service.DCD_CongDanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DCD_CongDanController {

    @Autowired
    private DCD_CongDanService congDanService;

    @GetMapping("/congdan-list")
    public String danhSachCongDan(Model model) {
        List<DCD_CongDan> congDanList = congDanService.getAllCongDan();
        model.addAttribute("congDanList", congDanList);
        return "congdan-list"; // Tên file trong thư mục templates
    }
}

