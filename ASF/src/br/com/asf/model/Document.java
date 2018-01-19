package br.com.asf.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.asf.constant.CurrencyType;
import br.com.asf.constant.FlowStatus;

@Entity
@Table(name = "tb_documents")
public class Document {

	@Id
	@Column(name = "id_document", columnDefinition = "BIGINT(20)")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name = "document_number", nullable = false, unique = true)
	private Long documentNumber;
	
	@Column(nullable = false, columnDefinition = "BIGINT(20)")
	private BigInteger value;
	
	@Column(name = "foreign_value", nullable = false, columnDefinition = "BIGINT(20)")
	private BigInteger foreignValue;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "currency_type", nullable = false)
	private CurrencyType currencyType;
	
	@Column(name = "create_date", nullable = false)
	private LocalDateTime createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expiration_date", nullable = false)
	private Calendar expirationDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "flow_status", nullable = false)
	private FlowStatus flowStatus;
	
	
	@OneToOne
	@JoinColumn(name = "id_document_file", nullable = false)
	private DocumentFile documentFile;
	
	@OneToMany(mappedBy = "document")
	private List<ManualAction> manualActions;
	
	@ManyToMany(mappedBy = "documents")
	private List<Company> companies;
	
	@OneToMany(mappedBy = "document")
	private List<Event> events;
	
	@OneToMany(mappedBy = "document")
	private List<Verification> verifications;
	

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Long getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(Long documentNumber) {
		this.documentNumber = documentNumber;
	}

	public BigInteger getValue() {
		return value;
	}

	public void setValue(BigInteger value) {
		this.value = value;
	}

	public BigInteger getForeignValue() {
		return foreignValue;
	}

	public void setForeignValue(BigInteger foreignValue) {
		this.foreignValue = foreignValue;
	}

	public CurrencyType getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(CurrencyType currencyType) {
		this.currencyType = currencyType;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Calendar getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Calendar expirationDate) {
		this.expirationDate = expirationDate;
	}

	public FlowStatus getFlowStatus() {
		return flowStatus;
	}

	public void setFlowStatus(FlowStatus flowStatus) {
		this.flowStatus = flowStatus;
	}

	public DocumentFile getDocumentFile() {
		return documentFile;
	}

	public void setDocumentFile(DocumentFile documentFile) {
		this.documentFile = documentFile;
	}

	public List<ManualAction> getManualActions() {
		return manualActions;
	}

	public void setManualActions(List<ManualAction> manualActions) {
		this.manualActions = manualActions;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Verification> getVerifications() {
		return verifications;
	}

	public void setVerifications(List<Verification> verifications) {
		this.verifications = verifications;
	}
}