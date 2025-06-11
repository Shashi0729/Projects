package com.xworkz.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private  int itemNo;
	private String itemName;
	private int price;
	private String discription;
	private String imageName;
	
	@ManyToOne
	@JoinColumn(name="companyId",nullable = false)
	private IndustryEntity companyDetails;

	

}
