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

import br.com.asf.constant.ActionType;

@Entity
@Cacheable
@Table(name = "tb_manual_actions")
public class ManualAction {

	@Id
	@Column(name = "id_action", columnDefinition = "BIGINT(20)")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ActionType type;
	
	@Column(nullable = false)
	private LocalDateTime date;
	
	@Column(nullable = false)
	private String description;
	
	
	@ManyToOne
	@JoinColumn(name = "id_client", nullable = false)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "id_document", nullable = false)
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
