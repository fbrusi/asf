package br.com.asf.db.model.listener;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

import br.com.asf.db.model.Contract;

public class FlowListener {

	@PostPersist
	@PostUpdate
	public void logEvent(Contract contract) {
		
		//TODO Implementar...
	}
}
