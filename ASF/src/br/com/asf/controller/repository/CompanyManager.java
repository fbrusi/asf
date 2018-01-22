package br.com.asf.controller.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.asf.model.Company;

@Stateless
public class CompanyManager {

	@Inject
	private EntityManager entityManager;
	
	public void saveCompany(Company company) {
		
		entityManager.joinTransaction();
		entityManager.persist(company);
	}
	
	public List<Company> getAllCompanies() {
		return entityManager.createQuery("SELECT c FROM Company c", Company.class).getResultList();
	}
	
	public void updateCompanyInfo(Company company) {
		
		entityManager.joinTransaction();
		entityManager.merge(company);
	}
}
