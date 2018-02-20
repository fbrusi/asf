package br.com.asf.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.asf.model.Company;
import br.com.asf.service.ws.client.CompanyWS;
import br.com.asf.service.ws.client.CompanyWSService;
import br.com.asf.service.ws.client.ResponseMessage;

@Named
@ViewScoped
public class CompanyManagerBean extends BasicFaces implements Serializable {

	private static final long serialVersionUID = 1L;

	private Company company = new Company();
	
	private br.com.asf.service.ws.client.Company companyToRemove;
	
	private List<br.com.asf.service.ws.client.Company> companies;
	
	public void signUpCompany() {
		
		CompanyWS companyWS = new CompanyWSService().getCompanyWSPort();
		ResponseMessage message = companyWS.signUpCompany(company.getName(), company.getCnpj());
		
		if(message.getCode() == 0) {
			generateMessage(FacesMessage.SEVERITY_INFO, message.getMessage());
		}
		else {
			generateMessage(FacesMessage.SEVERITY_WARN, message.getMessage());
		}
		
		company = new Company();
		companies = companyWS.getAllCompanies();
	}
	
	public void removeCompany() {
		
		CompanyWS companyWS = new CompanyWSService().getCompanyWSPort();
		companyWS.removeCompany(companyToRemove.getId().toString());
		
		companies = companyWS.getAllCompanies();
	}
	
	public List<br.com.asf.service.ws.client.Company> getCompanies() {
		
		if(companies == null || companies.isEmpty()) {
			
			CompanyWS companyWS = new CompanyWSService().getCompanyWSPort();
			companies = companyWS.getAllCompanies();
		}
		
		return companies;
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setCompanies(List<br.com.asf.service.ws.client.Company> companies) {
		this.companies = companies;
	}

	public br.com.asf.service.ws.client.Company getCompanyToRemove() {
		return companyToRemove;
	}

	public void setCompanyToRemove(br.com.asf.service.ws.client.Company companyToRemove) {
		this.companyToRemove = companyToRemove;
	}
}
