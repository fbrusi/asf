package br.com.asf.db.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDao<T> {
	
	private EntityManager entityManager;
	
	public GenericDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(T model) {
		entityManager.persist(model);
	}

	public T searchById(Class<T> modelClass, Integer id) {
		return entityManager.find(modelClass, id);
	}

	public void remove(T model) {
		entityManager.remove(model);
	}

	public List<T> getAll(Class<T> modelClass) {
		return entityManager.createQuery("SELECT c FROM " + modelClass.getSimpleName() + " c", modelClass).getResultList();
	}
}
