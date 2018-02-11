package br.com.asf.controller;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.asf.controller.dao.ClientDao;
import br.com.asf.model.Address;
import br.com.asf.model.Client;

@Startup
@Singleton
public class DatabaseInitializer {
	
	@Inject
	private ClientDao clientDao;

	@PostConstruct
	public void createDefaultAdminUser() {
		
		if(clientDao.countClients() == 0) {
			
			Client client = new Client();
			
			client.setName("Administrador do sistema");
			client.setCpf("263.121.251-73");
			client.setEmail("teste@teste.com");
			client.setPassword(DigestUtils.sha256Hex("admin123"));
			
			Address address = new Address();
			address.setCity("Curitiba");
			address.setNeighborhood("Bairro Feliz");
			address.setPostalCode("01728-000");
			address.setState("PR");
			address.setStreet("Rua dos Bobos, zero");
			
			client.setAddress(address);
			
			clientDao.saveClient(client);
		}
		
	}
}
