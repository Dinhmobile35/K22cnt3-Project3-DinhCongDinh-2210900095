package com.k22cnt3.project3.dinhcongdinh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DCD_HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Trang chủ");
        return "index"; // Trả về file index.html trong thư mục templates
    }
}
