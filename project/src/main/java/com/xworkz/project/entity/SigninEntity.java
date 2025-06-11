package com.xworkz.project.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;
@Data
@Entity
@NamedQuery(name="history", query = "select e from SigninEntity e where e.userId=:id")
public class SigninEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int userId;
	private LocalDateTime logInTime;


}
