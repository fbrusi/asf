package br.com.asf.constant;

public enum CurrencyType {

	USD("$"), 
	CAD("C$"), 
	EUR("€");

	private String currency;

	CurrencyType(String currency) {
		this.currency = currency;
	}

	public String getCurrencyDescription() {
		return currency;
	}
}
