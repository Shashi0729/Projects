package com.xworkz.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.project.service.ProjectService;

@RestController
public class SignUpResource {

	@Autowired
	ProjectService service;

	@GetMapping("/GetEmail")
	public String getEmail(@RequestParam String email) {
		if (email != null) {
			System.out.println("email is not null" + email);
			if (service.getemail(email)) {
				return "Email Found";
			}
		}
		return null;
	}
	
	@GetMapping("/GetAdhar")
	public String getAdhar(@RequestParam Long adharNumber) {
		if (adharNumber != null) {
			System.out.println("Adhar is not null" + adharNumber);
			if (service.getadhar(adharNumber)) {
				return "Adhar Found";
			}
		}
		return null ;
	}
	
	@GetMapping("/GetContact")
	public String getContact(@RequestParam Long contactNumber) {
		if (contactNumber != null) {
			System.out.println("Adhar is not null" + contactNumber);
			if (service.getcontact(contactNumber)) {
				return "Contact Found";
			}
		}
		return null ;
	}
	
	

}
