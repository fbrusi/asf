package br.com.asf.db.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contracts")
public class Contract {

	@Id
	@Column(name = "id_contract")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "contract_number", nullable = false)
	private Long contractNumber;
	
	@Column(nullable = false)
	private BigInteger value;
	
	@Column(name = "foreign_value", nullable = false)
	private BigInteger foreignValue;
	
	@Column(name = "create_date", nullable = false)
	private Date createDate;
	
	@Column(name = "expiration_date", nullable = false)
	private Date expirationDate;

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

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
}
