package com.xworkz.project.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.project.dto.SignUpDto;
import com.xworkz.project.entity.SigninEntity;
import com.xworkz.project.entity.SignUpEntity;

@Component
public class ProjectRepoImpl implements ProjectRepo {
	@Autowired
	EntityManagerFactory factory;

	SignUpDto dto = new SignUpDto();

	@Override
	public String onSave(SignUpEntity entity) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
		return "Saved";
	}

	@Override
	public SignUpEntity signIn(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<SignUpEntity> entity = manager.createNamedQuery("findByEmailAndPassword", SignUpEntity.class);
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
	public SignUpEntity getemail(String email) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<SignUpEntity> entity = manager.createNamedQuery("findByEmail", SignUpEntity.class);
		entity.setParameter("email", email);
		// System.out.println(entity.toString());
		try {
			if (entity.getSingleResult() != null) {
				return entity.getSingleResult();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("data is null in repo");
		return null;
	}

	@Override
	public boolean getadhar(Long adhar) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<SignUpEntity> entity = manager.createNamedQuery("findByAdhar", SignUpEntity.class);
		entity.setParameter("adharNumber", adhar);
		// System.out.println(entity.toString());
		try {
			if (entity.getSingleResult() != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public boolean getcontact(Long contactNo) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<SignUpEntity> entity = manager.createNamedQuery("findByContact", SignUpEntity.class);
		entity.setParameter("contactNo", contactNo);
		System.out.println(entity.toString());
		try {
			if (entity.getSingleResult() != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public boolean signInSave(SigninEntity entity) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
		return true;
	}

	@Override
	public SignUpEntity update(SignUpEntity entity) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(entity);
		manager.getTransaction().commit();
		manager.close();
		return entity;
	}

	@Override
	public List<SigninEntity> history(int id) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("history");
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	public SignUpEntity getemailInActive(String email) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<SignUpEntity> entity = manager.createNamedQuery("findByEmailInActive", SignUpEntity.class);
		entity.setParameter("email", email);
		// System.out.println(entity.toString());
		try {
			if (entity.getSingleResult() != null) {
				return entity.getSingleResult();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("data is null in repo");
		return null;
	}

	@Override
	public SignUpEntity getid(int id) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<SignUpEntity> entity = manager.createNamedQuery("findByid", SignUpEntity.class);
		entity.setParameter("id", id);
		// System.out.println(entity.toString());
		try {
			if (entity.getSingleResult() != null) {
				return entity.getSingleResult();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}
}
