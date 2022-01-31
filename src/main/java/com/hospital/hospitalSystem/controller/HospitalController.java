package com.hospital.hospitalSystem.controller;

import com.hospital.hospitalSystem.domain.Patient;
import com.hospital.hospitalSystem.domain.PatientDiagnosisData;
import com.hospital.hospitalSystem.domain.Physician;
import com.hospital.hospitalSystem.dto.DiagnosisData;
import com.hospital.hospitalSystem.dto.PatientHistory;
import com.hospital.hospitalSystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.hospital.hospitalSystem.domain.Admin;

import java.util.List;

/**
 * contains controller endpoint methods of Hospital application
 * @author Manoj
 *
 */
@Controller
public class HospitalController {
	
	@Autowired
	private AdminServiceImpl adminService;
	@Autowired
    private PatientDiagnosisDataService patientDiagnosisDataService;
	@Autowired
    private PatientService patientService;
	@Autowired
    private PhysicianService physicianService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

	/*@RequestMapping(value = "/", method = RequestMethod.GET)
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
    }*/


    /**
    *
    * patient operations
    *
    * */
    @GetMapping(value = "/enrollPatient")
    public String enrollPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "enrollPatient";
    }

    /*
    * save new patient details
    * */
    @RequestMapping(value = "/enrollPatient", method = RequestMethod.POST)
    public String createPatient(@ModelAttribute("patient") Patient patient) {
        patientService.createPatient(patient);
        return "redirect:/enrollPatient?success";
    }

    @RequestMapping(value = "/editPatient/{id}", method = RequestMethod.PUT)
    public ModelAndView showEditPatientPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("newAdmin");
        Admin std = adminService.getAdminById(id);
        mav.addObject("student", std);
        return mav;

    }

    /**
     *
     * physician operations
     *
     * */
    @RequestMapping(value = "/addPhysician", method = RequestMethod.GET)
    public String addPhysician(Model model) {
        model.addAttribute("physician", new Physician());
        return "addPhysician";
    }

    /*
     * save new patient details
     * */
    @RequestMapping(value = "/addPhysician", method = RequestMethod.POST)
    public String addPhysician(@ModelAttribute("physician") Physician physician) {
        physicianService.createPhysician(physician);
        return "redirect:/addPhysician?success";
    }

    /**
     *
     * patient diagnostic details operations
     *
     * */
    @RequestMapping(value = "/addDiagnosisData", method = RequestMethod.GET)
    public String addDiagnosisData(Model model) {
        model.addAttribute("diagnosisData", new DiagnosisData());
        return "addDiagnosisData";
    }

    /*
     * save new patient details
     * */
    @RequestMapping(value = "/addDiagnosisData", method = RequestMethod.POST)
    public String addDiagnosticData(@ModelAttribute("diagnosisData") DiagnosisData diagnosisData) {
        patientDiagnosisDataService.createDiagnosisData(diagnosisData);
        return "redirect:/";
    }

    /**
     * return view for search physicians
     * */
    @GetMapping("/searchPhysicians")
    public String searchPhysicians(Model model) {
        model.addAttribute("physician", new Physician());
        return "searchPhysicians";
    }

    /**
     * search physician operation
     * */
    @PostMapping("/searchPhysicians")
    public String searchPhysicians(@ModelAttribute("physician") Physician physician, Model model) {
        List<Physician> physicianList = physicianService.searchPhysicians(physician);
        model.addAttribute("physicianList", physicianList);
        return "searchPhysicians";
    }

    /**
     * return view for search patient history
     * */
    @GetMapping("/viewPatientHistory")
    public String viewPatientHistory(Model model) {
        model.addAttribute("patient", new Patient());
        return "viewPatientHistory";
    }

    /**
     * get patient history method
     * */
    @PostMapping("/viewPatientHistory")
    public String viewPatientHistory(@ModelAttribute("patient") Patient patient, Model model) {
        List<PatientHistory> patientHistoryList = patientDiagnosisDataService.searchPatientHistories(patient);
        model.addAttribute("patientHistories", patientHistoryList);
        return "viewPatientHistory";
    }
}
