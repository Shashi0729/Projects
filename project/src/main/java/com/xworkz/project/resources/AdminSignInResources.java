package com.xworkz.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.project.service.ProjectService;

@RestController
public class AdminSignInResources {
	@Autowired
	ProjectService service;
	
	@GetMapping("/SignInGetAdminEmail") 
	public String getEmail(@RequestParam String email) {
		if (email != null) {
			System.out.println("email is not null" + email);
			if (service.getemail(email)) {
				return "Email Found! You Can LogIn";
			}
		}
		return "Email Not Found.....!";
	}

}
