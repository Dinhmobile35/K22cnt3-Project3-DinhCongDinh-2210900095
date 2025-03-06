package com.example.demo.controller;

import com.example.demo.entity.CanCuocCongDan;
import com.example.demo.service.CanCuocCongDanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class CanCuocCongDanController {

    @Autowired
    private CanCuocCongDanService service;

    @GetMapping("/cancuoccongdan")
    public String getAllCanCuocCongDan(Model model) {
        List<CanCuocCongDan> danhSach = service.getAllCanCuocCongDan();
        model.addAttribute("danhSachCanCuocCongDan", danhSach);
        return "cancuoccongdan-list";
    }

    @GetMapping("/cancuoccongdan/{id}")
    public String getCanCuocCongDanById(@PathVariable Integer id, Model model) {
        Optional<CanCuocCongDan> canCuocCongDan = service.getCanCuocCongDanById(id);
        if (canCuocCongDan.isPresent()) {
            model.addAttribute("canCuocCongDan", canCuocCongDan.get());
            return "cancuoccongdan-detail";
        } else {
            return "redirect:/cancuoccongdan?error=notfound";
        }
    }
}
