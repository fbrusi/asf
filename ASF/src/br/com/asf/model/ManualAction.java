package br.com.asf.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.asf.constant.ActionType;

@Entity
@Cacheable
@Table(name = "tb_manual_actions", uniqueConstraints = {@UniqueConstraint(columnNames = {"type", "date", "id_client", "id_document"})})
public class ManualAction {

	@Id
	@Column(name = "id_action", columnDefinition = "BIGINT(20)")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, updatable = false)
	private ActionType type;
	
	@NotNull
	@Column(nullable = false, updatable = false)
	private LocalDateTime date;
	
	@NotEmpty
	@Column(nullable = false, updatable = false)
	private String description;
	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_client", nullable = false, updatable = false)
	private Client client;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_document", nullable = false, updatable = false)
	private Document document;
	

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public ActionType getType() {
		return type;
	}

	public void setType(ActionType type) {
		this.type = type;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
}
