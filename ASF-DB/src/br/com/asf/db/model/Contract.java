package br.com.asf.db.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.asf.constant.CurrencyTypeEnum;
import br.com.asf.db.model.listener.ContractListener;

@Entity
@Table(name = "tb_contracts")
@EntityListeners(ContractListener.class)
public class Contract {

	@Id
	@Column(name = "id_contract", columnDefinition = "BIGINT(20)")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name = "contract_number", nullable = false)
	private Long contractNumber;
	
	@Column(nullable = false, columnDefinition = "BIGINT(20)")
	private BigInteger value;
	
	@Column(name = "foreign_value", nullable = false, columnDefinition = "BIGINT(20)")
	private BigInteger foreignValue;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "currency_type", nullable = false)
	private CurrencyTypeEnum currencyType;
	
	@Column(name = "create_date", nullable = false)
	private LocalDateTime createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expiration_date", nullable = false)
	private Calendar expirationDate;

	public Long getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(Long contractNumber) {
		this.contractNumber = contractNumber;
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

	public BigInteger getId() {
		return id;
	}
	
	public void setId(BigInteger id) {
		this.id = id;
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

	public CurrencyTypeEnum getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(CurrencyTypeEnum currencyType) {
		this.currencyType = currencyType;
	}
}
