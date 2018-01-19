package br.com.asf.constant;

public enum EventType {

	VERIFICADO_CONTRATANTE("Verificado pelo contratante"), 
	ENVIADO_AUTORIZACAO_MANUAL("Enviado para autorização manual"), 
	AUTORIZADO_MANUALMENTE("Autorizado manualmente"), 
	AUTORIZADO_AUTOMATICAMENTE("Autorizado automaticamente"), 
	REJEITADO("Rejeitado"), 
	VERIFICADO_CONTRATADO("Verificado pelo contratado"), 
	CANCELADO("Cancelado.");
	
	private String event;
	
	EventType(String event) {
		this.event = event;
	}
	
	public String getEventDescription() {
		return event;
	}
}
