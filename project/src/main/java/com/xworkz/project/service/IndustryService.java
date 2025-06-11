package com.xworkz.project.service;

import org.springframework.web.multipart.MultipartFile;

import com.xworkz.project.dto.IndustryDto;
import com.xworkz.project.dto.ItemsDto;


public interface IndustryService {
	boolean onSave(IndustryDto dto);
	public boolean getemail(String email);
	public boolean getcontact(Long contactNo);
	public IndustryDto findByEmail(String email);
	public IndustryDto findByEmailInActive(String email);
	public boolean updateByEmail(IndustryDto dto);
	public boolean deleteByEmail(IndustryDto dto);
	public int generateOTP();
	public boolean sendOTP(String email);
	public boolean validateOTP(int OTP, String email);
	boolean getGST(String Gst);
	boolean getApproved(String email);
	boolean getRejected(String email);
	boolean itemSave(ItemsDto dto, MultipartFile partFile,String email);
}
