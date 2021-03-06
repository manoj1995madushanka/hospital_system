package com.hospital.hospitalSystem.controller;

import com.hospital.hospitalSystem.domain.Patient;
import com.hospital.hospitalSystem.domain.Physician;
import com.hospital.hospitalSystem.dto.DiagnosisData;
import com.hospital.hospitalSystem.dto.PatientHistory;
import com.hospital.hospitalSystem.service.*;
import com.hospital.hospitalSystem.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.hospital.hospitalSystem.domain.Admin;

import java.util.List;

import static com.hospital.hospitalSystem.util.CommonStrings.SUCCESS;

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
    @GetMapping(value = "/addDiagnosisData")
    public String addDiagnosisData(Model model) {
        model.addAttribute("diagnosisData", new DiagnosisData());
        return "addDiagnosisData";
    }

    /*
     * save new patient details
     * */
    @PostMapping(value = "/addDiagnosisData")
    public String addDiagnosticData(@ModelAttribute("diagnosisData") DiagnosisData diagnosisData) {
        String response = patientDiagnosisDataService.createDiagnosisData(diagnosisData);
        if (response.equals(SUCCESS)) {
            return "redirect:/addDiagnosisData?success";
        }
        else
        {
            return "redirect:/addDiagnosisData?error";
        }
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
