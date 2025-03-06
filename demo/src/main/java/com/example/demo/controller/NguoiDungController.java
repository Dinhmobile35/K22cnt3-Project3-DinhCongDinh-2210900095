package com.example.demo.controller;

import com.example.demo.entity.NguoiDung;
import com.example.demo.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nguoidung")
public class NguoiDungController {

    @Autowired
    private NguoiDungService nguoiDungService;

    // Lấy danh sách tất cả người dùng
    @GetMapping("/all")
    public List<NguoiDung> getAllUsers() {
        return nguoiDungService.getAllUsers();
    }

    // Tìm người dùng theo ID
    @GetMapping("/{id}")
    public Optional<NguoiDung> getUserById(@PathVariable Long id) {
        return nguoiDungService.getUserById(id);
    }

    // Thêm người dùng mới
    @PostMapping("/add")
    public NguoiDung addUser(@RequestBody NguoiDung nguoiDung) {
        return nguoiDungService.saveUser(nguoiDung);
    }

    // Cập nhật thông tin người dùng
    @PutMapping("/update/{id}")
    public NguoiDung updateUser(@PathVariable Long id, @RequestBody NguoiDung userDetails) {
        return nguoiDungService.updateUser(id, userDetails);
    }

    // Xóa người dùng
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        nguoiDungService.deleteUser(id);
        return "Xóa người dùng thành công!";
    }
}
