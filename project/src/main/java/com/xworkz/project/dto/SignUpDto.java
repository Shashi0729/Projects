package com.xworkz.project.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SignUpDto {

	private int id;
	private String userName;
	private String email;
	private String password;
	private Long contactNo;
	private Long adharNumber;
	private Long alternativeContactNo;
	private String dateOfBirth;
	private String country;
	private String state;
	private String city;
	private int pincode;
	private String address;
	private String createdBy;
	private LocalDateTime createdOn;
	private String updatedBy;
	private LocalDateTime updatedOn;
	private boolean isActive;
	private int attempts;
	private int OTP;

}