package br.com.asf.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.asf.constant.CurrencyType;
import br.com.asf.constant.FlowStatus;
import br.com.asf.model.listener.DocumentListener;
import br.com.asf.model.validator.DocumentNumber;

@Entity
@Cacheable
@Table(name = "tb_documents")
@EntityListeners(DocumentListener.class)
public class Document {

	@Id
	@Column(name = "id_document", columnDefinition = "BIGINT(20)", updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	
	@Version
	private Integer version; //lock otimista

	@NotEmpty
	@DocumentNumber
	@Column(name = "document_number", nullable = false, unique = true, updatable = false)
	private String documentNumber;
	
	@NotNull
	@Column(nullable = false, columnDefinition = "BIGINT(20)", updatable = false)
	private BigInteger value;
	
	@NotNull
	@Column(name = "foreign_value", nullable = false, columnDefinition = "BIGINT(20)", updatable = false)
	private BigInteger foreignValue;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "currency_type", nullable = false, updatable = false, length = 3)
	private CurrencyType currencyType;
	
	@NotNull
	@Column(name = "create_date", nullable = false, updatable = false)
	private LocalDateTime createDate;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expiration_date", nullable = false, updatable = false)
	private Calendar expirationDate;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "flow_status", nullable = false)
	private FlowStatus flowStatus;
	
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "id_document_file", nullable = false, updatable = false)
	private DocumentFile documentFile;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "id_company_contractor", nullable = false, updatable = false)
	private Company contractor;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "id_company_contracted", nullable = false, updatable = false)
	private Company contracted;
	
	
	@OneToMany(mappedBy = "document")
	private List<ManualAction> manualActions;
	
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

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
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

	public Company getContractor() {
		return contractor;
	}

	public void setContractor(Company contractor) {
		this.contractor = contractor;
	}

	public Company getContracted() {
		return contracted;
	}

	public void setContracted(Company contracted) {
		this.contracted = contracted;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
