package com.xworkz.project.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.project.dto.IndustryDto;
import com.xworkz.project.dto.ItemsDto;
import com.xworkz.project.repo.IndustryRepo;
import com.xworkz.project.service.IndustryService;




@Controller
@Component
@RequestMapping("/")
public class IndustryController {

	@Autowired
	IndustryService service;
	@Autowired
	IndustryRepo repo;

	@PostMapping("/IndustrySignup")
	public String save(@ModelAttribute IndustryDto dto, Model model) {
		model.addAttribute("save", dto);
		service.onSave(dto);
		return "IndustrySignin";

	}

	@GetMapping("/industryupdate")
	public String update(@RequestParam String email, Model model) {
		IndustryDto dto = service.findByEmail(email);
		System.out.println(dto);
		model.addAttribute("dto", dto);
		return "industryUpdate";

	}

	@PostMapping("/industryupdate")
	public String updateDetails(@ModelAttribute IndustryDto dto, Model model) {
		System.out.println(dto);
		if (service.updateByEmail(dto)) {
			model.addAttribute("update", service.updateByEmail(dto));
			return "industryHome";

		}
		return "industryUpdate";

	}

	@GetMapping("/industrydelete")
	public String delete(@RequestParam String email) {
		IndustryDto dto = service.findByEmail(email);
		if (service.deleteByEmail(dto)) {
			return "IndustrySignin";
		}
		return "industryHome";

	}

	@PostMapping("/IndustrysOTPverification")
	public String otpVerification(@RequestParam("email") String email, @RequestParam("otp") int otp, Model model) {
		
		boolean result = service.validateOTP(otp, email);
		if (result) {
			model.addAttribute("email", email);
			return "industryHome";
		}

		return "IndustrySignin";

	}

	@GetMapping("/IndustryRegister")
	public String register() {
		return "IndustryRegister";
	}

	@GetMapping("/IndustrySignin")
	public String signIn() {
		return "IndustrySignin";
	}

	@GetMapping("/Approve")
	public String getApproved(@RequestParam("email") String email) {
		service.getApproved(email);
		return "adminhome";

	}

	@GetMapping("/Reject")
	public String getRejected(@RequestParam("email") String email) {
		service.getRejected(email);
		return "adminhome";

	}

	@PostMapping("/uploadItemDetails")
	public String itemImageUpload(@ModelAttribute ItemsDto dto, @RequestParam("itemImage") MultipartFile partFile,
			@RequestParam("email") String email) throws IOException {
		if (service.itemSave(dto, partFile, email)) {
			return "industryHome";
		}

		return "addItem";

	}

//	@GetMapping("/download")
//	public void downloadFile(HttpServletResponse response, @RequestParam String fileName) throws FileNotFoundException {
//		System.out.println("download method in controller");
//		response.setContentType("image/jpeg");
//		File file = new File("C:\\Users\\Dell\\Desktop\\imageupload\\" + fileName);
//		try {
//			BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(file));
//			ServletOutputStream out = response.getOutputStream();
//			IOUtils.copy(buffer, out);
//			response.flushBuffer();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
	
	@GetMapping("/addItems")
	public String addItems(@RequestParam("email") String email,Model model) {
		model.addAttribute("companyEmail",email);
		return "addItem";
		
	}

}
