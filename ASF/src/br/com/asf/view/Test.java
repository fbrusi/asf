package br.com.asf.view;

import java.math.BigInteger;
import java.util.Base64;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.asf.constant.CurrencyType;
import br.com.asf.constant.FlowStatus;
import br.com.asf.controller.repository.ClientManager;
import br.com.asf.controller.repository.CompanyManager;
import br.com.asf.controller.repository.DocumentManager;
import br.com.asf.model.Client;
import br.com.asf.model.Company;
import br.com.asf.model.Document;
import br.com.asf.model.DocumentFile;

@ManagedBean(name = "test")
public class Test {
	
	@Inject
	private DocumentManager documentManager;
	
	@Inject
	private CompanyManager companyManager;
	
	@Inject
	private ClientManager clientManager;

	public void testSaveDocument() {
		
		DocumentFile documentFile = new DocumentFile();
		documentFile.setDocumentFile(new String(Base64.getEncoder().encode("ABCDE".getBytes())));
		
		Company company1 = new Company();
		company1.setId(BigInteger.valueOf(1));
		
		Company company2 = new Company();
		company2.setId(BigInteger.valueOf(2));

		Document document = new Document();
		document.setCurrencyType(CurrencyType.CAD);
		document.setDocumentNumber("A" + Long.valueOf(Calendar.getInstance().getTimeInMillis()).toString() + "Z");
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
		company1.setCnpj("31550888000160");
		company1.setName("Empresa de teste 01");
		
		Company company2 = new Company();
		company2.setCnpj("40176538000176");
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
	
	public void testListCompanies() {
		System.out.println(companyManager.getAllCompanies().size());
	}
	
	public void testSaveClient() {
		
		Company company = new Company();
		company.setId(BigInteger.valueOf(1));
		
		Client client = new Client();
		client.setCpf("31439428867");
		client.setEmail("fernando.brusi@gmail.com");
		client.setName("Fernando Nogueira");
		client.setPassword("1234");
		client.setCompany(company);
		
		clientManager.saveClient(client);
	}
}
