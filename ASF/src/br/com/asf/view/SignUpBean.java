package br.com.asf.view;

import javax.enterprise.inject.Model;

import br.com.asf.model.Client;

@Model
public class SignUpBean extends BasicFaces {

	private Client client = new Client();
	
	public String signUpClient() {
		
		return null;
	}
}
