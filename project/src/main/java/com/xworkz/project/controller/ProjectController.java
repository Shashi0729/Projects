package com.xworkz.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.project.dto.SignInDto;
import com.xworkz.project.dto.SignUpDto;
import com.xworkz.project.entity.SignUpEntity;
import com.xworkz.project.repo.ProjectRepo;
import com.xworkz.project.service.ProjectService;

@Component
@RequestMapping("/")
public class ProjectController {

	@Autowired
	ProjectService service;
	@Autowired
	ProjectRepo repo;

	@PostMapping("/SignupSubmit")
	public String save(@ModelAttribute SignUpDto dto, Model model) {
		model.addAttribute("save", dto);
		service.onSave(dto);
		return "signin";

	}

	@PostMapping("/SigninSubmit")
	public String signIn(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		SignUpEntity UEntity = repo.getemail(email);
		SignUpEntity Uid = repo.getid(UEntity.getId());
		boolean result = service.signIn(email, password);
		if (!result) {
			if (Uid.getAttempts() >= 3) {
				model.addAttribute("checkblock", "Your Account has been blocked. reset password");
				return "signin";
			} else {
				model.addAttribute("checkemailandpassword", "Check your Email and Password");
				return "signin";
			}
		}
		return "home";

	}

	@GetMapping("/update")
	public String update(@RequestParam String email, Model model) {
		SignUpDto dto = service.findByEmail(email);
		model.addAttribute("dto", dto);
		return "edit";

	}

	@PostMapping("/update")
	public String updateDetails(@ModelAttribute SignUpDto dto, Model model) {
		System.out.println(dto);
		if (service.updateByEmail(dto)) {
			model.addAttribute("update", service.updateByEmail(dto));

			return "home";

		}
		return "edit";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam String email, Model model) {
		SignUpDto dto = service.findByEmail(email);
		service.deleteByEmail(dto);
		model.addAttribute("dto", dto);
		return "signin";
	}

	@GetMapping("/history")
	public String history(@RequestParam String email, Model model) {
		SignUpDto dto = service.findByEmail(email);
		List<SignInDto> list = service.history(dto.getId());
		model.addAttribute("list", list);
		return "history";
	}
	
	@PostMapping("/OTPverification")
	public String otpVerification(@RequestParam("email") String email, @RequestParam("otp") int otp, Model model) {
		boolean result = service.validateOTP(otp, email);
		if(result) {
			model.addAttribute("email", email);		
			return "resetpassword";
		}
		
		return "resetpasswordOTPsending";

	}
	
	@PostMapping("/ResetPassword")
	public String resetPassword(@RequestParam("email") String email, @RequestParam("password") String password) {
		boolean result = service.resetPassword(password, email);
		if(result) {
				
			return "signin";
		}
		
		return "resetpassword";

	}
	
	

}
