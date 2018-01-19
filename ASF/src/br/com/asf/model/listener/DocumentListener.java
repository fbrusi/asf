package br.com.asf.model.listener;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;

import br.com.asf.constant.FlowStatus;
import br.com.asf.model.Document;

public class DocumentListener {

	@PrePersist
	public void fillInitialData(Document document) {
		
		document.setCreateDate(LocalDateTime.now());
		document.setFlowStatus(FlowStatus.AGUARDANDO_CONTRATANTE);
	}
}
