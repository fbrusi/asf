package br.com.asf.model;

import java.math.BigInteger;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import br.com.asf.constant.Profile;

@Entity
@Cacheable
@Table(name = "tb_clients")
public class Client {

	@Id
	@Column(name = "id_client", columnDefinition = "BIGINT(20)")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	
	@Version
	private Integer version; //lock otimista
	
	@NotEmpty
	@Column(nullable = false)
	private String name;
	
	@CPF
	@NotEmpty
	@Column(nullable = false, unique = true, updatable = false)
	private String cpf;
	
	@Email(message = "{client.error.email}")
	@NotEmpty(message = "{generic.error.empty}")
	@Column(nullable = false, unique = true)
	private String email;
	
	@NotEmpty(message = "{generic.error.empty}")
	@Length(min = 4, message = "{client.error.password.size}")
	@Column(nullable = false)
	private String password;
	
	@Embedded
	private Address address;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, updatable = false)
	private Profile profile;
	
	
	@ManyToOne
	@JoinColumn(name = "id_company")
	private Company company;
	

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
