package com.xworkz.project.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.project.entity.IndustryEntity;
import com.xworkz.project.entity.ItemsEntity;
import com.xworkz.project.entity.SignUpEntity;

@Component
public class IndustryRepoImpl implements IndustryRepo {
	@Autowired
	EntityManagerFactory factory;

	@Override
	public String onSave(IndustryEntity entity) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
		return "Saved";
	}

	@Override
	public IndustryEntity getemail(String email) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<IndustryEntity> entity = manager.createNamedQuery("IndustryfindByEmail", IndustryEntity.class);
		entity.setParameter("email", email);
		
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
	public IndustryEntity getid(int id) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<IndustryEntity> entity = manager.createNamedQuery("IndustryfindByid", IndustryEntity.class);
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
	

	@Override
	public IndustryEntity getemailInActive(String email) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<IndustryEntity> entity = manager.createNamedQuery("IndustryfindByEmailInActive", IndustryEntity.class);
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
	public boolean getgst(Long gst) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<IndustryEntity> entity = manager.createNamedQuery("IndustryfindByGST", IndustryEntity.class);
		entity.setParameter("Gst", gst);
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
		TypedQuery<IndustryEntity> entity = manager.createNamedQuery("IndustryfindByContact", IndustryEntity.class);
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
	public IndustryEntity update(IndustryEntity entity) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(entity);
		manager.getTransaction().commit();
		manager.close();
		return entity;
	}

	@Override
	public String itemSave(ItemsEntity entity) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
		return "Saved";
		
	}

	@Override
	public ItemsEntity itemUpdate(ItemsEntity entity) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(entity);
		manager.getTransaction().commit();
		manager.close();
		return entity;
	}

}
