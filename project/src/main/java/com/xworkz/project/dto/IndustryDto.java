package com.xworkz.project.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class IndustryDto {
	private int id;
	private String userName;
	private String email;
	private Long contactNo;
	private String GSTnumber;
	private String typeOfIndustry;
	private boolean isOnlineServiceAvaliable;
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
	private boolean approved;
	private int otp;

}
