package com.xworkz.project.service;

import java.util.List;

import com.xworkz.project.dto.IndustryDto;
import com.xworkz.project.dto.SignUpDto;

public interface AdminService {
	boolean adminSignIn(String email,String password);
	List<SignUpDto> findActive();
	List<SignUpDto> findInActive();
	List<IndustryDto> findApproved();
	List<IndustryDto> findNotApproved();



}
