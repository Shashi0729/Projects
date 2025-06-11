package com.xworkz.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;

@Data
@Entity
@NamedQuery(name="findAdminByEmailAndPassword",query = "SELECT u FROM AdminSigninEntity u WHERE u.email = :email AND u.password = :password")
public class AdminSigninEntity {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String adminName;
	private String email;
	private String password;

}
