package br.com.asf.view;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.asf.model.Client;
import br.com.asf.service.ws.post.office.AtendeCliente;
import br.com.asf.service.ws.post.office.AtendeClienteService;
import br.com.asf.service.ws.post.office.EnderecoERP;
import br.com.asf.service.ws.post.office.SQLException_Exception;
import br.com.asf.service.ws.post.office.SigepClienteException;

@Named
@ConversationScoped
public class SignUpBean extends BasicFaces implements Serializable {

	private static final long serialVersionUID = 1L;

	private Client client = new Client();
	
	@Inject
	private Conversation conversation;
	
	private String passwordConfirm;
	
	public void verifyPostalCode() {
		
		AtendeCliente correios = new AtendeClienteService().getAtendeClientePort();
		
		try {
			
			EnderecoERP endereco = correios.consultaCEP(client.getAddress().getPostalCode());
			
			client.getAddress().setCity(endereco.getCidade());
			client.getAddress().setNeighborhood(endereco.getBairro());
			client.getAddress().setState(endereco.getUf());
			client.getAddress().setStreet(endereco.getEnd());
		} 
		catch (SQLException_Exception | SigepClienteException e) {
			
			//TODO
		}
	}
	
	public String goToStep2() {
		
		if(conversation.isTransient()) {
			conversation.begin();
		}
		
		return "signup2?faces-redirect=true";
	}
	
	public String signUpClient() {
		
		conversation.end();
		return null;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
}
