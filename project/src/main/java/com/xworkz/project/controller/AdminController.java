package com.xworkz.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.project.dto.IndustryDto;
import com.xworkz.project.dto.SignUpDto;
import com.xworkz.project.service.AdminService;
import com.xworkz.project.service.IndustryService;
import com.xworkz.project.service.ProjectService;

@Component
@RequestMapping("/")
public class AdminController {
	@Autowired
	AdminService Aservice;
	@Autowired
	ProjectService service;
	@Autowired
	IndustryService Iservice;
	
	@PostMapping("/AdminSigninSubmit")
	public String signIn(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		if (Aservice.adminSignIn(email, password)) {
			return "adminhome";
		} else {
			return "adminsignin";
		}

	}
	
	@GetMapping("/Activeusers")
	public String viewActive(Model model) {
		model.addAttribute("viewActive", Aservice.findActive());
		return "adminhome";
		
	}
	
	@GetMapping("/InActiveusers")
	public String viewInActive(Model model) {
		model.addAttribute("viewInActive", Aservice.findInActive());
		return "adminhome";
		
	}
	
	@GetMapping("/ApprovedIndustry")
	public String viewApproved(Model model) {
		model.addAttribute("viewApproved", Aservice.findApproved());
		return "adminhome";
		
	}
	
	@GetMapping("/NotApprovedIndustry")
	public String viewNotApproved(Model model) {
		model.addAttribute("viewNotApproved", Aservice.findNotApproved());
		return "adminhome";
		
	}
	
	@GetMapping("/admintosignin")
	public String getadmintosignin() {
		return "adminsignin";
	}
	
	@GetMapping("/signin")
	public String getsignin() {
		return "signin";
	}
	
	@GetMapping("/signup")
	public String getsignup() {
		return "signup";
	}
	
	@GetMapping("/Adminupdate")
	public String update(@RequestParam String email, Model model) {
		if(email!=null) {
			System.out.println(email);
			SignUpDto dto = service.findByEmail(email);
			model.addAttribute("dto", dto);
			return "adminedit";
		}
		return "adminhome";
	}
	
	@GetMapping("/Adminupdateinactive")
	public String updateInactive(@RequestParam String email, Model model) {
		if(email!=null) {
			System.out.println(email);
			SignUpDto dto = service.findByEmailInActive(email);
			model.addAttribute("dto", dto);
			return "adminedit";
		}  
		return "adminhome";
	}
	
	
	@PostMapping("/Adminupdate")
	public String updateDetails(@ModelAttribute SignUpDto dto,Model model ) {
		System.out.println(dto);
	if(service.updateByEmail(dto)) {
		model.addAttribute("update", service.updateByEmail(dto));
		
		return "adminhome";
		
	}
		return "edit";
		
	}
	
	@GetMapping("/AdminIndustryupdate")
	public String Industryupdate(@RequestParam String email, Model model) {
		if(email!=null) {
			System.out.println(email);
			IndustryDto dto = Iservice.findByEmail(email);
			model.addAttribute("dto", dto);
			return "adminIndustryUpdate";
		}
		return "adminhome";
	}
	
	@PostMapping("/adminindustryupdate")
	public String IndustryupdateDetails(@ModelAttribute IndustryDto dto,Model model ) {
		System.out.println(dto);
	if(Iservice.updateByEmail(dto)) {
		model.addAttribute("update", Iservice.updateByEmail(dto));
		
		return "adminhome";
		
	}
		return "adminIndustryUpdate";
		
	}
	
	@GetMapping("/Adminindustryupdateinactive")
	public String IndustryupdateInactive(@RequestParam String email, Model model) {
		if(email!=null) {
			System.out.println(email);
			IndustryDto dto = Iservice.findByEmailInActive(email);
			model.addAttribute("dto", dto);
			return "adminIndustryUpdate";
		}  
		return "adminhome";
	}
	
	@GetMapping("/AdminIndustrydelete")
	public String Industrydelete(@RequestParam String email, Model model) {
		if(email!=null) {
			IndustryDto dto = Iservice.findByEmail(email);
			System.out.println(dto);
			Iservice.deleteByEmail(dto);
			model.addAttribute("dto", dto);
		}
		return "adminhome";
	}
	
	@GetMapping("/Admindelete")
	public String delete(@RequestParam String email, Model model) {
		SignUpDto dto = service.findByEmail(email);
		service.deleteByEmail(dto);
		model.addAttribute("dto", dto);
		return "adminhome";
	}

}
