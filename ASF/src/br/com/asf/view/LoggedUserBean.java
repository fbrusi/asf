package br.com.asf.view;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.asf.model.Client;

@Named
@SessionScoped
public class LoggedUserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Client client;
	
	public void logon(Client client) {
		this.client = client;
	}
	
	public void logout() {
		client = null;
	}
	
	public boolean isLoggedIn() {
		return client != null;
	}

	public Client getClient() {
		return client;
	}
}
