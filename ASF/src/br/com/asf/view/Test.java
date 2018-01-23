package br.com.asf.view;

import java.math.BigInteger;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.asf.controller.repository.CompanyManager;
import br.com.asf.model.Company;

@ManagedBean(name = "test")
public class Test {
	
	@Inject
	private CompanyManager companyManager;
	
	public void executeTest() {
		
		removeCompany();
	}
	
	private void createCompany() {
		
		Company company = new Company();
		
		company.setCnpj("52780827000169");
		company.setName("Marcondes e Marcados");
		
		companyManager.saveCompany(company);
	}
	
	private void updateCompany() {
		
		Company company = companyManager.getCompanyById(BigInteger.valueOf(1));
		company.setName("Bau da Felicidade");
		company.setCnpj("54872633000119");
		
		companyManager.updateCompanyInfo(company);
	}
	
	private void removeCompany() {
		
		Company company = new Company();
		company.setId(BigInteger.valueOf(1));
		
		companyManager.removeCompany(company);
	}
}
