package br.com.asf.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Cacheable
@Table(name = "tb_verifications", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_client", "id_document"})})
public class Verification {

	@Id
	@Column(name = "id_verification", columnDefinition = "BIGINT(20)")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	
	@NotEmpty
	@Column(nullable = false, length = 5000000, updatable = false)
	private String verification;
	
	@NotNull
	@Column(nullable = false, updatable = false)
	private LocalDateTime date;
	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_document", nullable = false, updatable = false)
	private Document document;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_client", nullable = false, updatable = false)
	private Client client;

	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
