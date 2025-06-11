package com.xworkz.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.project.dto.IndustryDto;
import com.xworkz.project.dto.SignUpDto;
import com.xworkz.project.entity.IndustryEntity;
import com.xworkz.project.entity.SignUpEntity;

import com.xworkz.project.repo.AdminRepo;
import com.xworkz.project.util.ProjectUtil;

@Component
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminRepo repo;

	@Override
	public boolean adminSignIn(String email, String password) {
		if (email != null && password != null) {
			if (repo.signIn(email, password) != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<SignUpDto> findActive() {
		List<SignUpEntity> list = repo.findactive();
		return list.stream().map(ProjectUtil::convertEntityToDto).collect(Collectors.toList());
	}
	
	@Override
	public List<SignUpDto> findInActive() {
		List<SignUpEntity> list = repo.findInactive();
		return list.stream().map(ProjectUtil::convertEntityToDto).collect(Collectors.toList());		
	}
	
	@Override
	public List<IndustryDto> findApproved() {
		List<IndustryEntity> list = repo.findApproved();
		return list.stream().map(ProjectUtil::convertEntityToDto).collect(Collectors.toList());
	}

	@Override
	public List<IndustryDto> findNotApproved() {
		List<IndustryEntity> list = repo.findNotApproved();
		return list.stream().map(ProjectUtil::convertEntityToDto).collect(Collectors.toList());
	}

	

}
