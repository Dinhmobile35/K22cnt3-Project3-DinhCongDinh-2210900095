package com.k22cnt3.project3.dinhcongdinh.controller;

import com.k22cnt3.project3.dinhcongdinh.model.DCD_TaiKhoan;
import com.k22cnt3.project3.dinhcongdinh.service.DCD_TaiKhoanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class DCD_AuthController {

    private final DCD_TaiKhoanService taiKhoanService;

    public DCD_AuthController(DCD_TaiKhoanService taiKhoanService) {
        this.taiKhoanService = taiKhoanService;
    }

    @GetMapping("/dang-nhap")
    public String showLoginForm() {
        return "auth/dang-nhap";
    }

    @PostMapping("/dang-nhap")
    public String login(@RequestParam String soDienThoai, @RequestParam String matKhau, HttpSession session, Model model) {
        Optional<DCD_TaiKhoan> taiKhoan = taiKhoanService.xacThucTaiKhoan(soDienThoai, matKhau);

        if (taiKhoan.isPresent()) {
            session.setAttribute("nguoiDung", taiKhoan.get());
            return "redirect:/";
        } else {
            model.addAttribute("error", "Số điện thoại hoặc mật khẩu không đúng");
            return "auth/dang-nhap";
        }
    }

    @GetMapping("/dang-ky")
    public String showRegisterForm(Model model) {
        model.addAttribute("taiKhoan", new DCD_TaiKhoan());
        return "auth/dang-ky";
    }

    @PostMapping("/dang-ky")
    public String register(@ModelAttribute DCD_TaiKhoan taiKhoan, HttpSession session, Model model) {
        boolean isRegistered = taiKhoanService.dangKyTaiKhoan(taiKhoan);
        if (isRegistered) {
            session.setAttribute("nguoiDung", taiKhoan);  // Tự động đăng nhập
            return "redirect:/";
        } else {
            model.addAttribute("error", "Số CCCD hoặc số điện thoại đã tồn tại");
            return "auth/dang-ky";
        }
    }

    @GetMapping("/dang-xuat")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/dang-nhap";
    }
}
