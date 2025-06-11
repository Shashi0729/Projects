package com.xworkz.project.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity

@NamedQuery(name = "findByEmailAndPassword", query = "SELECT u FROM SignUpEntity u WHERE u.email = :email AND u.password = :password AND u.isActive=true")
@NamedQuery(name = "findByEmail", query = "SELECT u FROM SignUpEntity u WHERE u.email = :email AND u.isActive=true")
@NamedQuery(name = "findByid", query = "SELECT u FROM SignUpEntity u WHERE u.id = :id AND u.isActive=true")
@NamedQuery(name = "findByEmailInActive", query = "SELECT u FROM SignUpEntity u WHERE u.email = :email AND u.isActive=false")
@NamedQuery(name = "findByAdhar", query = "SELECT u FROM SignUpEntity u WHERE u.adharNumber = :adharNumber  AND u.isActive=true")
@NamedQuery(name = "findByContact", query = "SELECT u FROM SignUpEntity u WHERE u.contactNo = :contactNo  AND u.isActive=true")
@NamedQuery(name = "findActive", query = "SELECT u FROM SignUpEntity u WHERE u.isActive=true")
@NamedQuery(name = "findInActive", query = "SELECT u FROM SignUpEntity u WHERE u.isActive=false")

@Table(name = "UserDetails")
public class SignUpEntity {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
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
