package br.com.asf.controller.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.asf.constant.FlowStatus;
import br.com.asf.model.Document;

@Stateless
public class DocumentDao {

	@Inject
	private EntityManager entityManager;
	
	@Inject
	private CompanyDao companyManager;

	public void saveDocument(Document document) {
		
		entityManager.joinTransaction();
		
		entityManager.persist(document.getDocumentFile());
		
		document.setContracted(companyManager.getCompanyById(document.getContracted().getId()));
		document.setContractor(companyManager.getCompanyById(document.getContractor().getId()));
		
		entityManager.persist(document);
	}
	
	public Long getDocumentsQuantityByStatus(FlowStatus status) {
		
		String jpql = "SELECT COUNT(d) FROM Document d WHERE d.flowStatus = :flowStatus";
		
		TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
		query.setParameter("flowStatus", status);
		
		return query.getSingleResult();
	}
}
