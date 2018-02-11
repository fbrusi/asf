package br.com.asf.controller.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.asf.model.Client;

@Stateless
public class ClientDao {

	@Inject
	private EntityManager entityManager;
	
	@Inject
	private CompanyDao companyManager;

	public void saveClient(Client client) {

		entityManager.joinTransaction();
		
		if(client.getCompany() != null) {
			client.setCompany(companyManager.getCompanyById(client.getCompany().getId()));
		}
		entityManager.persist(client);
	}
	
	public long countClients() {
		return (Long)entityManager.createQuery("SELECT COUNT(c) FROM Client c").getSingleResult();
	}
	
	public boolean isCredentialsOk(Client client) {
		
		String jpql = "SELECT COUNT(c) FROM Client c WHERE c.email = :email AND c.password = :password";
		
		TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
		query.setParameter("email", client.getEmail());
		query.setParameter("password", DigestUtils.sha256Hex(client.getPassword()));
		
		return query.getSingleResult() > 0;
	}
}
