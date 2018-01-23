package br.com.asf.controller.repository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.asf.model.Client;

@Stateless
public class ClientManager {

	@Inject
	private EntityManager entityManager;
	
	@Inject
	private CompanyManager companyManager;

	public void saveClient(Client client) {

		entityManager.joinTransaction();
		
		client.setCompany(companyManager.getCompanyById(client.getCompany().getId()));
		entityManager.persist(client);
	}
}
