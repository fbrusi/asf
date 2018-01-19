package br.com.asf.constant;

public enum FlowStatus {

	AGUARDANDO_CONTRATANTE("Aguardando Contratante"), 
	AGUARDANDO_AUTORIZACAO("Aguardando Autorização"), 
	AGUARDANDO_CONTRATADO("Aguardando Contratado"), 
	FINALIZADO("Finalizado"), 
	CANCELADO("Cancelado");
	
	private String flow;
	
	FlowStatus(String flow) {
		this.flow = flow;
	}
	
	public String getFlowDescription() {
		return flow;
	}
}
