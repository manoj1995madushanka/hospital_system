package com.hospital.hospitalSystem.controller;

import java.util.List;

import com.hospital.hospitalSystem.domain.Patient;
import com.hospital.hospitalSystem.service.PatientDiagnosisDataService;
import com.hospital.hospitalSystem.service.PatientService;
import com.hospital.hospitalSystem.service.PhysicianService;
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
	@Autowired
    private PatientDiagnosisDataService patientDiagnosisDataService;
	@Autowired
    private PatientService patientService;
	@Autowired
    private PhysicianService physicianService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewHomePage(Model model) {
        List<Admin> adminList = adminService.getAllAdmins();
        model.addAttribute("adminList", adminList);
        return "index";
    }
 
	
    @RequestMapping(value = "/newAdmin", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("admin", new Admin());
        return "createAdmin";
    }
 
    @RequestMapping(value = "/createAdmin", method = RequestMethod.POST)
    public String createAdmin(@ModelAttribute("admin") Admin admin) {
    	adminService.createAdmin(admin);
        return "redirect:/";
    }
 
    @RequestMapping(value = "/edit/{id}")
    public ModelAndView showEditAdminPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("createAdmin");
        Admin admin = adminService.getAdminById(id);
        mav.addObject("admin", admin);
        return mav;
        
    }
    
    @RequestMapping(value = "/delete/{id}")
    public String deleteAdminById(@PathVariable(name = "id") int id) {
    	adminService.deleteAdminById(id);
        return "redirect:/";
    }


    /**
    *
    * patient operations
    *
    * */

    /*
    * save new patient details
    * */
    @RequestMapping(value = "/createPatient", method = RequestMethod.POST)
    public String createPatient(@ModelAttribute("patient") Patient patient) {
        patientService.createPatient(patient);
        return "redirect:/";
    }

    @RequestMapping(value = "/editPatient/{id}", method = RequestMethod.PUT)
    public ModelAndView showEditPatientPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("newAdmin");
        Admin std = adminService.getAdminById(id);
        mav.addObject("student", std);
        return mav;

    }
}
