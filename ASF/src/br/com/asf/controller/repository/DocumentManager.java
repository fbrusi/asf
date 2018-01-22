package br.com.asf.controller.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.asf.model.Document;

@Stateless
public class DocumentManager {

	@PersistenceContext
	private EntityManager entityManager;

	public void saveDocument(Document document) {
		
		entityManager.persist(document.getDocumentFile());
		entityManager.persist(document);
	}
}
