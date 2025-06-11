package com.xworkz.project.repo;

import java.util.List;

import com.xworkz.project.entity.SigninEntity;
import com.xworkz.project.entity.SignUpEntity;

public interface ProjectRepo {

	String onSave(SignUpEntity entity);

	boolean signInSave(SigninEntity entity);

	public SignUpEntity signIn(String email, String password);

	public SignUpEntity getemail(String email);
	
	public SignUpEntity getid(int id);
	
	public SignUpEntity getemailInActive(String email);

	public boolean getadhar(Long email);

	public boolean getcontact(Long contactNo);

	public SignUpEntity update(SignUpEntity entity);

	List<SigninEntity> history(int id);

}
