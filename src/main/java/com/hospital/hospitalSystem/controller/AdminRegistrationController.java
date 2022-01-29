package com.hospital.hospitalSystem.controller;

import com.hospital.hospitalSystem.domain.Admin;
import com.hospital.hospitalSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * contains controller logic for register new admin
 * */
@Controller
@RequestMapping("/registration")
public class AdminRegistrationController {

    @Autowired
    private AdminService adminService;

    @ModelAttribute("admin")
    public Admin adminRegistrationDto() {
        return new Admin();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerAdminAccount(@ModelAttribute("admin") Admin admin) {
        adminService.createAdmin(admin);
        return "redirect:/registration?success";
    }
}
