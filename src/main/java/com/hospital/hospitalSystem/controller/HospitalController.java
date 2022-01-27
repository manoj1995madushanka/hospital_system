package com.hospital.hospitalSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hospital.hospitalSystem.domain.Admin;
import com.hospital.hospitalSystem.service.AdminService;

/**
 * contains controller endpoint methods of Hospital application
 * @author Manoj
 *
 */
@Controller
public class HospitalController {
	
	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewHomePage(Model model) {
        List<Admin> adminList = adminService.getAllAdmins();
        model.addAttribute("adminList", adminList);
        return "index";
    }
 
	
    @RequestMapping(value = "/newAdmin", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("admin", new Admin());
        return "newAdmin";
    }
 
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String createAdmin(@ModelAttribute("student") Admin std) {
    	adminService.createAdmin(std);
        return "redirect:/";
    }
 
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public ModelAndView showEditAdminPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("newAdmin");
        Admin std = adminService.getAdminById(id);
        mav.addObject("student", std);
        return mav;
        
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteAdminById(@PathVariable(name = "id") int id) {
    	adminService.deleteAdminById(id);
        return "redirect:/";
    }
}
