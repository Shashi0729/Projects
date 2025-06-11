package com.xworkz.project.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
@NamedQuery(name = "IndustryfindByEmail", query = "SELECT u FROM IndustryEntity u WHERE u.email = :email AND u.isActive=true")
@NamedQuery(name = "IndustryfindByEmailInActive", query = "SELECT u FROM IndustryEntity u WHERE u.email = :email AND u.isActive=false")
@NamedQuery(name = "IndustryfindByid", query = "SELECT u FROM IndustryEntity u WHERE u.id = :id AND u.isActive=true")
@NamedQuery(name = "IndustryfindByGST", query = "SELECT u FROM IndustryEntity u WHERE u.GSTnumber = :Gst  AND u.isActive=true")
@NamedQuery(name = "IndustryfindByContact", query = "SELECT u FROM IndustryEntity u WHERE u.contactNo = :contactNo  AND u.isActive=true")
@NamedQuery(name = "IndustryfindActive", query = "SELECT u FROM IndustryEntity u WHERE u.isActive=true")
@NamedQuery(name = "IndustryfindInActive", query = "SELECT u FROM IndustryEntity u WHERE u.isActive=false")
@NamedQuery(name = "IndustryFindApproved", query = "SELECT u FROM IndustryEntity u WHERE u.approved=true")
@NamedQuery(name = "IndustryFindNotApproved", query = "SELECT u FROM IndustryEntity u WHERE u.approved=false")

public class IndustryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@OneToMany(mappedBy = "companyDetails")
	private List<ItemsEntity> itemDetails;
	private String createdBy;
	private LocalDateTime createdOn;
	private String updatedBy;
	private LocalDateTime updatedOn;
	private boolean isActive;
	private boolean approved;
	private int otp;

}
