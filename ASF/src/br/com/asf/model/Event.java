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

import br.com.asf.constant.EventType;

@Entity
@Cacheable
@Table(name = "tb_events", uniqueConstraints = {@UniqueConstraint(columnNames = {"type", "date", "id_document", "id_client"})})
public class Event {

	@Id
	@Column(name = "id_event", columnDefinition = "BIGINT(20)")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, updatable = false)
	private EventType type;
	
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

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
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
