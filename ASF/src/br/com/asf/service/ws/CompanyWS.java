package br.com.asf.service.ws;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.asf.controller.dao.CompanyDao;
import br.com.asf.model.Company;
import br.com.asf.service.bean.ResponseMessage;

@Stateless
@WebService
public class CompanyWS {

	@Inject
	private CompanyDao companyDao;

	@WebMethod
	public ResponseMessage signUpCompany(
			@WebParam(name = "name")
			String name, 
			@WebParam(name = "cnpj")
			String cnpj) {

		if(name == null || name.isEmpty() || cnpj == null || cnpj.isEmpty()) {
			return new ResponseMessage("Todos os parâmetros são obrigatórios.");
		}
		else if(companyDao.companyExists(cnpj)) {
			return new ResponseMessage("Empresa já está cadastrada.");
		}
		else {
			
			Company company = new Company();
			company.setName(name);
			company.setCnpj(cnpj);
			
			companyDao.saveCompany(company);
			return new ResponseMessage();
		}
	}
	
	@WebMethod
	@WebResult(name = "company")
	public List<Company> getAllCompanies() {
		return companyDao.getAllCompanies();
	}
	
	@WebMethod
	public ResponseMessage removeCompany(
			@WebParam(name = "id")
			String id) {
		
		Company company = new Company();
		company.setId(new BigInteger(id));
		
		companyDao.removeCompany(company);
		
		return new ResponseMessage();
	}
}
