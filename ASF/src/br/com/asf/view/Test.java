package br.com.asf.view;

import java.math.BigInteger;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.asf.constant.CurrencyType;
import br.com.asf.constant.FlowStatus;
import br.com.asf.controller.repository.CompanyManager;
import br.com.asf.controller.repository.DocumentManager;
import br.com.asf.model.Company;
import br.com.asf.model.Document;
import br.com.asf.model.DocumentFile;

@ManagedBean(name = "test")
public class Test {
	
	@Inject
	private DocumentManager documentManager;
	
	@Inject
	private CompanyManager companyManager;

	public void testSaveDocument() {
		
		DocumentFile documentFile = new DocumentFile();
		documentFile.setDocumentFile("ABCDE");
		
		Company company1 = new Company();
		company1.setId(BigInteger.valueOf(1));
		
		Company company2 = new Company();
		company2.setId(BigInteger.valueOf(2));

		Document document = new Document();
		document.setCurrencyType(CurrencyType.CAD);
		document.setDocumentNumber(Long.valueOf(123456));
		document.setExpirationDate(Calendar.getInstance());
		document.setForeignValue(BigInteger.valueOf(123));
		document.setValue(BigInteger.valueOf(456));
		document.setDocumentFile(documentFile);
		document.setContracted(company1);
		document.setContractor(company2);
		
		documentManager.saveDocument(document);
	}
	
	public void testSaveCompany() {
		
		Company company1 = new Company();
		company1.setCnpj("33479023000180");
		company1.setName("Empresa de teste 01");
		
		Company company2 = new Company();
		company2.setCnpj("44789012000189");
		company2.setName("Empresa de teste 02");
		
		companyManager.saveCompany(company1);
		companyManager.saveCompany(company2);
	}
	
	public void testUpdateCompany() {
		
		Company company = new Company();
		company.setId(BigInteger.valueOf(1));
		company.setCnpj("33479023000180");
		company.setName("Mega empresa!1");
		
		companyManager.updateCompanyInfo(company);
	}
	
	public void testDocumentQuantity() {
		
		System.out.println(documentManager.getDocumentsQuantityByStatus(FlowStatus.AGUARDANDO_CONTRATANTE));
	}
}
