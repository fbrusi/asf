package br.com.asf.controller.repository;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.asf.model.Company;

@Stateless
public class CompanyManager {

	@Inject
	private EntityManager entityManager;

	public void saveCompany(Company company) {

		entityManager.joinTransaction();
		entityManager.persist(company);
	}

	public Company getCompanyById(BigInteger id) {
		return entityManager.find(Company.class, id);
	}

	public void updateCompanyInfo(Company company) {

		entityManager.joinTransaction();
		entityManager.merge(company);
	}

	public List<Company> getAllCompanies() {

		TypedQuery<Company> query =  entityManager.createQuery("SELECT c FROM Company c", Company.class);
		query.setHint("org.hibernate.cacheable", "true");

		return query.getResultList();
	}
	
	public void removeCompany(Company company) {
		
		entityManager.joinTransaction();
		company = getCompanyById(company.getId());
		entityManager.remove(company);
	}
}
