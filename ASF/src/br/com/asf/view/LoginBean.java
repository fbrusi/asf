package br.com.asf.view;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.com.asf.controller.dao.ClientDao;
import br.com.asf.model.Client;

@Model
public class LoginBean extends BasicFaces {

	private Client client = new Client();
	
	@Inject
	private ClientDao clientDao;
	
	public String authenticate() {
	
		if(clientDao.isCredentialsOk(client)) {
			return "home?faces-redirect=true";
		}
		else {
			
			generateMessage(FacesMessage.SEVERITY_ERROR, "Dados incorretos, por favor verifique.");
			return "login";
		}
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
