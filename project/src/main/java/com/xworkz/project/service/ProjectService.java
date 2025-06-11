package com.xworkz.project.service;

import java.util.List;

import com.xworkz.project.dto.SignInDto;
import com.xworkz.project.dto.SignUpDto;

public interface ProjectService {
	boolean onSave(SignUpDto dto);
	boolean signIn(String email,String password);
	public boolean getemail(String email);
	public boolean getadhar(Long adhar);
	public boolean getcontact(Long contactNo);
	public List<SignInDto> history(int id);
	public SignUpDto findByEmail(String email);
	public SignUpDto findByEmailInActive(String email);
	public boolean updateByEmail(SignUpDto dto);
	public boolean deleteByEmail(SignUpDto dto);
	public int generateOTP();
	public boolean sendOTP(String email);
	public boolean validateOTP(int OTP, String email);
	public boolean resetPassword(String password, String email);







}
