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
	
	@Inject
	private LoggedUserBean loggedUserBean;
	
	public String authenticate() {
	
		if(clientDao.isClientExistsByCredentials(this.client)) {
			
			Client client = clientDao.getClientByCredentials(this.client);
			loggedUserBean.logon(client);
			return "home?faces-redirect=true";
		}
		else {
			
			generateMessage(FacesMessage.SEVERITY_ERROR, "Dados incorretos, por favor verifique.");
			return "login";
		}
	}
	
	public String logout() {
		
		loggedUserBean.logout();
		return "login?faces-redirect=true";
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
