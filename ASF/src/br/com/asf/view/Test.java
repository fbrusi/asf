package br.com.asf.view;

import java.math.BigInteger;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.asf.constant.CurrencyType;
import br.com.asf.controller.repository.DocumentManager;
import br.com.asf.model.Document;
import br.com.asf.model.DocumentFile;

@ManagedBean(name = "test")
public class Test {
	
	@Inject
	private DocumentManager documentManager;

	public void executeTest() {
		
		DocumentFile documentFile = new DocumentFile();
		documentFile.setDocumentFile("ABCDE");

		Document document = new Document();
		
		document.setCurrencyType(CurrencyType.CAD);
		document.setDocumentNumber(Long.valueOf(123456));
		document.setExpirationDate(Calendar.getInstance());
		document.setForeignValue(BigInteger.valueOf(123));
		document.setValue(BigInteger.valueOf(456));
		document.setDocumentFile(documentFile);
		
		documentManager.saveDocument(document);
		
		System.out.println("Rodou!");
	}
}
