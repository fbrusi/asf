package br.com.asf.model;

import java.math.BigInteger;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Cacheable
@Table(name = "tb_documents_files")
public class DocumentFile {

	@Id
	@Column(name = "id_document_file", columnDefinition = "BIGINT(20)")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	
	@Column(name = "document_file", nullable = false, length = 5000000)
	private String documentFile;

	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getDocumentFile() {
		return documentFile;
	}

	public void setDocumentFile(String documentFile) {
		this.documentFile = documentFile;
	}
}
