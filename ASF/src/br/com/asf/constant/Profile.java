package br.com.asf.constant;

public enum Profile {

	CONTRATANTE("Contratante"),
	CONTRATADO("Contratado"),
	ANALISTA("Analista"),
	ADMINISTRADOR("Administrador");
	
	private String profile;
	
	Profile(String profile) {
		this.profile = profile;
	}
	
	public String getProfile() {
		return profile;
	}
}
