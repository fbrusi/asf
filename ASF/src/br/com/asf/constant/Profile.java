package br.com.asf.constant;

public enum Profile {

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
