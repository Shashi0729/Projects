package com.xworkz.project.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.project.entity.AdminSigninEntity;
import com.xworkz.project.entity.IndustryEntity;
import com.xworkz.project.entity.SignUpEntity;

@Component
public class AdminRepoImpl implements AdminRepo {
	@Autowired
	EntityManagerFactory factory;

	@Override
	public AdminSigninEntity signIn(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<AdminSigninEntity> entity = manager.createNamedQuery("findAdminByEmailAndPassword", AdminSigninEntity.class);
		entity.setParameter("email", email);
		entity.setParameter("password", password);
		System.out.println(entity.toString());
		try {
			if (entity.getSingleResult() != null) {
				return entity.getSingleResult();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public List<SignUpEntity> findactive() {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		TypedQuery<SignUpEntity> query = manager.createNamedQuery("findActive", SignUpEntity.class);
		return query.getResultList();
		
	}

	@Override
	public List<SignUpEntity> findInactive() {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		TypedQuery<SignUpEntity> query = manager.createNamedQuery("findInActive", SignUpEntity.class);
		return query.getResultList();
	}

	@Override
	public List<IndustryEntity> findApproved() {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		TypedQuery<IndustryEntity> query = manager.createNamedQuery("IndustryFindApproved", IndustryEntity.class);
		return query.getResultList();
	}

	@Override
	public List<IndustryEntity> findNotApproved() {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		TypedQuery<IndustryEntity> query = manager.createNamedQuery("IndustryFindNotApproved", IndustryEntity.class);
		return query.getResultList();
	}

}
