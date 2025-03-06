package com.example.demo.controller;

import com.example.demo.entity.NguoiDung;
import com.example.demo.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private NguoiDungService nguoiDungService;

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<NguoiDung> users = nguoiDungService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list"; // Trả về trang user-list.html
    }
}
