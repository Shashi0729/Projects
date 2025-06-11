package com.xworkz.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.project.service.ProjectService;
@RestController
public class SignInRecources {
	@Autowired
	ProjectService service;
	
	@GetMapping("/SignInGetEmail") 
	public String getEmail(@RequestParam String email) {
		if (email != null) {
			System.out.println("email is not null" + email);
			if (service.getemail(email)) {
				return "Email Found!";
			}
		}
		return "Email Not Found.Do SignUp";
	}
	
	@GetMapping("/sendOTP")
	public String getOTP(@RequestParam String email) {
		if (email != null) {
			System.out.println("email is not null" + email);
			service.sendOTP(email);
				return "OTP Sent Successfully";     
			}
		
		return null;
		
	}
}

