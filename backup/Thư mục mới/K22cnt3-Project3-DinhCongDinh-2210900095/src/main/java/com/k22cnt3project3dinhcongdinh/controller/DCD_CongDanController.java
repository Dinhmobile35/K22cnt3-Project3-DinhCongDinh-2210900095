package com.k22cnt3project3dinhcongdinh.controller;

import com.k22cnt3project3dinhcongdinh.model.DCD_CongDan;
import com.k22cnt3project3dinhcongdinh.service.DCD_CongDanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/congdan")
public class DCD_CongDanController {

    @Autowired
    private DCD_CongDanService congDanService;

    @GetMapping
    public String listCongDan(Model model) {
        model.addAttribute("congDanList", congDanService.getAllCongDan());
        return "congdan/list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("congDan", new DCD_CongDan());
        return "congdan/form";
    }

    @PostMapping
    public String saveCongDan(@ModelAttribute("congDan") DCD_CongDan congDan, Model model) {
        try {
            congDanService.saveCongDan(congDan);
            return "redirect:/congdan";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi lưu công dân: " + e.getMessage());
            return "congdan/form";
        }
    }

    @GetMapping("/edit/{cccd}")
    public String showEditForm(@PathVariable String cccd, Model model) {
        DCD_CongDan congDan = congDanService.getCongDanByCccd(cccd)
                .orElse(null);
        if (congDan == null) {
            model.addAttribute("error", "Không tìm thấy công dân với CCCD: " + cccd);
            return "congdan/list";
        }
        model.addAttribute("congDan", congDan);
        return "congdan/form";
    }

    @GetMapping("/delete/{cccd}")
    public String deleteCongDan(@PathVariable String cccd, Model model) {
        try {
            congDanService.deleteCongDan(cccd);
            return "redirect:/congdan";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi xóa công dân: " + e.getMessage());
            return "congdan/list";
        }
    }
}