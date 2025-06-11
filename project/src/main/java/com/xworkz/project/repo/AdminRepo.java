package com.xworkz.project.repo;

import java.util.List;

import com.xworkz.project.entity.AdminSigninEntity;
import com.xworkz.project.entity.IndustryEntity;
import com.xworkz.project.entity.SignUpEntity;

public interface AdminRepo {
	public AdminSigninEntity signIn(String email, String password);
	public List<SignUpEntity> findactive();
	public List<SignUpEntity> findInactive();
	public List<IndustryEntity> findApproved();
	public List<IndustryEntity> findNotApproved();



}
