package br.com.asf.model.listener;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.PrePersist;

import br.com.asf.constant.FlowStatus;
import br.com.asf.model.Client;
import br.com.asf.model.Company;
import br.com.asf.model.Document;

public class DocumentListener {
	
	@PrePersist
	public void executePrePersist(Document document) {

		System.out.println("chegou");
		fillInitialData(document);
		//notifyClientsNewDocument(document);
	}

	private void fillInitialData(Document document) {
		
		document.setCreateDate(LocalDateTime.now());
		document.setFlowStatus(FlowStatus.AGUARDANDO_CONTRATANTE);
	}
	
	private void notifyClientsNewDocument(Document document) {

		List<Company> companies = document.getCompanies();
		for(Company company : companies) {
			
			List<Client> clients = company.getClients();
			//TODO Implementar noficação por e-mail
		}
	}
}
