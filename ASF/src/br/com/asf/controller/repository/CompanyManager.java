package br.com.asf.controller.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.asf.model.Client;
import br.com.asf.model.Company;

@Stateless
public class CompanyManager {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void saveCompany(Company company, List<Client> clients) {
		
		entityManager.persist(company);
		
		for(Client client : clients) {
			
			client.setCompany(company);
			entityManager.persist(client);
		}
	}
}
