package br.com.asf.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.asf.controller.dao.CompanyDao;
import br.com.asf.model.Company;
import br.com.asf.service.ws.client.CompanyWS;
import br.com.asf.service.ws.client.CompanyWSService;
import br.com.asf.service.ws.client.ResponseMessage;

@Named
@ViewScoped
public class CompanyManagerBean extends BasicFaces implements Serializable {

	private static final long serialVersionUID = 1L;

	private Company company = new Company();
	
	private br.com.asf.service.ws.client.Company companyToRemoveOrEdit = new br.com.asf.service.ws.client.Company();
	
	private List<br.com.asf.service.ws.client.Company> companies;
	
	@Inject
	private CompanyDao companyDao;
	
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
		companyWS.removeCompany(companyToRemoveOrEdit.getId().toString());
		
		companyToRemoveOrEdit = new br.com.asf.service.ws.client.Company();
		companies = companyWS.getAllCompanies();
	}
	
	public void updateCompany() {
		
		Company company = companyDao.getCompanyById(companyToRemoveOrEdit.getId());
		company.setName(companyToRemoveOrEdit.getName());
		
		companyDao.updateCompanyInfo(company);
		
		CompanyWS companyWS = new CompanyWSService().getCompanyWSPort();
		companies = companyWS.getAllCompanies();
		
		companyToRemoveOrEdit = new br.com.asf.service.ws.client.Company();
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

	public br.com.asf.service.ws.client.Company getCompanyToRemoveOrEdit() {
		return companyToRemoveOrEdit;
	}

	public void setCompanyToRemoveOrEdit(br.com.asf.service.ws.client.Company companyToRemoveOrEdit) {
		this.companyToRemoveOrEdit = companyToRemoveOrEdit;
	}
}
