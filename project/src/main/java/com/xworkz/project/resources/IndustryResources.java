package com.xworkz.project.resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.project.entity.IndustryEntity;
import com.xworkz.project.repo.IndustryRepo;
import com.xworkz.project.service.IndustryService;

@RestController
public class IndustryResources {
	@Autowired
	IndustryService service;
	@Autowired
	IndustryRepo repo;
	@GetMapping("/IndustrySignInGetEmail") 
	public String getEmail(@RequestParam String email) {
		if (email != null) {
			System.out.println("email is not null" + email);
		IndustryEntity entity =	repo.getemail(email);
			if (service.getemail(email)) {
				if(!entity.isApproved()) {
					return "Email is not approved, Please wait.";
				}
				return "Email approved!";
			}
		}
		return "Email Not Found.Do SignUp";
	}
	
	@GetMapping("/IndustrysendOTP")
	public String getOTP(@RequestParam String email) {
		if (email != null) {
			System.out.println("email is not null" + email);
			service.sendOTP(email);
				return "OTP Sent Successfully";     
			}
		
		return null;
		
	}
	
}
